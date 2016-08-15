package com.sjn_edgar.prms.home.web.controller.common;

import com.sjn_edgar.prms.common.dwz.DWZ;
import com.sjn_edgar.prms.common.dwz.DwzAjax;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;


/**@Title:     controller基类
 * @Description:  <p>  </p>
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016/8/15 17:34
 */
public abstract class BaseController {

	/**
	 * 获取shiro 的session
	 * 
	 * @return
	 */
	protected Session getSession() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		return session;
	}

	/**
	 * 获取当前用户信息(当前用户所拥有的权限)
	 * 
	 * @return
	 */
	protected PmsOperator getPmsOperator() {
		PmsOperator operator = (PmsOperator) this.getSession().getAttribute("PmsOperator");
		return operator;
	}

	/**
	 * 响应DWZ的ajax失败请求,跳转到ajaxDone视图.
	 * 
	 * @param message
	 *            提示消息.
	 * @param model
	 *            model.
	 * @return ajaxDone .
	 */
	protected String operateError(String message, Model model) {
		DwzAjax dwz = new DwzAjax();
		dwz.setStatusCode(DWZ.ERROR);
		dwz.setMessage(message);
		model.addAttribute("dwz", dwz);
		return "common/ajaxDone";
	}

	/**
	 * 响应DWZ的ajax失败成功,跳转到ajaxDone视图.
	 * 
	 * @param model
	 *            model.
	 * @param dwz
	 *            页面传过来的dwz参数
	 * @return ajaxDone .
	 */
	protected String operateSuccess(Model model, DwzAjax dwz) {
		dwz.setStatusCode(DWZ.SUCCESS);
		dwz.setMessage("操作成功");
		model.addAttribute("dwz", dwz);
		return "common/ajaxDone";
	}

}
