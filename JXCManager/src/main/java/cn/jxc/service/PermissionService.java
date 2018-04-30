package cn.jxc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Permission;

public interface PermissionService {

	PageInfo<Permission> getPermissionAll(Integer pageNo, Integer pageSize);

	Integer addPermission(Permission permission);

	Integer updatePermission(Permission permission);

	Integer deletePermission(int permissionId);

	List<Permission> findPermissionByEmp(String empLoginName);

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
