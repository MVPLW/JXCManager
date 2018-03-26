package cn.jxc.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.PurchaseRequest;
import cn.jxc.service.PurchaseRequestService;

@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {

	@Override
	public int addPurchaseRequest(PurchaseRequest purchaseRequest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<PurchaseRequest> getPurchaseRequestByPage(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<PurchaseRequest> getPurchaseRequestByBlurry(int num, String empNo, String singleNo, String suppId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseRequest getPurchaseRequestById(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateDeptReivewStatus(String singleNo, String reviewEmp, Date date, Integer status) {
		// TODO Auto-generated method stub
		return 0;
	}

}
