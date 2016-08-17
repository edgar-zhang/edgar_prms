package com.sjn_edgar.prms.service.shiro.impl;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import com.sjn_edgar.prms.dao.shiro.PmsOperatorDao;
import com.sjn_edgar.prms.domain.shiro.PmsOperator;
import com.sjn_edgar.prms.service.shiro.PmsOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 17 11:50
 */
@Service(value = "pmsOperatorService")
public class PmsOperatorServiceImpl implements PmsOperatorService {


	@Autowired
	private PmsOperatorDao pmsOperatorDao;

	/**
	 * 根据登录名取得操作员对象
	 */
	@Override
	public PmsOperator findOperatorByLoginName(String loginName) {
		return pmsOperatorDao.findByLoginName(loginName);
	}
}
