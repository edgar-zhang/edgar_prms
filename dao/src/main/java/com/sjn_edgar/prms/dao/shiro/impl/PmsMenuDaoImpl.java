package com.sjn_edgar.prms.dao.shiro.impl;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.dao.common.impl.PermissionBaseDaoImpl;
import com.sjn_edgar.prms.dao.shiro.PmsMenuDao;
import com.sjn_edgar.prms.domain.shiro.PmsMenu;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

 /**@Title:     权限菜单DAO 实现
 * @Description:  <p>权限菜单 </p>
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016-8-22 11:41:29
 */
@Repository("pmsMenuDao")
public class PmsMenuDaoImpl extends PermissionBaseDaoImpl<PmsMenu> implements PmsMenuDao {

	 /**
	  * 字符串格式的ids 转list集合
	  * @param roleIdsStr
	  * @return
	  */
	@SuppressWarnings("rawtypes")
	@Override
	public List listByRoleIds(String roleIdsStr) {
		List<String> roldIds = Arrays.asList(roleIdsStr.split(","));
		return super.getSqlSession().selectList(getStatement("listByRoleIds"), roldIds);
	}

	/**
	 * 根据父菜单ID获取该菜单下的所有子孙菜单.<br/>
	 * @param parentId  (如果为空，则为获取所有的菜单).<br/>
	 * @return menuList.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List listByParent(Long parentId) {
		return super.getSqlSession().selectList(getStatement("listByParent"), parentId);
	}

	/**
	 * 根据菜单ID查找菜单（可用于判断菜单下是否还有子菜单）.
	 * @param parentId
	 * @return menuList.
	 */
	@Override
	public List<PmsMenu> listByParentId(Long parentId) {
		return super.getSqlSession().selectList(getStatement("listByParentId"), parentId);
	}

	/***
	 * 根据名称和是否叶子节点查询数据
	 * @param  map
	 *    map.get("isLeaf") 是否是叶子节点
	 *    map.get("name") 节点名称
	 * @return
	 */
	public List<PmsMenu> getMenuByNameAndIsLeaf(Map<String, Object> map) {
		return super.getSqlSession().selectList(getStatement("listBy"), map);
	}

}