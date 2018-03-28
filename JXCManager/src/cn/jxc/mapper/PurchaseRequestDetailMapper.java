package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.PurchaseRequestDetail;

public interface PurchaseRequestDetailMapper {
	
	/**
	 * 添加采购详情
	 * @param purchaseRequestDetail
	 * @return
	 */
	int purchaseRequestDetailAdd(
			@Param("prd")PurchaseRequestDetail purchaseRequestDetail);
	
	/**
	 * 根据采购申请单号查询所有明细
	 * @param singleNo
	 * @return
	 */
	List<PurchaseRequestDetail> getPurchaseRequestDetailBySingleNo(
			@Param("singleNo")String singleNo);
	
}
