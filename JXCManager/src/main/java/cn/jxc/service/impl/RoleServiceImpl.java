package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.RoleMapper;
import cn.jxc.pojo.Role;
import cn.jxc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public PageInfo<Role> getRoleAll(Integer pageNo,Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<Role> roleAll = roleMapper.getRoleAll();
		return new PageInfo<>(roleAll);
	}

	@Override
	public int addRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delRole(Integer roleId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
