package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Employee;

public interface EmployeeMapper {

	/**
	 * 登录
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	Employee login(@Param("name") String name, @Param("pwd") String pwd);

	/**
	 * 根据登录名查找员工
	 * 
	 * @param name
	 * @return
	 */
	Employee findEmployeeByLoginName(@Param("name") String name);

	/**
	 * 获取所有员工信息
	 * 
	 * @return
	 */
	List<Employee> getEmployeeAll();

	/**
	 * 添加员工
	 * 
	 * @param employee
	 *            员工对象
	 * @return
	 */
	int addEmployee(@Param("e") Employee employee);

	/**
	 * 根据角色id删除员工角色关联
	 * 
	 * @param roleId
	 *            角色id
	 * @return
	 */
	int deleteEmployeeRoleByRoleId(Integer roleId);
	

}