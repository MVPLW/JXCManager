package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.PermissionMapper;
import cn.jxc.pojo.Permission;
import cn.jxc.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public PageInfo<Permission> getPermissionAll(Integer pageNo,Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<Permission> permissionAll = permissionMapper.getPermissionAll();
		return new PageInfo<Permission>(permissionAll);
	}

	@Override
	public Integer addPermission(Permission permission) {
		// TODO Auto-generated method stub
		return permissionMapper.addPermission(permission);
	}

	@Override
	public Integer updatePermission(Permission permission) {
		// TODO Auto-generated method stub
		return permissionMapper.updatePermission(permission);
	}

	@Override
	public Integer deletePermission(int permissionId) {
		// TODO Auto-generated method stub
		return permissionMapper.deletePermission(permissionId);
	}

	@Override
	public List<Permission> getPermissionByEmp(String empLoginName) {
		// TODO Auto-generated method stub
		return permissionMapper.getPermissionByEmp(empLoginName);
	}
	
}
