package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.PurchaseRequest;

/**
 * 采购申请mapper
 * 
 * @author Administrator
 *
 */
public interface PurchaseRequestMapper {

	/**
	 * 根据条件查询
	 * 
	 * @param empNo
	 *            申请人
	 * @param singleNo
	 *            申请单号
	 * @param suppId
	 *            供应商
	 * @return
	 */
	List<PurchaseRequest> getPurchaseRequestByBlurry(@Param("empNo") String empNo, @Param("singleNo") String singleNo,
			@Param("suppName") String suppName);

	/**
	 * 添加
	 * 
	 * @param purchaseRequest
	 * @return
	 */
	int addPurchaseRequest(@Param("pr") PurchaseRequest purchaseRequest);

	/**
	 * 修改采购申请的基本信息
	 * 
	 * @param purchaseRequest
	 * @return
	 */
	int updatePurchaseRequest(@Param("pr") PurchaseRequest purchaseRequest);

	/**
	 * 修改订单状态
	 * 
	 * @param singleNo
	 *            订单号
	 * @param status
	 *            状态信息
	 * @return
	 */
	int updatePurchaseOrderStatus(@Param("singleNo") String singleNo, @Param("no") Integer status);

}
