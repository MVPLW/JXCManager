package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Role;

public interface RoleMapper {

	/**
	 * 获取所有角色
	 * 
	 * @return
	 */
	List<Role> getRoleAll();

	/**
	 * 添加角色信息
	 * 
	 * @param role
	 * @return
	 */
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

	/**
	 * 修改角色信息
	 * 
	 * @param role
	 * @return
	 */
	int updateRole(@Param("r") Role role);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	int delRole(@Param("roleId") Integer roleId);

	/**
	 * 根据用户名删除用户拥有的角色
	 * 
	 * @param empLoginName
	 *            用户名
	 * @return
	 */
	int delRoleByEmp(@Param("emp") String empLoginName);

	/**
	 * 根据角色id 删除角色权限关联
	 * 
	 * @param roleId
	 *            角色id
	 * @return
	 */
	int delRolePermissionByRoleId(Integer roleId);

	/**
	 * 根据角色id查找角色信息
	 * 
	 * @param roleId
	 * @return
	 */
	Role findRoleById(Integer roleId);

	/**
	 * 根据用户名查找角色
	 * 
	 * @param emp
	 * @return
	 */
	List<Role> findRoleByEmp(@Param("emp") String emp);

}
