package cn.jxc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.PurchaseRequestDetailMapper;
import cn.jxc.pojo.PurchaseRequestDetail;
import cn.jxc.service.PurchaseRequestDetailService;

@Service
public class PurchaseRequestDetailServiceImpl implements PurchaseRequestDetailService {

	@Autowired
	private PurchaseRequestDetailMapper purchaseRequestDetailMapper;
	
	@Override
	public int addPurchaseRequestDetail(PurchaseRequestDetail purchaseRequestDetail) {
		// TODO Auto-generated method stub
		return purchaseRequestDetailMapper.purchaseRequestDetailAdd(purchaseRequestDetail);
	}

	@Override
	public int delPurchaseRequestDetail(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<PurchaseRequestDetail> getPurchaseRequestDetail(String purchaseRequestNo, int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
