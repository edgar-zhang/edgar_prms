package com.sjn_edgar.prms.tools.date;


/**
 * @ClassName:     DateStyle
 * @Description:  <p> 日期样式工具类</p>
 * @author         zhangbo
 * @email 		   zbo@51qmz.cn
 * @version        V 1.0  
 * @date           2016-4-20 下午08:30:04
 */
public enum DateStyle {
	
	
	/**
	 * 格式为：yyyy-MM
	 */
	YYYY_MM("yyyy-MM", false),
	
	/**
	 * 格式为：yyyy-MM-dd
	 */
	YYYY_MM_DD("yyyy-MM-dd", false),
	
	/**
	 * 格式为：yyyy-MM-dd HH:mm
	 */
	YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm", false),
	
	/**
	 * 格式为：yyyy-MM-dd HH:mm:ss
	 */
	YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss", false),
	
	/**
	 * 格式为：yyyy/MM
	 */
	YYYY_MM_EN("yyyy/MM", false),
	
	/**
	 * 格式为：yyyy/MM/dd
	 */
	YYYY_MM_DD_EN("yyyy/MM/dd", false),
	
	/**
	 * 格式为：yyyy/MM/dd HH:mm
	 */
	YYYY_MM_DD_HH_MM_EN("yyyy/MM/dd HH:mm", false),
	
	/**
	 * 格式为：yyyy/MM/dd HH:mm:ss
	 */
	YYYY_MM_DD_HH_MM_SS_EN("yyyy/MM/dd HH:mm:ss", false),
	
	/**
	 * 格式为：yyyy年MM月
	 */
	YYYY_MM_CN("yyyy年MM月", false),
	
	/**
	 * 格式为：yyyy年MM月dd日
	 */
	YYYY_MM_DD_CN("yyyy年MM月dd日", false),
	
	/**
	 * 格式为：yyyy年MM月dd日 HH:mm
	 */
	YYYY_MM_DD_CN_HH_MM("yyyy年MM月dd日 HH:mm", false),
	
	/**
	 * 格式为：yyyy年MM月dd日 HH时mm分
	 */
	YYYY_MM_DD_HH_MM_CN("yyyy年MM月dd日 HH时mm分", false),
	
	/**
	 * 格式为：yyyy年MM月dd日 HH:mm:ss
	 */
	YYYY_MM_DD_CN_HH_MM_SS("yyyy年MM月dd日 HH:mm:ss", false),
	
	/**
	 * 格式为：yyyy年MM月dd日 HH时mm分ss秒
	 */
	YYYY_MM_DD_HH_MM_SS_CN("yyyy年MM月dd日 HH时mm分ss秒", false),
	
	/**
	 * 格式为：HH:mm
	 */
	HH_MM("HH:mm", true),
	
	/**
	 * 格式为：
	 */
	HH_MM_SS("HH:mm:ss", true),
	
	/**
	 * 格式为：MM-dd
	 */
	MM_DD("MM-dd", true),
	
	/**
	 * 格式为：MM-dd HH:mm
	 */
	MM_DD_HH_MM("MM-dd HH:mm", true),
	
	/**
	 * 格式为：MM-dd HH:mm:ss
	 */
	MM_DD_HH_MM_SS("MM-dd HH:mm:ss", true),
	
	/**
	 * 格式为：MM/dd
	 */
	MM_DD_EN("MM/dd", true),
	
	/**
	 * 格式为：MM/dd HH:mm
	 */
	MM_DD_HH_MM_EN("MM/dd HH:mm", true),
	
	/**
	 * 格式为：MM/dd HH:mm:ss
	 */
	MM_DD_HH_MM_SS_EN("MM/dd HH:mm:ss", true),
	
	/**
	 * 格式为：
	 */
	MM_DD_CN("MM月dd日", true),
	
	/**
	 * 格式为：MM月dd日 HH:mm
	 */
	MM_DD_HH_MM_CN("MM月dd日 HH:mm", true),
	
	/**
	 * 格式为：MM月dd日 HH:mm:ss
	 */
	MM_DD_HH_MM_SS_CN("MM月dd日 HH:mm:ss", true);
	
	
	
	/*//1.判断字符串第五位是否是以"."	字符串格式：2012.08.23
	if (mydate.startsWith(".", 4)) {
		simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
	}*/
	
	private String value;
	
	private boolean isShowOnly;
	
	DateStyle(String value, boolean isShowOnly) {
		this.value = value;
		this.isShowOnly = isShowOnly;
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean isShowOnly() {
		return isShowOnly;
	}
}