package cn.jxc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.PurchaseRequestMapper;
import cn.jxc.pojo.PurchaseRequest;
import cn.jxc.service.PurchaseRequestDetailService;
import cn.jxc.service.PurchaseRequestService;
import cn.jxc.util.OrderGenerator;

@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
	
	@Autowired
	private PurchaseRequestMapper purchaseRequestMapper;
	
	@Autowired
	private PurchaseRequestDetailService purchaseRequestDetailService;
	
	@Override
	public int addPurchaseRequest(PurchaseRequest purchaseRequest) {
		try {
			String orderNo=OrderGenerator.getOrderNo("CG");
			purchaseRequest.setPurchaseRequestId(orderNo);
			//循环给订单详情表中的字段赋值  并且在数据库中添加数据
			purchaseRequestMapper.addPurchaseRequest(purchaseRequest);
			for(int i=0;i<purchaseRequest.getPurchaserequestdetails().size();i++) {
				purchaseRequest.getPurchaserequestdetails().get(i).setPurchaserequest(purchaseRequest);
				purchaseRequestDetailService.addPurchaseRequestDetail(purchaseRequest.getPurchaserequestdetails().get(i));
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
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
