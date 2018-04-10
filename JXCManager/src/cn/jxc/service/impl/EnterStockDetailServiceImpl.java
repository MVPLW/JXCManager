package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.EnterStockDetailMapper;
import cn.jxc.pojo.EnterStockDetail;
import cn.jxc.service.EnterStockDetailService;

@Service
public class EnterStockDetailServiceImpl implements EnterStockDetailService {
	
	@Autowired
	private EnterStockDetailMapper enterStockDetailMapper;

	@Override
	public int enterStockDetailAdd(EnterStockDetail enterStockDetail) {
		// TODO Auto-generated method stub
		return enterStockDetailMapper.enterStockDetailAdd(enterStockDetail);
	}

	@Override
	public PageInfo<EnterStockDetail> getEnterStockDetailBySingleNo(String singleNo, Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<EnterStockDetail> enterStockDetailsBySingleNo = enterStockDetailMapper.getEnterStockDetailsBySingleNo(singleNo);
		return new PageInfo<>(enterStockDetailsBySingleNo);
	}

}
