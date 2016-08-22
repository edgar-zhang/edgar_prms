package com.sjn_edgar.prms.payhome.web.login;/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.domain.shiro.PmsOperator;
import com.sjn_edgar.prms.payhome.exception.PermissionException;
import com.sjn_edgar.prms.payhome.web.common.BaseContrller;
import com.sjn_edgar.prms.service.shiro.PmsMenuService;
import com.sjn_edgar.prms.service.shiro.PmsOperatorRoleService;
import com.sjn_edgar.prms.tools.string.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title:登陆控制类 </p>
 * <p>Description:用户登陆控制 </p>
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 16 17:09
 */
@Controller
public class LoginContrller extends BaseContrller{

	//登陆控制器日志记录
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired//操作角色service接口
	private PmsOperatorRoleService pmsOperatorRoleService;

	@Autowired//操作角色service接口
	private PmsMenuService pmsMenuService;


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


	/**
	 * 函数功能说明 ： 登陆后台管理系统.
	 * @参数： @param request
	 * @参数： @param model
	 * @参数： @return
	 * @return String
	 * @throws PermissionException
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest req, Model model) {
		PmsOperator pmsOperator = (PmsOperator) this.getSession().getAttribute("PmsOperator");
		try {
			String tree = this.buildOperatorPermissionMenu(pmsOperator);
			model.addAttribute("tree", tree);
		} catch (PermissionException e) {
			logger.error("登录异常:" + e.getMessage());
			model.addAttribute("message", e.getMessage());
			return "system/login";
		}
		return "system/index";

	}

	/**
	 * 获取用户的菜单权限
	 * @param pmsOperator
	 * @return
	 * @throws PermissionException
	 * @throws Exception
	 */
	private String buildOperatorPermissionMenu(PmsOperator pmsOperator) throws PermissionException {
		// 根据用户ID得到该用户的所有角色拼成的字符串
		String roleIds = pmsOperatorRoleService.getRoleIdsByOperatorId(pmsOperator.getId());
		if (org.apache.commons.lang.StringUtils.isBlank(roleIds)) {
			logger.error("==>用户[" + pmsOperator.getLoginName() + "]没有配置对应的权限角色");
			throw new RuntimeException("该帐号已被取消所有系统权限");
		}
		// 根据操作员拥有的角色ID,构建管理后台的树形权限功能菜单
		return this.buildPermissionTree(roleIds);
	}

	/**
	 * 根据操作员拥有的角色ID,构建管理后台的树形权限功能菜单
	 * @param roleIds
	 * @return
	 * @throws PermissionException
	 */
	@SuppressWarnings("rawtypes")
	public String buildPermissionTree(String roleIds) throws PermissionException {
		List treeData = null;
		try {
			treeData = pmsMenuService.listByRoleIds(roleIds);
			if (StringUtils.isEmpty(treeData)) {
				logger.error("用户没有分配菜单权限");
				throw new PermissionException(PermissionException.PERMISSION_USER_NOT_MENU, "该用户没有分配菜单权限"); // 该用户没有分配菜单权限
			}
		} catch (Exception e) {
			logger.error("根据角色查询菜单出现错误", e);
			throw new PermissionException(PermissionException.PERMISSION_QUERY_MENU_BY_ROLE_ERROR, "根据角色查询菜单出现错误"); // 查询当前角色的
		}
		StringBuffer strJson = new StringBuffer();
		buildAdminPermissionTree("0", strJson, treeData);
		return strJson.toString();
	}

	/**
	 * 构建管理后台的树形权限功能菜单
	 * @param pId
	 * @param treeBuf
	 * @param menuList
	 */
	@SuppressWarnings("rawtypes")
	private void buildAdminPermissionTree(String pId, StringBuffer treeBuf, List menuList) {

		List<Map> listMap = getSonMenuListByPid(pId.toString(), menuList);
		for (Map map : listMap) {
			String id = map.get("id").toString();// id
			String name = map.get("name").toString();// 名称
			String isLeaf = map.get("isLeaf").toString();// 是否叶子
			String level = map.get("level").toString();// 菜单层级（1、2、3、4）
			String url = map.get("url").toString(); // ACTION访问地址
			String navTabId = "";
			if (StringUtils.isEmpty(map.get("targetName"))) {
				navTabId = map.get("targetName").toString(); // 用于刷新查询页面
			}

			if ("1".equals(level)) {
				treeBuf.append("<div class='accordionHeader'>");
				treeBuf.append("<h2> <span>Folder</span> " + name + "</h2>");
				treeBuf.append("</div>");
				treeBuf.append("<div class='accordionContent'>");
			}

			if ("YES".equals(isLeaf)) {
				treeBuf.append("<li><a href='" + url + "' target='navTab' rel='" + navTabId + "'>" + name + "</a></li>");
			} else {

				if ("1".equals(level)) {
					treeBuf.append("<ul class='tree treeFolder'>");
				} else {
					treeBuf.append("<li><a>" + name + "</a>");
					treeBuf.append("<ul>");
				}
				buildAdminPermissionTree(id, treeBuf, menuList);

				if ("1".equals(level)) {
					treeBuf.append("</ul>");
				} else {
					treeBuf.append("</ul></li>");
				}
			}

			if ("1".equals(level)) {
				treeBuf.append("</div>");
			}
		}
	}

	/**
	 * 根据(pId)获取(menuList)中的所有子菜单集合.
	 * @param pId  父菜单ID.
	 * @param menuList  菜单集合.
	 * @return sonMenuList.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Map> getSonMenuListByPid(String pId, List menuList) {
		List sonMenuList = new ArrayList<Object>();
		for (Object menu : menuList) {
			Map map = (Map) menu;
			if (map != null) {
				String parentId = map.get("pId").toString();// 父id
				if (parentId.equals(pId)) {
					sonMenuList.add(map);
				}
			}
		}
		return sonMenuList;
	}

}
