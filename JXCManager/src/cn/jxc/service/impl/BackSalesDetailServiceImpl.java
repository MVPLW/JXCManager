package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxc.mapper.BackSalesDetailMapper;
import cn.jxc.pojo.BackSalesDetail;
import cn.jxc.service.BackSalesDetailService;

@Service
public class BackSalesDetailServiceImpl implements BackSalesDetailService {
	
	@Autowired
	private BackSalesDetailMapper backSalesDetailMapper;
	
	@Override
	public List<BackSalesDetail> getBackSalesDetailBySingleNo(String singleNo) {
		// TODO Auto-generated method stub
		return backSalesDetailMapper.getBackSalesDetailBySingleNo(singleNo);
	}

}
