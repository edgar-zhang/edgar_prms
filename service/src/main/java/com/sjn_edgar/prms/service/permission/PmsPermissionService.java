package com.sjn_edgar.prms.service.permission;

import com.sjn_edgar.prms.domain.permission.PmsPermission;
import com.sjn_edgar.prms.domain.page.PageBean;
import com.sjn_edgar.prms.domain.page.PageParam;

/**@Title:     PmsPermissionService
 * @Description:  <p> 权限service接口 </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/16 10:15 
 */
public interface PmsPermissionService {

	/**
	 * 创建pmsPermission
	 */
	void saveData(PmsPermission pmsPermission);

	/**
	 * 修改pmsPermission
	 */
	void updateData(PmsPermission pmsPermission);

	/**
	 * 根据id获取数据pmsPermission
	 * 
	 * @param id
	 * @return
	 */
	PmsPermission getDataById(Long id);

	/**
	 * 分页查询pmsPermission
	 * @param pageParam  分页参数
	 * @param pmsPermission 权限
	 * @return
	 */
	PageBean listPage(PageParam pageParam, PmsPermission pmsPermission);

	/**
	 * 检查权限名称是否已存在
	 * 
	 * @param permissionName
	 * @return
	 */
	PmsPermission getByPermissionName(String permissionName);

	/**
	 * 检查权限是否已存在
	 * 
	 * @param permission
	 * @return
	 */
	PmsPermission getByPermission(String permission);

	/**
	 * 检查权限名称是否已存在(其他id)
	 * 
	 * @param permissionName
	 * @param id
	 * @return
	 */
	PmsPermission getByPermissionNameNotEqId(String permissionName, Long id);

	/**
	 * 删除
	 * 
	 * @param permissionId
	 */
	void delete(Long permissionId);

	/**
	 * 根据角色查找角色对应的功能权限ID集
	 * 
	 * @param roleId
	 * @return
	 */
	String getPermissionIdsByRoleId(Long roleId);

}
