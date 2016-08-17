package com.sjn_edgar.prms.tools.security;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/
import com.sjn_edgar.prms.tools.string.ByteUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**@Title:     PayHomeSignUtils
 * @Description:  <p> 对接prms 支付平台 数据加密 </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/16 10:30 
 */
public class PayHomeSignUtils {

	private static final Log LOG = LogFactory.getLog(PayHomeSignUtils.class);

	private PayHomeSignUtils() {

	}

	/**
	 * 获取签名
	 * @param timeStamp
	 * @param userName
	 * @param token
	 * @return
	 */
	public static String getSign(String token, long timeStamp, String userName) {

		String[] arr = new String[] { token, String.valueOf(timeStamp), userName };
		// 将token、timestamp、nonce、userPwd三个参数进行字典序排序
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = ByteUtils.byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			LOG.error(e);
		}
		return tmpStr;
	}



}
