package cn.test.service;

import java.util.Set;

import cn.jxc.pojo.Employee;

public interface EmployeeService {
	public Employee createUser(Employee user); // 创建账户

	public void changePassword(int userId, String newPassword);// 修改密码

	public void correlationRoles(int userId, int... roleIds); // 添加用户-角色关系

	public void uncorrelationRoles(int userId, int... roleIds);// 移除用户-角色关系

	public Employee findByUsername(String username);// 根据用户名查找用户

	public Set<String> findRoles(String username);// 根据用户名查找其角色

	public Set<String> findPermissions(String username); // 根据用户名查找其权限
}
