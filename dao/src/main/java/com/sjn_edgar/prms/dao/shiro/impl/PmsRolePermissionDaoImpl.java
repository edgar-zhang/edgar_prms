package com.sjn_edgar.prms.dao.shiro.impl;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import com.sjn_edgar.prms.dao.common.impl.PermissionBaseDaoImpl;
import com.sjn_edgar.prms.dao.shiro.PmsRolePermissionDao;
import com.sjn_edgar.prms.domain.shiro.PmsRolePermission;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**@Title:     PmsRolePermissionDaoImpl
 * @Description:  <p> 权限-角色与权限点dao实现 </p>
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016/8/17 15:29
 */
@Repository
public class PmsRolePermissionDaoImpl extends PermissionBaseDaoImpl<PmsRolePermission> implements PmsRolePermissionDao {

	/**
	 * 根据角色ID字符串获取相应角色-权限关联信息.
	 * @param roleIdsStr
	 * @return
	 */
	public List<PmsRolePermission> listByRoleIds(String roleIdsStr) {
		List<String> roldIds = Arrays.asList(roleIdsStr.split(","));
		return super.getSqlSession().selectList(getStatement("listByRoleIds"), roldIds);
	}

	/**
	 * 根据角色ID找到角色关联的权限点.
	 * @param roleId
	 * @return rolePermissionList .
	 */
	public List<PmsRolePermission> listByRoleId(final long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}

}
