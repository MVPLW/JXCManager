package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Permission;

public interface PermissionMapper {
	// 获取所有权限信息
	List<Permission> getPermissionAll();

	// 添加权限信息
	Integer addPermission(@Param("per") Permission permission);

	// 修改权限信息
	Integer updatePermission(@Param("per") Permission permission);

	// 根据权限id删除权限
	Integer deletePermission(@Param("perId") int permissionId);

	// 根据员工登录名获取相关权限
	List<Permission> getPermissionByEmp(String empLoginName);

	// 根据角色获取相关权限
	List<Permission> getPermissionByRole(String roleId);

	/**
	 * 添加角色权限关联关系
	 */
	Integer addRolePermission(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);

	/**
	 * 根据角色删除相关关联关系
	 */
	Integer deletePermissionByRoleId(Integer roleId);

}
