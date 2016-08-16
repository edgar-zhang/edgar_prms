package com.sjn_edgar.prms.domain.permission;

/**@Title:     PmsPermission
 * @Description:  <p> 权限-权限表实体.. </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/16 10:18 
 */
public class PmsPermission extends PermissionBaseEntity {

	private static final long serialVersionUID = -2175597348886393330L;
	private String permissionName; // 权限名称
	private String permission; // 权限标识

	/**
	 * 权限名称
	 * 
	 * @return
	 */
	public String getPermissionName() {
		return permissionName;
	}

	/**
	 * 权限名称
	 * 
	 * @return
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	/**
	 * 权限标识
	 * 
	 * @return
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * 权限标识
	 * 
	 * @return
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

}
