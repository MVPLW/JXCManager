package cn.test.service;

import cn.jxc.pojo.Permission;

public interface PermissionService {
	
	public Permission createPermission(Permission permission);
	
	public void deletePermission(int permissionId);
	
}
