package com.sjn_edgar.prms.dao.shiro;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import com.sjn_edgar.prms.dao.common.PermissionBaseDao;
import com.sjn_edgar.prms.domain.shiro.PmsPermission;

import java.util.List;

/**@Title:     PmsPermissionDao
 * @Description:  <p> 权限 dao </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/17 15:13 
 */
public interface PmsPermissionDao extends PermissionBaseDao<PmsPermission> {
	/**
	 * 根据实体ID集字符串获取对象列表.
	 * @param ids
	 * @return
	 */
	List<PmsPermission> findByIds(String ids);

	/**
	 * 检查权限名称是否已存在
	 * @param permissionName
	 * @return
	 */
	PmsPermission getByPermissionName(String permissionName);

	/**
	 * 检查权限是否已存在
	 * @param permission
	 * @return
	 */
	PmsPermission getByPermission(String permission);

	/**
	 * 检查权限名称是否已存在(其他id)
	 * @param permissionName
	 * @param id
	 * @return
	 */
	PmsPermission getByPermissionNameNotEqId(String permissionName, Long id);

	/**
	 * 获取叶子菜单下所有的功能权限
	 * @param menuId
	 * @return
	 */
	List<PmsPermission> listAllByMenuId(Long menuId);

}
