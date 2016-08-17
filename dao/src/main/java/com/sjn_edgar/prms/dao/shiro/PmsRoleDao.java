package com.sjn_edgar.prms.dao.shiro;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.dao.common.PermissionBaseDao;
import com.sjn_edgar.prms.domain.shiro.PmsRole;

import java.util.List;

/**@Title:     PmsRoleDao
 * @Description:  <p> 权限角色dao </p>
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016/8/17 13:37
 */
public interface PmsRoleDao extends PermissionBaseDao<PmsRole> {

	/**
	 * 获取所有角色列表，以供添加操作员时选择.
	 * @return roleList .
	 */
	public List<PmsRole> listAll();

	/**
	 * 判断此权限是否关联有角色
	 * @param permissionId
	 * @return
	 */
	public List<PmsRole> listByPermissionId(Long permissionId);

	/**
	 * 根据角色名或者角色编号查询角色
	 * @param roleName
	 * @param roleCode
	 * @return
	 */
	public PmsRole getByRoleNameOrRoleCode(String roleName, String roleCode);

}
