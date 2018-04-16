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
	 * @param pageSize 页面显示数量
	 * @return
	 */
	PageInfo<PurchaseRequestDetail> getPurchaseRequestDetail(String purchaseRequestNo,Integer num,Integer pageSize);
	
	/**
	 * 根据采购单号和产品编号修改采购明细的数量和价格
	 * @param singleNo 采购单号
	 * @param productId产品编号
	 * @return
	 */
	int updatePurchaseRequestDetailBySingleNoAndProductId(String singleNo,String productId);
	
	/**
	 * 根据采购单号删除所有明细 
	 * @param singleNo 采购单号
	 * @return
	 */
	int delPurchaseRequestDetailBYSingleNo( String singleNo);
	
}
