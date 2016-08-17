package com.sjn_edgar.prms.dao.shiro.impl;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.dao.common.impl.PermissionBaseDaoImpl;
import com.sjn_edgar.prms.dao.shiro.PmsOperatorDao;
import com.sjn_edgar.prms.domain.shiro.PmsOperator;
import org.springframework.stereotype.Repository;

import java.util.List;

/**@Title:     PmsOperatorDaoImpl
 * @Description:  <p> 权限操作员dao实现 </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/17 12:13 
 */
@Repository
public class PmsOperatorDaoImpl extends PermissionBaseDaoImpl<PmsOperator> implements PmsOperatorDao {

	/**
	 * 根据操作员登录名获取操作员信息.
	 * @param loginName
	 * @return operator .
	 */

	public PmsOperator findByLoginName(String loginName) {
		return super.getSqlSession().selectOne(getStatement("findByLoginName"), loginName);
	}

	@Override
	public List<PmsOperator> listByRoleId(Long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}



}
