package com.sjn_edgar.prms.payhome.shiro.credentialsmatcher;/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import com.sjn_edgar.prms.domain.shiro.PmsOperator;
import com.sjn_edgar.prms.service.shiro.PmsOperatorService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Title: 自定义凭证匹配器类</p>
 * <p>Description: 凭证匹配器，做登录次数验证，和密码匹配验证</p>
 *
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 16 17:35
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	@Autowired
	private PmsOperatorService pmsOperatorService;

	private Cache<String, AtomicInteger> passwordRetryCache;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	/**
	 * 做认证匹配
	 */
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

		String username = (String) token.getPrincipal();
		// retry count + 1
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			//设置缓存用户信息
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > 5) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException();
		}

		boolean matches = super.doCredentialsMatch(token, info);

		if (matches) {
			// clear retry count
			passwordRetryCache.remove(username);

			// 对接支付平台  "admin" 为管理员身份  "guest" 游客身份
			if (!"admin".equals(username)) {
				username = "guest";
			}

			// 根据登录用户名查询操作员
			PmsOperator operator = pmsOperatorService.findOperatorByLoginName(username);
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute("PmsOperator", operator);
		}
		return matches;
	}
}

