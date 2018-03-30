package cn.jxc.service;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.PurchaseRequestDetail;

/**
 * 采购申请明细 service
 * @author Administrator
 *
 */
public interface PurchaseRequestDetailService {
	/**
	 * 添加采购申请明细
	 * @param purchaseRequestDetail
	 * @return
	 */
	int addPurchaseRequestDetail(PurchaseRequestDetail purchaseRequestDetail);
	
	/**
	 * 根据明细id删除明细
	 * @param id
	 * @return
	 */
	int delPurchaseRequestDetail(int id);
	
	/**
	 *  分页查询采购申请单的采购明细 
	 * @param purchaseRequestNo 采购申请单号
	 * @param num  页码
	 * @return
	 */
	PageInfo<PurchaseRequestDetail> getPurchaseRequestDetail(String purchaseRequestNo,Integer num);
	
}
