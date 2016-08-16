package com.sjn_edgar.prms.domain.permission;

/**@Title:     PmsRolePermission
 * @Description:  <p> 权限管理-角色权限关联表. </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/16 10:24 
 */
public class PmsRolePermission extends PermissionBaseEntity {

	private static final long serialVersionUID = -9012707031072904356L;
	private Long roleId; // 角色ID
	private Long permissionId;// 权限ID

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
	 * 权限ID
	 * 
	 * @return
	 */
	public Long getPermissionId() {
		return permissionId;
	}

	/**
	 * 权限ID
	 * 
	 * @return
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public PmsRolePermission() {
		super();
	}

}
