package cn.jxc.mapper;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Employee;

public interface EmployeeMapper {
	
	Employee login(@Param("name")String name,@Param("pwd")String pwd);
	
}
