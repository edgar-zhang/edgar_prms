package com.sjn_edgar.prms.dao.shiro;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.dao.common.PermissionBaseDao;
import com.sjn_edgar.prms.domain.shiro.PmsOperator;

import java.util.List;

/**@Title:     PmsOperatorDao
 * @Description:  <p> 操作员dao </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/17 11:54 
 */
public interface PmsOperatorDao extends PermissionBaseDao<PmsOperator> {

	/**
	 * 根据操作员登录名获取操作员信息.
	 *
	 * @param loginName
	 *            .
	 * @return operator .
	 */
	PmsOperator findByLoginName(String loginName);

	/**
	 * 根据角色ID找到操作员列表.
	 *
	 * @param roleId
	 * @return
	 */
	List<PmsOperator> listByRoleId(Long roleId);

}
