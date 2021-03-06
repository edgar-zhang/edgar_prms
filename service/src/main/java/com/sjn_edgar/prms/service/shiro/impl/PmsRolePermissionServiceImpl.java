/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sjn_edgar.prms.service.shiro.impl;

import com.alibaba.druid.util.StringUtils;
import com.sjn_edgar.prms.dao.shiro.PmsPermissionDao;
import com.sjn_edgar.prms.dao.shiro.PmsRolePermissionDao;
import com.sjn_edgar.prms.domain.shiro.PmsPermission;
import com.sjn_edgar.prms.domain.shiro.PmsRolePermission;
import com.sjn_edgar.prms.service.shiro.PmsOperatorRoleService;
import com.sjn_edgar.prms.service.shiro.PmsRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**@Title:     PmsRolePermissionServiceImpl
 * @Description:  <p> 角色权限service接口实现 </p>
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016/8/17 15:07
 */
@Service(value = "pmsRolePermissionService")
public class PmsRolePermissionServiceImpl implements PmsRolePermissionService {

	@Autowired //角色权限dao
	private PmsRolePermissionDao pmsRolePermissionDao;
	@Autowired // 权限 dao
	private PmsPermissionDao pmsPermissionDao;
	@Autowired //操作角色service接口
	private PmsOperatorRoleService pmsOperatorRoleService;

	/**
	 * 根据操作员ID，获取所有的功能权限集
	 * @param operatorId
	 */
	public Set<String> getPermissionsByOperatorId(Long operatorId) {
		// 根据操作员Id查询出 关联的所有角色id
		String roleIds = pmsOperatorRoleService.getRoleIdsByOperatorId(operatorId);

		//根据角色ID集得到所有权限ID集
		String permissionIds = getActionIdsByRoleIds(roleIds);
		Set<String> permissionSet = new HashSet<String>();

		// 根据角色ID字符串得到该用户的所有权限拼成的字符串
		if (!StringUtils.isEmpty(permissionIds)) {
			List<PmsPermission> permissions = pmsPermissionDao.findByIds(permissionIds);
			for (PmsPermission permission : permissions) {
				permissionSet.add(permission.getPermission());
			}
		}
		return permissionSet;
	}

	/**
	 * 根据角色ID集得到所有权限ID集
	 *
	 * @param roleIds
	 * @return actionIds
	 */
	private String getActionIdsByRoleIds(String roleIds) {
		// 得到角色－权限表中roleiId在ids中的所有关联对象
		List<PmsRolePermission> listRolePermission = pmsRolePermissionDao.listByRoleIds(roleIds); // 构建StringBuffer

		StringBuffer actionIdsBuf = new StringBuffer("");
		// 拼接字符串
		for (PmsRolePermission pmsRolePermission : listRolePermission) {
			actionIdsBuf.append(pmsRolePermission.getPermissionId()).append(",");
		}
		String actionIds = actionIdsBuf.toString();
		// 截取字符串
		if (StringUtils.isEmpty(actionIds) && actionIds.length() > 0) {
			actionIds = actionIds.substring(0, actionIds.length() - 1); // 去掉最后一个逗号
		}
		return actionIds;
	}

	// /////////////////////////////下面：基本操作方法///////////////////////////////////////////////

	/**
	 * 创建pmsOperator
	 */
	public void saveData(PmsRolePermission pmsRolePermission) {
		pmsRolePermissionDao.insert(pmsRolePermission);
	}

	/**
	 * 修改pmsOperator
	 */
	public void updateData(PmsRolePermission pmsRolePermission) {
		pmsRolePermissionDao.update(pmsRolePermission);
	}

	/**
	 * 根据id获取数据pmsOperator
	 *
	 * @param id
	 * @return
	 */
	public PmsRolePermission getDataById(Long id) {
		return pmsRolePermissionDao.getById(id);

	}


}
