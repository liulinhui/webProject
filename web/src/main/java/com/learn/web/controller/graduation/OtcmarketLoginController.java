package com.learn.web.controller.graduation;

import java.math.BigInteger;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.learn.bean.graduation.Asset;
import com.learn.bean.graduation.Product;
import com.learn.bean.graduation.RealUser;
import com.learn.graduation.DES;
import com.learn.graduation.MD5;
import com.learn.graduation.RSAUtil;
import com.learn.graduation.desToJs;
import com.learn.web.service.graduation.AssetService;
import com.learn.web.service.graduation.ProductService;
import com.learn.web.service.graduation.RealUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtcmarketLoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(OtcmarketLoginController.class);
	@Autowired
	private ProductService productService;
	@Autowired
	private RealUserService realUserService;
	@Autowired
	private AssetService assetService;
	ControllerHelp controllerhellp = new ControllerHelp();
	DES des = new DES();
	MD5 MD5 = new MD5();

	/**
	 * 购买详情页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/buy")
	public String otc_buy(Model model, HttpServletRequest request)
			throws Exception {
		if (request.getSession() != null) { // 判断是否登录
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		String returnUrl = new String(); // 设置返回的页面
		String id = request.getParameter("id"); // 获取产品编号
		char[] state = request.getParameter("status").toCharArray(); // 获取产品状态
		Product product = productService.selectById(id);
		// 计算到期时间
		String smdate = controllerhellp.Reg_time_();
		String bdate = product.getLimit_time();
		String lasttime = controllerhellp.daysBetween(smdate, bdate);
		product.setLastdate(lasttime);
		logger.info("查询" + product.getProduct_name() + "相应信息===用户代码："
				+ product.getUser_code());
		model.addAttribute("product", product);
		if (request.getSession().getAttribute("user_code") != null
				&& state[0] == '1') {
			RealUser realUser = realUserService.selectByCode(request
					.getSession().getAttribute("user_code").toString()); // 查询用户资金
			Double RestMoney = realUser.getUser_asset();
			logger.info("============================================="
					+ RestMoney);
			model.addAttribute("RestMoney", RestMoney);
			returnUrl = "otc_buy.ftl";
		}
		if (request.getSession().getAttribute("user_code") == null
				&& state[0] == '1') {
			returnUrl = "otc_buy_login.ftl";
		}
		if (state[0] == '2') {
			returnUrl = "otc_saleout.ftl";
		}

		return returnUrl;
	}

	/**
	 * 转让页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sell")
	public String sell(Model model, HttpServletRequest request) {
		if (request.getSession() != null) { // 判断用户登录状态
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		String id=request.getParameter("id");
		Asset asset=assetService.selectProductById(id);
		model.addAttribute("asset", asset);
		return "otc_sell.ftl";
	}

	/**
	 * 相关协议页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/protocol")
	public String protocol(Model model, HttpServletRequest request) {
		if (request.getSession() != null) { // 判断用户登录状态
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		return "permission.ftl";
	}

	/**
	 * 转让OTC首页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/otc")
	public String otc(Model model, HttpServletRequest request) throws Exception {
		if (request.getSession() != null) { // 判断用户登录状态
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		List<Product> products = new ArrayList<Product>();
		products = productService.selectAll(); // 获取所有产品信息
		for (Product product : products) {
			// 获取剩余到期时间
			String smdate = controllerhellp.Reg_time_();
			String bdate = product.getLimit_time();
			String lasttime = controllerhellp.daysBetween(smdate, bdate);
			product.setLastdate(lasttime);
			if (product.getUser_code().equals( // 确定可撤销的产品
					request.getSession().getAttribute("user_code"))
					&& product.getState() == '1') {
				product.setState('0');
			}
			// 加密
			String userString = des.encrypt("dfwefrvsefadfereqfdbs",
					product.getUser_code());
			product.setUser_code(userString);
			// logger.info("啦啦啦啦========加密后的user_code=============="
			// + product.getUser_code());
		}
		model.addAttribute("products", products);
		return "index1.ftl";
	}

	/**
	 * 登录界面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account_Login")
	public String account_Login(Model model, HttpServletRequest request) {
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");
		String returnUrl = request.getParameter("returnUrl"); // 从页面传来的URL值
		String ID = request.getParameter("id"); // 购买页面传来的商品ID
		String user_returnUrl = new String();
		if (ID == null) {
			returnUrl = "/otc";
		}
		if (ID != null) { // 判断是否下一个页面为购买页面
			returnUrl = returnUrl + "&id=" + ID;
			Product product1 = productService.selectById(ID);   //验证产品用户是否拥有
			if (product1.getUser_code()==(user_code)) {
				returnUrl = "/otc";
			}
		}
		user_returnUrl = (String) request.getSession()
				.getAttribute("returnUrl");
		if (user_returnUrl == null) {
			request.getSession().setAttribute("returnUrl", returnUrl);
			user_returnUrl = (String) request.getSession().getAttribute(
					"returnUrl");
		}
		logger.info("session里存入的地址："
				+ request.getSession(false).getAttribute("returnUrl"));
		if (user_code == null || user_password == null) {
			logger.info("-----------没有输入用户名密码");
			return "account_Login.ftl";
		} else {
			RealUser realuser = realUserService.selectByCode(user_code);
			logger.info("-----后台取到用户数据，检验用户登录");
			String key1 = (String) request.getSession().getAttribute("key1"); // 取得密钥
			String key2 = (String) request.getSession().getAttribute("key2");
			String key3 = (String) request.getSession().getAttribute("key3");
			System.out.println("key1:"+key1);
			System.out.println("key2:"+key2);
			System.out.println("key3:"+key3);
			String Password = realuser.getUser_password(); // 数据库获取用户密码
			System.out.println("页面传来的加密密码:"+user_password);
			System.out.println("数据库内保存的密码:"+Password);
			desToJs desToJs = new desToJs();
			Password = desToJs.strEnc(Password, key1, key2, key3); // 密码加密
			Password = MD5.GetMD5Iterator(Password, 100); // md5加密100次
			System.out.println("数据内密码加密后:"+Password);
			if (user_password.equals(Password)) {
				logger.info("用户：" + user_code + " 已登录！");
				request.getSession().setAttribute("user_code", user_code);
			} else if (!user_password.equals(realuser.getUser_password())) {
				String errorMes = "输入用户名或密码错误，请重新输入！";
				model.addAttribute("errorMes", errorMes);
				return "Error.ftl";
			}
		}
		return "redirect:" + user_returnUrl;
	}

	/**
	 * 注册页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/account_Reg")
	public String account_Reg(Model model, HttpServletRequest request)
			throws Exception {
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");
		String user_returnUrl = request.getParameter("returnUrl");
		String reg_time = controllerhellp.Reg_time(); // 获取注册时间
		if (user_code == null || user_password == null || user_name == null) {
			user_returnUrl = "account_Reg.ftl";
		} else {
			RealUser user1 = new RealUser();
			/** 对密码进行解密 **/
			byte[] en_result = new BigInteger(user_password, 16).toByteArray();
			byte[] de_result = RSAUtil.decrypt(RSAUtil.getKeyPair()
					.getPrivate(), en_result);
			logger.info("===============================还原密文:"
					+ new String(de_result));
			StringBuffer sb = new StringBuffer();
			sb.append(new String(de_result));
			user_password = sb.reverse().toString(); // 逆序处理
			user_password = URLDecoder.decode(user_password, "UTF-8"); // 转码为UTF-8
			user1.setUser_code(user_code);
			user1.setUser_password(user_password);
			user1.setUser_name(user_name);
			user1.setReg_time(reg_time);
			realUserService.insert(user1);
			logger.info("用户名：" + user_name + "密码：" + user_password + "用户账号"
					+ user_code + "注册时间" + reg_time);
			logger.info("注册好了");
			user_returnUrl = "redirect:/account_Login";
		}
		return user_returnUrl;
	}
}
