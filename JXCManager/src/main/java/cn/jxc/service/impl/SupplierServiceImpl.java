package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxc.mapper.SupplierMapper;
import cn.jxc.pojo.Supplier;
import cn.jxc.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;
	
	@Override
	public List<Supplier> getSupplierAll() {
		// TODO Auto-generated method stub
		return supplierMapper.getSupplierAll();
	}
	
}
