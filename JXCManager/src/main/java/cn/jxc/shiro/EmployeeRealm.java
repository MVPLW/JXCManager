package cn.jxc.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Permission;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.PermissionService;

public class EmployeeRealm extends AuthorizingRealm {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private PermissionService permissionService;

	/**
	 * 用于授权的方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 从principals获取主身份信息
		// 将getPrimaryPrincipal方法返回值转为真实身份类型(在上边的goGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo)
		Employee emp = (Employee) principalCollection.getPrimaryPrincipal();
		System.err.println("==============进入授权的方法========================" + emp.getEmpLoginName());
		// System.out.println(username);
		// 从数据库获取动态权限数据
		List<Permission> permissions = permissionService.findPermissionByEmp(emp.getEmpLoginName());
		System.err.println(permissions.size() + "   ~~~授权的方法。。。。。。。。。。");
		List<String> permissionCodes = new ArrayList<String>();
		int i = 0;
		if (permissions != null) {
			for (Permission per : permissions) {
				i++;
				// 将数据库中的权限标签符放入集合
				permissionCodes.add(per.getPermissionCode());
			}
		}
		System.err.println(i + " ~~~~~~~~~~~~~~~~~~~~~~~~~  " + emp.getEmpLoginName() + "共有" + i + "个权限");
		// 查到权限数据，返回授权信息(包括上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissionCodes);
		return simpleAuthorizationInfo;
	}

	/**
	 * 用于认证的方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		System.err.println("进入认证的方法=====================================" + "用户名" + token.getUsername());
		Employee emp = employeeService.findEmployeeByLoginName(token.getUsername());
		if (null == emp) {
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(emp, emp.getEmpLoginPwd(),
				this.getClass().getSimpleName());
		return info;
	}

}
