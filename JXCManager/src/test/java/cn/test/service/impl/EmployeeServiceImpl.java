package cn.test.service.impl;

import java.util.Set;

import cn.jxc.pojo.Employee;
import cn.test.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public Employee createUser(Employee user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(int userId, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void correlationRoles(int userId, int... roleIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uncorrelationRoles(int userId, int... roleIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
