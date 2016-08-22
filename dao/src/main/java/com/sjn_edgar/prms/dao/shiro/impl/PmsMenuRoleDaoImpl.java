package com.sjn_edgar.prms.dao.shiro.impl;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.dao.common.impl.PermissionBaseDaoImpl;
import com.sjn_edgar.prms.dao.shiro.PmsMenuRoleDao;
import com.sjn_edgar.prms.domain.shiro.PmsMenuRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**@Title:     菜单角色
 * @Description:
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016-8-22 11:41:41
 */
@Repository("pmsRoleMenuDao")
public class PmsMenuRoleDaoImpl extends PermissionBaseDaoImpl<PmsMenuRole> implements PmsMenuRoleDao {

	/**
	 * 根据角色id删除角色
	 * @param roleId
	 */
	@Override
	public void deleteByRoleId(Long roleId) {
		super.getSqlSession().delete(getStatement("deleteByRoleId"), roleId);
	}

	/**
	 * 根据角色ID统计关联到此角色的菜单数.
	 * @param roleId 角色ID.
	 * @return count.
	 */
	@Override
	public List<PmsMenuRole> listByRoleId(Long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}
}