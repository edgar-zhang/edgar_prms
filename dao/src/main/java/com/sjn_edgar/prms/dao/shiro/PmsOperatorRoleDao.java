package com.sjn_edgar.prms.dao.shiro;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.dao.common.PermissionBaseDao;
import com.sjn_edgar.prms.domain.shiro.PmsOperatorRole;

import java.util.List;

/**@Title:     PmsOperatorRoleDao
 * @Description:  <p> 操作员与角色dao </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/17 12:11 
 */
public interface PmsOperatorRoleDao extends PermissionBaseDao<PmsOperatorRole> {

	/**
	 * 根据操作员ID查找该操作员关联的角色.
	 * @param operatorId
	 * @return list .
	 */
	List<PmsOperatorRole> listByOperatorId(Long operatorId);


	/**
	 * 根据角色ID查找该操作员关联的操作员.
	 * @param roleId
	 * @return
	 */
	List<PmsOperatorRole> listByRoleId(Long roleId);

	/**
	 * 根据操作员ID删除与角色的关联记录.
	 * @param operatorId
	 */
	void deleteByOperatorId(Long operatorId);

	/**
	 * 根据角色ID删除操作员与角色的关联关系.
	 * @param roleId
	 */
	void deleteByRoleId(Long roleId);

	/**
	 * 根据角色ID和操作员ID删除关联数据(用于更新操作员的角色).
	 * @param roleId 角色ID.
	 * @param operatorId 操作员ID.
	 */
	void deleteByRoleIdAndOperatorId(Long roleId, Long operatorId);

}
