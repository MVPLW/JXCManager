package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	public PageInfo<Employee> getEmployeeAll(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Employee> employeeAll = employeeMapper.getEmployeeAll();
		return new PageInfo<>(employeeAll);
	}

	@Override
	public Employee findEmployeeByLoginName(String name) {
		// TODO Auto-generated method stub
		return employeeMapper.findEmployeeByLoginName(name);
	}
	
}
