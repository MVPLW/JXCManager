package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.EmployeeMapper;
import cn.jxc.mapper.RoleMapper;
import cn.jxc.pojo.Role;
import cn.jxc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public PageInfo<Role> getRoleAll(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<Role> roleAll = roleMapper.getRoleAll();
		return new PageInfo<Role>(roleAll);
	}

	@Override
	public int addRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.addRole(role);
	}

	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.updateRole(role);
	}

	@Override
	public int delRoleById(String roleId) {
		// TODO Auto-generated method stub
		try {
			// 首先删除角色外键关联
			String[] a = roleId.split("-");
			for (int i = 1; i < a.length; i++) {
				// 根据角色删除角色权限关联
				roleMapper.delRolePermissionByRoleId(Integer.parseInt(a[i]));
				// 根据角色删除员工角色关联
				employeeMapper.deleteEmployeeRoleByRoleId(Integer.parseInt(a[i]));

				roleMapper.delRole(Integer.parseInt(a[i]));// 删除角色
			}
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Role findRoleById(Integer roleId) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleById(roleId);
	}

	@Override
	public List<Role> findRoleByEmp(String emp) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleByEmp(emp);
	}

	@Override
	public int delRoleByEmp(String empLoginName) {
		// TODO Auto-generated method stub
		return roleMapper.delRoleByEmp(empLoginName);
	}

	@Override
	public int addEmpRole(List<String> roles, String empLoginName) {
		try {
			// 循环添加用户角色
			for (String roleId : roles) {
				roleMapper.addEmpRole(empLoginName, roleId);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
