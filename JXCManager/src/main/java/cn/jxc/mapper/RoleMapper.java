package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Role;

public interface RoleMapper {

	List<Role> getRoleAll();

	int addRole(@Param("r") Role role);

	/**
	 * 添加员工角色
	 * 
	 * @param emp
	 *            员工登录名
	 * @param roleId
	 *            角色id
	 * @return
	 */
	int addEmpRole(@Param("emp") String emp, @Param("roleId") String roleId);

	int updateRole(@Param("r") Role role);

	int delRole(Integer roleId);

	/**
	 * 根据用户名删除用户拥有的角色
	 * 
	 * @param empLoginName
	 *            用户名
	 * @return
	 */
	int delRoleByEmp(@Param("emp") String empLoginName);

	Role findRoleById(Integer roleId);

	List<Role> findRoleByEmp(@Param("emp") String emp);

}
