package cn.jxc.service;


import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;

public interface EmployeeService {

	Employee login(String name, String pwd);

	PageInfo<Employee> getEmployeeAll(Integer pageNum, Integer pageSize);
}
