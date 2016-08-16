package com.sjn_edgar.prms.payhome.web.common;/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * <p>Title:控制器基类 </p>
 * <p>Description: </p>
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 16 17:10
 */
public abstract class BaseContrller {


	/**
	 * 获取shiro 的session
	 * @return
	 */
	protected Session getSession() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		return session;
	}

	/**
	 * 获取当前用户信息
	 *
	 * @return
	 */
	/*protected PmsOperator getPmsOperator() {
		PmsOperator operator = (PmsOperator) this.getSession().getAttribute("PmsOperator");
		return operator;
	}
*/


}
