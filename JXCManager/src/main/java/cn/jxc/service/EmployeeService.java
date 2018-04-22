package cn.jxc.service;


import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;

public interface EmployeeService {

	Employee login(String name, String pwd);
	
	Employee findEmployeeByLoginName(String name);

	PageInfo<Employee> getEmployeeAll(Integer pageNum, Integer pageSize);
}
