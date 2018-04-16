package cn.jxc.service;

import java.util.List;

import cn.jxc.pojo.Employee;

public interface EmployeeService {
	
	Employee login(String name,String pwd);
	List<Employee> getEmployeeAll();
}
