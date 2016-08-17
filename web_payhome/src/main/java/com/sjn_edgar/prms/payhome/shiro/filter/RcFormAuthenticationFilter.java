package com.sjn_edgar.prms.payhome.shiro.filter;/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>Title:自定义基于Form表单身份验证过滤器 </p>
 * <p>Description: 基于Form表单的身份验证过滤器，为了控制验证码</p>
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 17 11:13
 */
public class RcFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		if (request.getAttribute(getFailureKeyAttribute()) != null) {
			return true;
		}
		return super.onAccessDenied(request, response, mappedValue);
	}
}
