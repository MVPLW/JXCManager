package cn.jxc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
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
			String orderNo = OrderGenerator.getOrderNo("CG");
			purchaseRequest.setPurchaseRequestId(orderNo);
			// 循环给订单详情表中的字段赋值 并且在数据库中添加数据
			purchaseRequestMapper.addPurchaseRequest(purchaseRequest);
			for (int i = 0; i < purchaseRequest.getPurchaserequestdetails().size(); i++) {
				purchaseRequest.getPurchaserequestdetails().get(i).setPurchaserequest(purchaseRequest);
				purchaseRequestDetailService
						.addPurchaseRequestDetail(purchaseRequest.getPurchaserequestdetails().get(i));
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public PageInfo<PurchaseRequest> getPurchaseRequestByBlurry(Integer num, String empNo, String singleNo,
			String suppName) {
		//开始分页  num是页码  第二个参数是每页显示的数量
		PageHelper.startPage(num, 5);
		List<PurchaseRequest> purchaseRequests=purchaseRequestMapper.getPurchaseRequestByBlurry(empNo, singleNo, suppName);
		PageInfo<PurchaseRequest> pageInfos=new PageInfo<PurchaseRequest>(purchaseRequests);
		return pageInfos;
	}

	@Override
	public PurchaseRequest getPurchaseRequestBySingleNo(String singleNo) {
		List<PurchaseRequest> purchaseRequestByBlurry = purchaseRequestMapper.getPurchaseRequestByBlurry(null, singleNo, null);
		return purchaseRequestByBlurry.get(0);
	}
	
	@Override
	public int updateDeptReivewStatus(String singleNo, String reviewEmp, Date date, Integer status) {
		// TODO Auto-generated method stub
		return 0;
	}

}
