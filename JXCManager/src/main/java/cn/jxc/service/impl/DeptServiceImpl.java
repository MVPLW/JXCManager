package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxc.mapper.DeptMapper;
import cn.jxc.pojo.Dept;
import cn.jxc.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> getDeptAll() {
		// TODO Auto-generated method stub
		return deptMapper.getDeptAll();
	}

}
