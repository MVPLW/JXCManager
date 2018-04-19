package cn.test.service;

import cn.jxc.pojo.Role;

public interface RoleService {

	public Role createRole(Role role);

	public void deleteRole(Long roleId);

	// 添加角色-权限之间关系
	public void correlationPermissions(int roleId, int... permissionIds);

	// 移除角色-权限之间关系
	public void uncorrelationPermissions(int roleId, int... permissionIds);//
}
