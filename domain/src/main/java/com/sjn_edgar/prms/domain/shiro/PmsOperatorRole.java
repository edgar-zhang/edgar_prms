package com.sjn_edgar.prms.domain.shiro;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
/**@Title:     PmsOperatorRole
 * @Description:  <p> 权限管理-角色,操作员关联表. </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/15 18:09 
 */
public class PmsOperatorRole extends PermissionBaseEntity {

	private static final long serialVersionUID = 174356028197753020L;

	private Long roleId;// 角色ID
	private Long operatorId;// /操作员ID

	/**
	 * 角色ID
	 * 
	 * @return
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 角色ID
	 * 
	 * @return
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 操作员ID
	 * 
	 * @return
	 */
	public Long getOperatorId() {
		return operatorId;
	}

	/**
	 * 操作员ID
	 * 
	 * @return
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public PmsOperatorRole() {

	}

}
