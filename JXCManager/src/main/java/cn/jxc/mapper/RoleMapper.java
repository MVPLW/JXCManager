package cn.jxc.mapper;

import java.util.List;

import cn.jxc.pojo.Role;

public interface RoleMapper {
	
	List<Role> getRoleAll();
	
	int addRole(Role role);
	
	int updateRole(Role role);
	
	int delRole(Integer roleId);
	
}
