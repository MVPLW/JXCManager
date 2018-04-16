package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxc.mapper.BackSalesMapper;
import cn.jxc.pojo.BackSales;
import cn.jxc.service.BackSalesService;

@Service
public class BackSalesServiceImpl implements BackSalesService {
	@Autowired
	private BackSalesMapper backSalesMapper;
	@Override
	public List<BackSales> getBackSalesAll() {
		// TODO Auto-generated method stub
		return backSalesMapper.getBackSalesAll();
	}

}
