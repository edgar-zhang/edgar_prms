package com.sjn_edgar.prms.service.shiro;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.domain.shiro.PmsOperator;

/**@Title:     PmsOperatorService
 * @Description:  <p> 操作员service接口 </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/15 18:04 
 */
public interface PmsOperatorService {

	/**
	 * 根据登录名取得操作员对象
	 */
	public PmsOperator findOperatorByLoginName(String loginName);


}
