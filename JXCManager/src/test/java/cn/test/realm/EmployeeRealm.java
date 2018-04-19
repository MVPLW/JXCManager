package cn.test.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.jxc.pojo.Employee;
import cn.test.service.EmployeeService;
import cn.test.service.impl.EmployeeServiceImpl;

public class EmployeeRealm extends AuthorizingRealm {

	private EmployeeService employeeService = new EmployeeServiceImpl();

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(employeeService.findRoles(username));
		authorizationInfo.setStringPermissions(employeeService.findPermissions(username));
		return authorizationInfo;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Employee emp = employeeService.findByUsername(username);
		if (emp == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
//		if (Boolean.TRUE.equals(emp.getEmpLoginName())) {
//			throw new LockedAccountException(); // 帐号锁定
//		}
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(emp.getEmpLoginName(), // 用户名
				emp.getEmpLoginPwd(), // 密码
				ByteSource.Util.bytes(emp.getEmpLoginName()), // salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}

}
