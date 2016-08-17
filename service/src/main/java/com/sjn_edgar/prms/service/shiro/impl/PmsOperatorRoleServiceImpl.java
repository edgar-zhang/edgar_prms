package com.sjn_edgar.prms.service.shiro.impl;/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.dao.shiro.PmsOperatorDao;
import com.sjn_edgar.prms.dao.shiro.PmsOperatorRoleDao;
import com.sjn_edgar.prms.dao.shiro.PmsRoleDao;
import com.sjn_edgar.prms.domain.shiro.PmsOperator;
import com.sjn_edgar.prms.domain.shiro.PmsOperatorRole;
import com.sjn_edgar.prms.domain.shiro.PmsRole;
import com.sjn_edgar.prms.service.shiro.PmsOperatorRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: 操作员角色service接口实现 </p>
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 17 12:07
 */
@Service(value = "pmsOperatorRoleService")
public class PmsOperatorRoleServiceImpl implements PmsOperatorRoleService{


	@Autowired
	private PmsOperatorRoleDao pmsOperatorRoleDao;

	@Autowired
	private PmsOperatorDao pmsOperatorDao;

	@Autowired
	private PmsRoleDao pmsRoleDao;
	/**
	 * 根据操作员id，获取该操作员所有角色的编码集合
	 * @param operatorId
	 * @return
	 */
	@Override
	public Set<String> getRoleCodeByOperatorId(Long operatorId) {
		// 得到操作员和角色列表
		List<PmsOperatorRole> rpList = pmsOperatorRoleDao.listByOperatorId(operatorId);
		Set<String> roleCodeSet = new HashSet<String>();

		for (PmsOperatorRole rp : rpList) {
			Long roleId = rp.getRoleId();
			PmsRole role = pmsRoleDao.getById(roleId);
			if (role == null) {
				continue;
			}
			roleCodeSet.add(role.getRoleCode());
		}

		return roleCodeSet;
	}

	/**
	 * 根据操作员ID获得该操作员的所有角色id所拼成的String，每个ID用“,”分隔
	 *
	 * @param operatorId
	 *            操作员ID
	 * @return roleIds
	 */
	public String getRoleIdsByOperatorId(Long operatorId) {
		// 得到操作员和角色列表
		List<PmsOperatorRole> rpList = pmsOperatorRoleDao.listByOperatorId(operatorId);
		// 构建StringBuffer来拼字符串
		StringBuffer roleIdsBuf = new StringBuffer("");
		for (PmsOperatorRole rp : rpList) {
			roleIdsBuf.append(rp.getRoleId()).append(",");
		}
		String roleIds = roleIdsBuf.toString();
		// 截取字符串
		if (StringUtils.isNotBlank(roleIds) && roleIds.length() > 0) {
			roleIds = roleIds.substring(0, roleIds.length() - 1);
		}
		return roleIds;
	}

	/**
	 * 根据角色ID统计有多少个操作员关联到此角色.
	 * @param roleId
	 * @return count.
	 */
	public int countOperatorByRoleId(Long roleId) {
		List<PmsOperatorRole> operatorList = pmsOperatorRoleDao.listByRoleId(roleId);
		if (operatorList == null || operatorList.isEmpty()) {
			return 0;
		} else {
			return operatorList.size();
		}
	}

	/**
	 * 根据操作员ID获得所有操作员－角色关联列表
	 */
	public List<PmsOperatorRole> listOperatorRoleByOperatorId(Long operatorId) {
		return pmsOperatorRoleDao.listByOperatorId(operatorId);
	}

	/**
	 * 保存操作員信息及其关联的角色.
	 * @param pmsOperator
	 * @param OperatorRoleStr
	 *            .
	 */
	public void saveOperator(PmsOperator pmsOperator, String OperatorRoleStr) {
		// 保存操作员信息
		pmsOperatorDao.insert(pmsOperator);
		// 保存角色关联信息
		if (StringUtils.isNotBlank(OperatorRoleStr) && OperatorRoleStr.length() > 0) {
			saveOrUpdateOperatorRole(pmsOperator.getId(), OperatorRoleStr);
		}
	}

	/**
	 * 根据角色ID查询用户
	 * @param roleId
	 * @return
	 */
	public List<PmsOperator> listOperatorByRoleId(Long roleId) {
		return pmsOperatorDao.listByRoleId(roleId);
	}

	/**
	 * 修改操作員信息及其关联的角色.
	 * @param pmsOperator
	 * @param OperatorRoleStr
	 *            .
	 */
	public void updateOperator(PmsOperator pmsOperator, String OperatorRoleStr) {
		pmsOperatorDao.update(pmsOperator);
		// 更新角色信息
		saveOrUpdateOperatorRole(pmsOperator.getId(), OperatorRoleStr);
	}

	/**
	 * 保存用户和角色之间的关联关系
	 */
	private void saveOrUpdateOperatorRole(Long operatorId, String roleIdsStr) {
		// 删除原来的角色与操作员关联
		List<PmsOperatorRole> listPmsOperatorRoles = pmsOperatorRoleDao.listByOperatorId(operatorId);
		Map<Long, PmsOperatorRole> delMap = new HashMap<Long, PmsOperatorRole>();
		for (PmsOperatorRole pmsOperatorRole : listPmsOperatorRoles) {
			delMap.put(pmsOperatorRole.getRoleId(), pmsOperatorRole);
		}
		if (StringUtils.isNotBlank(roleIdsStr)) {
			// 创建新的关联
			String[] roleIds = roleIdsStr.split(",");
			for (int i = 0; i < roleIds.length; i++) {
				Long roleId = Long.valueOf(roleIds[i]);
				if (delMap.get(roleId) == null) {
					PmsOperatorRole pmsOperatorRole = new PmsOperatorRole();
					pmsOperatorRole.setOperatorId(operatorId);
					pmsOperatorRole.setRoleId(roleId);
					pmsOperatorRoleDao.insert(pmsOperatorRole);
				} else {
					delMap.remove(roleId);
				}
			}
		}

		Iterator<Long> iterator = delMap.keySet().iterator();
		while (iterator.hasNext()) {
			Long roleId = iterator.next();
			pmsOperatorRoleDao.deleteByRoleIdAndOperatorId(roleId, operatorId);
		}
	}

}
