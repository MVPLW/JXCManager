package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
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
		return purchaseRequestDetailMapper.purchaseRequestDetailAdd(purchaseRequestDetail);
	}

	@Override
	public int delPurchaseRequestDetail(int id) {
		return 0;
	}

	@Override
	public PageInfo<PurchaseRequestDetail> getPurchaseRequestDetail(String purchaseRequestNo, Integer num) {
		PageHelper.startPage(num, 3);
		List<PurchaseRequestDetail> purchaseRequestDetailBySingleNo = purchaseRequestDetailMapper.getPurchaseRequestDetailBySingleNo(purchaseRequestNo);
		PageInfo<PurchaseRequestDetail> pageInfo=new PageInfo<PurchaseRequestDetail>(purchaseRequestDetailBySingleNo);
		return pageInfo;
	}

}
