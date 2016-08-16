package com.sjn_edgar.prms.payhome.web.login;/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import com.sjn_edgar.prms.payhome.exception.PermissionException;
import com.sjn_edgar.prms.payhome.web.common.BaseContrller;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title:登陆控制类 </p>
 * <p>Description:用户登陆控制 </p>
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 16 17:09
 */
@Controller
public class LoginContrller extends BaseContrller{

	/**
	 * 函数功能说明 ： 进入后台登陆页面.
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest req, Model model) {

		String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (PermissionException.class.getName().equals(exceptionClassName)) {
			error = "网络异常,请联系龙果管理员";
		} else if (exceptionClassName != null) {
			error = "错误提示：" + exceptionClassName;
		}
		model.addAttribute("message", error);
		return "system/login";
	}



}
