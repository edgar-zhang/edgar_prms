package com.sjn_edgar.prms.dao.shiro.impl;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.dao.common.impl.PermissionBaseDaoImpl;
import com.sjn_edgar.prms.dao.shiro.PmsRoleDao;
import com.sjn_edgar.prms.domain.shiro.PmsRole;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**@Title:     PmsRoleDaoImpl
 * @Description:  <p> 权限角色dao实现 </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/17 13:38 
 */
@Repository
public class PmsRoleDaoImpl extends PermissionBaseDaoImpl<PmsRole> implements PmsRoleDao {

	/**
	 * 获取所有角色列表，以供添加操作员时选择.
	 * @return roleList .
	 */
	public List<PmsRole> listAll() {
		return super.getSqlSession().selectList(getStatement("listAll"));
	}

	/**
	 * 判断此权限是否关联有角色
	 * @param permissionId
	 * @return
	 */
	public List<PmsRole> listByPermissionId(Long permissionId) {
		return super.getSqlSession().selectList(getStatement("listByPermissionId"), permissionId);
	}

	/**
	 * 根据角色名或者角色编号查询角色
	 * 
	 * @param roleName
	 * @param roleCode
	 * @return
	 */
	public PmsRole getByRoleNameOrRoleCode(String roleName, String roleCode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleName", roleName);
		paramMap.put("roleCode", roleCode);
		return super.getSqlSession().selectOne(getStatement("getByRoleNameOrRoleCode"), paramMap);
	}
}
