package com.learn.web.controller.graduation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.learn.bean.graduation.*;
import com.learn.graduation.MD5;
import com.learn.graduation.RSAUtil;
import com.learn.graduation.TransPinYin;
import com.learn.graduation.fuzzyMatch;
import com.learn.web.service.graduation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;

@Controller
public class ajaxcontroller {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    MD5 MD5 = new MD5();
    ControllerHelp controllerhellp = new ControllerHelp();
    @Autowired
    private RealUserService realUserService;
    @Autowired
    private ProductService productService;
    @Autowired
    private AssetService assetService;
    @Autowired
    private OrderService orderservice;
    @Autowired
    private OldProductService oldProductService;
    fuzzyMatch fuzzy;
    TransPinYin transPinYinin = new TransPinYin();

    /* 登录页面请求产生密钥 */
    @RequestMapping(value = "/ajaxAccount_login")
    @ResponseBody
    public JSONObject ajaxAccount_login(Model model, HttpServletRequest request) {
        String timeString = controllerhellp.Reg_time();
        String key1 = MD5.GetMD5Iterator(
                timeString.substring(0, 5) + Math.random() * 10000, 5); // 获取随机密钥key1，key2，key3
        String key2 = MD5.GetMD5Iterator(
                timeString.substring(5, 11) + Math.random() * 10000, 5); // 密钥用md5加密防止被人发现规律
        String key3 = MD5.GetMD5Iterator(
                timeString.substring(11, 19) + Math.random() * 10000, 5);
        request.getSession().setAttribute("key1", key1); // 将密钥存入session里面
        request.getSession().setAttribute("key2", key2);
        request.getSession().setAttribute("key3", key3);
        JSONObject jsonObject = new JSONObject(); // 创建session
        jsonObject.put("key1", key1);
        jsonObject.put("key2", key2);
        jsonObject.put("key3", key3);
        return jsonObject;
    }

    /* 判断用户名是否重复 */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/codeConfirm")
    @ResponseBody
    public JSONObject codeConfirm(Model model, HttpServletRequest request) {
        String usercode = request.getParameter("usercode");
        String status = new String("noexist");
        try {
            List<String> allUsercode = realUserService
                    .selectAllUsercode(usercode);
            if (allUsercode.size() == 1) {
                status = "exist";
            }
        } catch (Exception e) {
            status = "noexist";
        } finally {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", status);
            logger.info("========================================="
                    + jsonObject.toJSONString());
            return jsonObject;
        }

    }

    /* 获取RSA的公钥 */
    @RequestMapping(value = "/getPublicKey")
    @ResponseBody
    public static JSONObject getPublicKey(Model model,
                                          HttpServletRequest request) throws Exception {
        String pubilcKey;
        pubilcKey = RSAUtil.getPublickModulus();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pubilcKey", pubilcKey);
        return jsonObject;
    }

    /**
     * 判断购买数量是否超出范围,提交订单
     */
    @RequestMapping(value = "/confirmAccount")
    @ResponseBody
    public JSONObject confirmAccount(Model model, HttpServletRequest request) {
        int allAccount = Integer.parseInt(request.getParameter("allAccount"));
        String id = request.getParameter("id");
        Double total_money = Double.parseDouble(request.getParameter("total_money"));
        Product product = productService.selectById(id);
        JSONObject jsonObject = new JSONObject();
        if (orderservice.seleOrderById(id) != null) {
            jsonObject.put("result", "had");
            return jsonObject;
        }
        if (allAccount > product.getRest_account()) {
            jsonObject.put("result", "false");

        } else if (allAccount <= product.getRest_account()) {
            Order order = new Order();
            order.setId(product.getId());
            order.setBuy_amount(allAccount);
            order.setTotal_money(total_money);
            order.setBuy_time(controllerhellp.Reg_time());
            order.setLimit_time(product.getLimit_time());
            order.setProduct_code(product.getProduct_code());
            order.setPrice(product.getTransfer_price());
            order.setProduct_name(product.getProduct_name());
            order.setReference_income(product.getReference_income());
            order.setRisk(product.getRisk());
            order.setStatus('1');
            order.setUser_code(request.getSession().getAttribute("user_code")
                    .toString());
            orderservice.insert(order);
            jsonObject.put("result", "true");
        }
        return jsonObject;
    }

    /**
     * 删除或者取消订单
     */
    @RequestMapping(value = "/deleteOrder")
    @ResponseBody
    public JSONObject deleteOrder(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        String result = "true";
        try {
            orderservice.insertOldOrder(orderservice.seleOrderById(id));
            orderservice.deleteOrder(id);
        } catch (Exception e) {
            e.printStackTrace();
            result = "false";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;

    }

    /**
     * 查询撤销产品
     */
    @RequestMapping(value = "/choseCancelPro")
    @ResponseBody
    public JSONObject choseCancelPro(Model model, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        Product product = productService.selectById(id);
        jsonObject.put("product", product);
        return jsonObject;
    }

    /**
     * 模糊匹配
     */
    @SuppressWarnings("static-access")
    @RequestMapping(value = "/fuzzyMatch")
    @ResponseBody
    public JSONObject fuzzyMatch(Model model, HttpServletRequest request) throws Exception {
        String info = request.getParameter("info");
        JSONObject jsonObject = new JSONObject();
        List<FuzzyMatch> fuzzyMatchs = productService.selectMatchs();
        List<FuzzyMatch> matchs = new ArrayList<FuzzyMatch>();
        if (info.equals("")) {
            return null;
        }
        for (FuzzyMatch fuzzyMatch : fuzzyMatchs) {
            String combain = fuzzyMatch.getProduct_code() + transPinYinin.trans2PinYin(fuzzyMatch.getProduct_name()) + fuzzyMatch.getProduct_name();
            if (fuzzy.match(info, combain)) {
                matchs.add(fuzzyMatch);
            }
        }
        jsonObject.put("matchs", matchs);
        return jsonObject;
    }

    /**
     * 撤单
     */
    @RequestMapping(value = "/cancelProduct")
    @ResponseBody
    public JSONObject cancelProduct(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        String result = "true";
        try {
            Product product = productService.selectById(id);
            oldProductService.insertOldProduct(product);
            assetService.updateStatus(id);
            orderservice.updateOrder(id);
            productService.cancel(id);

        } catch (Exception e) {
            e.printStackTrace();
            result = "false";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }

    /**
     * 获取支付信息支付
     */
    @RequestMapping(value = "/pay")
    @ResponseBody
    public JSONObject pay(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        Order order = orderservice.seleOrderById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("order", order);
        return jsonObject;
    }

    /**
     * 确认购买
     */
    @RequestMapping(value = "/confirmPay")
    @ResponseBody
    public JSONObject confirmPay(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        JSONObject jsonObject = new JSONObject();
        String state = "true";
        Order order = orderservice.seleOrderById(id);
        BigDecimal TotalAccount = new BigDecimal(order.getTotal_money());   //需要支付的金额
        BigDecimal Asset = new BigDecimal((double) realUserService.selectByCode(request.getSession().getAttribute("user_code").toString()).getUser_asset());  //用户拥有的金额
        if (TotalAccount.compareTo(Asset) == 1) {             //资金不足
            state = "false";
            jsonObject.put("result", state);
            return jsonObject;
        }
        Product product = productService.selectById(id);
        product.setRest_account(product.getTransfer_account() - order.getBuy_amount());
        if (product.getRest_account() == 0) {      //买完了
            product.setState('2');
        }
        RealUser realUser = realUserService.selectByCode(request.getSession().getAttribute("user_code").toString());//买家
        RealUser realUser2 = realUserService.selectByCode(product.getUser_code());      //卖家
        realUser2.setUser_asset(realUser2.getUser_asset() + order.getTotal_money());  //计算卖家资产
        realUserService.update(realUser2);               //更新卖家资产
        logger.info("===============更新买家资产" + realUser2.getUser_asset());
        realUser.setUser_asset(realUser.getUser_asset() - order.getTotal_money());  //计算买家资产
        realUserService.update(realUser);    //更新用户资产
        logger.info("================更新买家资产" + realUser);
        productService.update(product);     //更新转让市场产品信息
        logger.info("===============更新转让市场产品信息" + product.getRest_account());
        //更新个人产品
        Asset asset = new Asset();
        asset.setId(MD5.GetMD5Code(Long.toString(System.currentTimeMillis())));
        asset.setUser_name(realUser.getUser_name());
        asset.setUser_code(realUser.getUser_code());
        asset.setProduct_name(product.getProduct_name());
        asset.setProduct_code(product.getProduct_code());
        asset.setLimit_time(product.getLimit_time());
        asset.setAccount(order.getBuy_amount());
        asset.setBuy_time(controllerhellp.Reg_time());
        asset.setRisk(product.getRisk());
        asset.setStatus('1');
        asset.setPlan_income(product.getPlan_income());
        assetService.insertProduct(asset);
        logger.info("==================更新个人资产的产品表" + asset.getProduct_name());
        //更新order列表的产品状态  1：为付款  2：已经支付了   3：过期了
        order.setStatus('2');
        orderservice.updateOrderBuy(order);
        logger.info("==================更新订单相应的产品购买状态" + order.getStatus());
        jsonObject.put("result", state);
        return jsonObject;
    }

    /**
     * 转让功能的实现
     */
    @RequestMapping(value = "/exchange")
    @ResponseBody
    public JSONObject exchange(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        int account = Integer.parseInt(request.getParameter("account"));
        double price = Double.parseDouble(request.getParameter("price"));
        double Account_income = Double.parseDouble(request.getParameter("Account_income"));
        double reference_income = Double.parseDouble(request.getParameter("reference_income"));
        JSONObject jsonObject = new JSONObject();
        Product product = new Product();
        Asset asset = assetService.selectProductById(id);
        //设置发布产品的信息
        product.setId(id);
        product.setUser_code(request.getSession().getAttribute("user_code").toString());
        product.setProduct_name(asset.getProduct_name());
        product.setProduct_code(asset.getProduct_code());
        product.setPlan_income(asset.getPlan_income());
        product.setReference_income(reference_income);
        product.setLimit_time(asset.getLimit_time());
        product.setTransfer_price(price);
        product.setTransfer_account(account);
        product.setTransfer_capital(Account_income);
        product.setRisk(asset.getRisk());
        product.setState('1');
        product.setLastdate("");
        product.setPublic_date(controllerhellp.Reg_time_());
        product.setRest_account(account);
        productService.insert(product);
        //判断转让后是否有剩余
        int resAccount = asset.getAccount() - account;
        //如果有剩余的，把剩余的产品ID改了
        if (resAccount > 0) {
            Asset asset2 = assetService.selectProductById(id);
            asset.setAccount(account);
            asset.setStatus('2');
            assetService.updateAccount(asset);
            MD5 md5 = new MD5();
            asset2.setId(md5.GetMD5Code(controllerhellp.Reg_time()));
            asset2.setAccount(resAccount);
            assetService.insertProduct(asset2);
            jsonObject.put("result", "true");
        } else {
            asset.setStatus('2');
            assetService.updateAccount(asset);
            jsonObject.put("result", "true");
        }
        return jsonObject;
    }

}
