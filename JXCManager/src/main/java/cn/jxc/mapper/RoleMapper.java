package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Role;

public interface RoleMapper {
	
	List<Role> getRoleAll();
	
	int addRole(@Param("r")Role role);
	
	int updateRole(@Param("r")Role role);
	
	int delRole(Integer roleId);
	
	Role findRoleById(Integer roleId);
	
}
