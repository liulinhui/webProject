package com.learn.web.controller.graduation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.learn.bean.graduation.Asset;
import com.learn.bean.graduation.Order;
import com.learn.bean.graduation.RealUser;
import com.learn.web.service.graduation.AssetService;
import com.learn.web.service.graduation.OrderService;
import com.learn.web.service.graduation.RealUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OtcController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private RealUserService realUserService;
	@Autowired
	private OrderService orderservice;
	@Autowired
	private AssetService assetservice;
	
	/**
	 * 用户订拥有的产品页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/myproduct")
	public String myproduct(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		List<Asset>assets=assetservice.selectAvaliable(request.getSession().getAttribute("user_code").toString());
		model.addAttribute("assets", assets);
		return "myproduct1.ftl";
	}
	/**
	 * 用户资产信息
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/myAsset")
	public String myAsset(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		RealUser user=new RealUser();
		user=realUserService.selectByCode((String)request.getSession().getAttribute("user_code"));   //获取用户详细信息
		String time=user.getReg_time().substring(0, 19);                                           //获取注册时间
		user.setReg_time(time);
		logger.info("========注册时间："+user.getReg_time()+"===========");
		model.addAttribute("user",user);
		logger.info("=================用户"+user.getUser_name()+"信息采集成功===============");
		List<Asset>assets=assetservice.selectAll(request.getSession().getAttribute("user_code").toString());
		int account=assets.size();
		model.addAttribute("assets", assets);
		model.addAttribute("account", account);
		return "myAsset.ftl";
	}
	
	/**
	 * 用户订单详情页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/myOrder")
	public String myOrder(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		String user_code=request.getSession().getAttribute("user_code").toString();
		List<Order>order=orderservice.selectAll(user_code);
		model.addAttribute("order", order);
		return "myOrder.ftl";
	}
	
	/**
	 * 确认页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/confirm")
	public String confirm(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		return "confirm.ftl";
	}
	
	/**
	 * 注销登录
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			String user_code=null;
			request.getSession().setAttribute("user_code",user_code);
			request.getSession().setAttribute("returnUrl",user_code);
			logger.info("----登录信息已经被清除----");
		}
		return "redirect:/otc";
	}
	
	/**
	 * 转让确认页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/transfer_confirm")
	public String transfer_confirm(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		return "transfer_confirm.ftl";
	}
	
	/**
	 * 充值页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/AccountRecharge")
	public String AccountRecharge(Model model, HttpServletRequest request) {
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");		
		String user_returnUrl = request.getParameter("returnUrl");
		if (user_code == null | user_password == null) {
			
			user_returnUrl = "AccountRecharge.ftl";
		}else {
			Double amount = Double.parseDouble(request.getParameter("amount"));
			System.out.println("----------输入充值的数量为："+amount);
			RealUser user1 = new RealUser();
			Double oldAsset=realUserService.selectByCode(user_code).getUser_asset();
			user1.setUser_code(user_code);
			user1.setUser_password(user_password);
			user1.setUser_asset(amount+oldAsset);
			realUserService.update(user1);
			user_returnUrl = "redirect:/myAsset";
		}
		return user_returnUrl;
	}


}
