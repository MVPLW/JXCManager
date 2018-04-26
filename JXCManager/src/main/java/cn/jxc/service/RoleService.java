package cn.jxc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Role;

public interface RoleService {

	PageInfo<Role> getRoleAll(Integer pageNo, Integer pageSize);

	int addRole(Role role);

	int addEmpRole(List<String> roles, String empLoginName);

	int updateRole(Role role);

	int delRole(Integer roleId);

	/**
	 * �����û���ɾ���û���ɫ
	 * 
	 * @param empLoginName
	 * @return
	 */
	int delRoleByEmp(String empLoginName);

	Role findRoleById(Integer roleId);

	List<Role> findRoleByEmp(String emp);

}
