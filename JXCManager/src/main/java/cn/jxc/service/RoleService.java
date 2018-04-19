package cn.jxc.service;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Role;

public interface RoleService {
	
	PageInfo<Role> getRoleAll(Integer pageNo,Integer pageSize);
	
	int addRole(Role role);
	
	int updateRole(Role role);
	
	int delRole(Integer roleId);
	
}
