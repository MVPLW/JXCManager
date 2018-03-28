package cn.jxc.service;

import java.util.Date;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.PurchaseRequest;

/**
 * 采购申请 service
 * @author Administrator
 *
 */
public interface PurchaseRequestService {
	/**
	 * 添加采购申请 
	 * @param purchaseRequest 采购订单对象
	 * @return  是否成功
	 */
	int addPurchaseRequest(PurchaseRequest purchaseRequest);
	/**
	 * 分页查询采购申请 
	 * @param num 页码
	 * @return  采购申请对象集合
	 */
	PageInfo<PurchaseRequest> getPurchaseRequestByPage(int num);
	/**
	 * 分页+模糊查询采购申请
	 * @param num      页码
	 * @param empNo    申请人
	 * @param singleNo 单号
	 * @param suppId   供应商
	 * @return
	 */
	PageInfo<PurchaseRequest> getPurchaseRequestByBlurry(int num,String empNo,String singleNo,String suppId);
	/**
	 * 根据单号查询采购申请单
	 * @param no 单号
	 * @return 采购申请对象
	 */
	PurchaseRequest getPurchaseRequestById(String no);
	/**
	 * 更新部门审核状态  
	 * @param singleNo  申请单号
	 * @param reviewEmp 审核人
	 * @param date      时间
	 * @param status    状态
	 * @return         是否成功
	 */
	int updateDeptReivewStatus(String singleNo,String reviewEmp,Date date,Integer status);
}
