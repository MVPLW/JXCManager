package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Permission;

public interface PermissionMapper {

	List<Permission> getPermissionAll();

	Integer addPermission(@Param("per") Permission permission);

	Integer updatePermission(@Param("per") Permission permission);

	Integer deletePermission(@Param("perId") int permissionId);
	
	List<Permission> getPermissionByEmp(String empLoginName);

}
