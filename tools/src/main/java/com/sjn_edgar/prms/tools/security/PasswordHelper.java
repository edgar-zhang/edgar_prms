package com.sjn_edgar.prms.tools.security;
/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import com.sjn_edgar.prms.domain.shiro.PmsOperator;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**@Title:     生成密码工具类
 * @Description:  <p> 生成密码 </p>
 * @author         edgar【zbo@51qmz.cn】
 * @version        V 1.0
 * @Date           2016/8/17 11:03
 */
public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private static String algorithmName = "md5";

	private static String hashIteration = "2";

	private static int hashIterations = Integer.valueOf(hashIteration);

	public static void encryptPassword(PmsOperator pmsOperator) {

		pmsOperator.setsalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(algorithmName, pmsOperator.getLoginPwd(), ByteSource.Util.bytes(pmsOperator.getCredentialsSalt()), hashIterations).toHex();

		pmsOperator.setLoginPwd(newPassword);
	}

	/**
	 * 加密密码
	 * @param loginPwd 明文密码
	 * @param salt 加密盐
	 * @return
	 */
	public static String getPwd(String loginPwd, String salt) {
		String newPassword = new SimpleHash(algorithmName, loginPwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
		return newPassword;
	}

}
