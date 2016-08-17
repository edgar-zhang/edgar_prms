package com.sjn_edgar.prms.dao.shiro;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.dao.common.PermissionBaseDao;
import com.sjn_edgar.prms.domain.shiro.PmsRolePermission;

import java.util.List;

/**@Title:     PmsRolePermissionDao
 * @Description:  <p> 角色权限dao </p>
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016/8/17 15:14
 */
public interface PmsRolePermissionDao extends PermissionBaseDao<PmsRolePermission> {

	/**
	 * 根据角色ID字符串获取相应角色-权限关联信息.
	 * @param roleIdsStr
	 * @return
	 */
	public List<PmsRolePermission> listByRoleIds(String roleIdsStr);

	/**
	 * 根据角色ID找到角色关联的权限点.
	 * @param roleId
	 * @return rolePermissionList .
	 */
	public List<PmsRolePermission> listByRoleId(final long roleId);





}
