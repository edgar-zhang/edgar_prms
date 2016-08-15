package com.sjn_edgar.prms.tools.date;

import org.junit.Test;

/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

/**
 * 测试日期、时间工具类
 */
public class DateUtilsTest {

	@Test
	public void testGetCurrentTimeFileName() throws Exception {
		System.out.println("获取当前日期格式文件夹"+DateUtils.getCurrentTimeFileName());
		System.out.println("获取格林尼治时间（标准时间）："+DateUtils.getGMTTime());
	}
}