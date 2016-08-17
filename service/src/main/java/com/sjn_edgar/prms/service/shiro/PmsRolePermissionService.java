package com.sjn_edgar.prms.service.shiro;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import java.util.Set;


/**@Title:     角色权限service接口
 * @Description:  <p>  根据角色，操作对应权限 </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/16 10:23 
 */
public interface PmsRolePermissionService {

	/**
	 * 根据操作员ID，获取所有的功能权限集
	 * @param operatorId
	 */
	public Set<String> getPermissionsByOperatorId(Long operatorId);


}
