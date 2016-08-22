package com.sjn_edgar.prms.domain.shiro;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

 /**@Title:      权限管理-角色权限关联表..
 * @Description:  <p> </p>
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016-8-22 10:56:21
 */
public class PmsMenuRole extends PermissionBaseEntity {

	private static final long serialVersionUID = -9012707031072904356L;

	/** 角色ID **/
	private Long roleId;

	/** 菜单ID **/
	private Long menuId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
