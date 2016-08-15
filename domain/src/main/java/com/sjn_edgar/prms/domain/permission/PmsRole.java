package com.sjn_edgar.prms.domain.permission;

/**@Title:     PmsRole
 * @Description:  <p> 权限管理-角色</p>
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016/8/15 18:08
 */
public class PmsRole extends PermissionBaseEntity {

	private static final long serialVersionUID = -1850274607153125161L;
	private String roleCode; // 角色编码：例如：admin
	private String roleName; // 角色名称

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * 角色名称
	 * 
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 角色名称
	 * 
	 * @return
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public PmsRole() {

	}
}
