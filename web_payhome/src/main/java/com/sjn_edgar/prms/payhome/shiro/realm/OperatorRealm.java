package com.sjn_edgar.prms.payhome.shiro.realm;/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sjn_edgar.prms.domain.shiro.PmsOperator;
import com.sjn_edgar.prms.service.shiro.PmsOperatorRoleService;
import com.sjn_edgar.prms.service.shiro.PmsOperatorService;
import com.sjn_edgar.prms.service.shiro.PmsRolePermissionService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>Title:自定义realm类 </p>
 * <p>Description: </p>
 *
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 16 17:52
 */
public class OperatorRealm extends AuthorizingRealm {


	@Autowired //操作员服务接口
	private PmsOperatorService pmsOperatorService;
	@Autowired //操作角色服务接口
	private PmsOperatorRoleService pmsOperatorRoleService;
	@Autowired //操作权限service接口
	private PmsRolePermissionService pmsRolePermissionService;

	/**
	 * 授权
	 * @param principals
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String loginName = (String) principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		PmsOperator operator = (PmsOperator) session.getAttribute("PmsOperator");
		if (operator == null) {
			// 对接支付平台  "admin" 为管理员身份  "guest" 游客身份
			if (!"admin".equals(loginName)) {
				loginName = "guest";
			}
			operator = pmsOperatorService.findOperatorByLoginName(loginName);
			session.setAttribute("PmsOperator", operator);
		}
		// 根据登录名查询操作员
		Long operatorId = operator.getId();

		Set<String> roles = (Set<String>) session.getAttribute("ROLES");
		if (roles == null || roles.isEmpty()) {
			//根据操作员id，获取该操作员所有角色的编码集合
			roles = pmsOperatorRoleService.getRoleCodeByOperatorId(operatorId);
			session.setAttribute("ROLES", roles);
		}
		// 查询角色信息
		authorizationInfo.setRoles(roles);

		Set<String> permisstions = (Set<String>) session.getAttribute("PERMISSIONS");
		if (permisstions == null || permisstions.isEmpty()) {

			//根据操作员ID，获取所有的功能权限集
			permisstions = pmsRolePermissionService.getPermissionsByOperatorId(operatorId);
			session.setAttribute("PERMISSIONS", permisstions);
		}
		// 根据用户名查询权限
		authorizationInfo.setStringPermissions(permisstions);
		return authorizationInfo;
	}

	/**
	 * 认证
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@SuppressWarnings("unchecked")
	@Override
	// 验证的核心方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String loginName = (String) token.getPrincipal();
		if (StringUtils.isEmpty(loginName)) {
			throw new UnknownAccountException();// 没找到帐号
		}
		if (!"admin".equals(loginName)) {
			// 贯穿支付平台
			String pwd = new String((char[]) token.getCredentials());
			//设置登录时间戳
			Long timeStamp = System.currentTimeMillis();
			String key = "rcPayLoginSign268";
			String sign = RonCooSignUtil.getSign(key, timeStamp, loginName);

			// String url =
			// "http://192.168.1.181:8080/roncoo-dev-admin/mydata/getByLoginName";
			String url = "http://boss.roncoo.com/mydata/getByLoginName";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userName", loginName);
			params.put("timeStamp", timeStamp);
			params.put("sign", sign);

			String json = JSON.toJSONString(params);

			String httpResponse = RoncooHttpClientUtils.post(url, json);
			if (httpResponse.length() < 2) {
				throw new PermissionException(PermissionException.RONCOO_NETWORK_EXCEPTION, "网络异常,请联系龙果管理员");
			}
			Map<String, Object> parseObject = JSONObject.parseObject(httpResponse, Map.class);
			String code = (String) parseObject.get("code");

			if ("100".equals(code)) {
				throw new UnknownAccountException();// 没找到帐号
			} else {
				JSONObject data = (JSONObject) parseObject.get("data");
				Map<String, Object> mapInfo = JSONObject.parseObject(data.toJSONString(), Map.class);
				String returnPWD = (String) mapInfo.get("pwd");
				String userId = (String) mapInfo.get("userId");
				String str = userId.trim() + pwd.trim();
				String getPwd = EncryptUtil.encodeSHAString(str);

				if (getPwd.trim().equals(returnPWD.trim())) {

					String salt = "183d9f2f0f2ce760e98427a5603d1c73";
					String password = PasswordHelper.getPwd(pwd, salt);
					// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
					SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, // 登录名
							password, // 密码
							ByteSource.Util.bytes(salt),// salt=username+salt
							getName() // realm name
					);
					return authenticationInfo;

				} else {
					throw new IncorrectCredentialsException();// 密码错误
				}
			}
		} else {
			// 根据登录名查询操作员
			PmsOperator operator = pmsOperatorService.findOperatorByLoginName(loginName);

			if (operator == null) {
				throw new UnknownAccountException();// 没找到帐号
			}

			if (PublicStatusEnum.UNACTIVE.equals(operator.getStatus())) {
				throw new LockedAccountException(); // 帐号锁定
			}

			// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(operator.getLoginName(), // 登录名
					operator.getLoginPwd(), // 密码
					ByteSource.Util.bytes(operator.getCredentialsSalt()), // salt=username+salt
					getName() // realm name
			);

			return authenticationInfo;
		}

	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
