package com.sjn_edgar.prms.tools.string;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

/**
 * <p>Title:字节处理类 </p>
 * <p>Description:字节转换处理 </p>
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 17 10:39
 */
public final class ByteUtils {

	/**
	 * 将字节数组转换为十六进制字符串
	 * @param byteArray
	 * @return
	 */
	public static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * @param mByte
	 * @return
	 */
	public static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		return new String(tempArr);
	}
}
