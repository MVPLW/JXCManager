package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxc.mapper.EmployeeMapper;
import cn.jxc.pojo.Employee;
import cn.jxc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public Employee login(String name, String pwd) {
		return employeeMapper.login(name, pwd);
	}

	@Override
	public List<Employee> getEmployeeAll() {
		return employeeMapper.getEmployeeAll();
	}
	
}
