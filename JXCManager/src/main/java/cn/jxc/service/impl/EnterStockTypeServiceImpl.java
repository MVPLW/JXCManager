package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxc.mapper.EnterStockTypeMapper;
import cn.jxc.pojo.EnterStockType;
import cn.jxc.service.EnterStockTypeService;

@Service
public class EnterStockTypeServiceImpl implements EnterStockTypeService {

	@Autowired
	private EnterStockTypeMapper enterStockTypeMapper;
	@Override
	public List<EnterStockType> getEnterStockTypeAll() {
		return enterStockTypeMapper.getEnterStockTypeAll();
	}

}
