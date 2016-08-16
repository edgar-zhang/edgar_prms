package com.sjn_edgar.prms.service.shiro;

import java.util.Set;

/**@Title:     PmsOperatorRoleService
 * @Description:  <p> 操作角色service接口 </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/15 18:05 
 */
public interface PmsOperatorRoleService {


	/**
	 * 根据操作员id，获取该操作员所有角色的编码集合
	 * @param operatorId
	 * @return
	 */
	public Set<String> getRoleCodeByOperatorId(Long operatorId);


}
