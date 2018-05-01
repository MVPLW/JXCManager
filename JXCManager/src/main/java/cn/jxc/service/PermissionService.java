package cn.jxc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Permission;

public interface PermissionService {

	/**
	 * 分页查询所有权限信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageInfo<Permission> getPermissionAll(Integer pageNo, Integer pageSize);

	/**
	 * 添加一个权限
	 * 
	 * @param permission
	 * @return
	 */
	Integer addPermission(Permission permission);

	/**
	 * 修改权限信息
	 * 
	 * @param permission
	 * @return
	 */
	Integer updatePermission(Permission permission);

	/**
	 * 根据权限id 删除权限信息
	 * 
	 * @param permissionId
	 * @return
	 */
	Integer deletePermission(int permissionId);

	/**
	 * 根据用户名查询用户拥有的权限
	 * 
	 * @param empLoginName
	 * @return
	 */
	List<Permission> findPermissionByEmp(String empLoginName);

	/**
	 * 根据角色编号查询拥有的权限
	 * 
	 * @param roleId
	 * @return
	 */
	List<Permission> getPermissionByRole(String roleId);

	/**
	 * 添加角色权限
	 * 
	 * @param roleId
	 *            角色ID
	 * @param permissionId
	 *            权限ID集合
	 * @return
	 */
	Integer addRolePermissionAssign(Integer roleId, List<Integer> permissionId);

}
