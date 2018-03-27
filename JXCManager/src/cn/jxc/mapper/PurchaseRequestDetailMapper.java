package cn.jxc.mapper;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.PurchaseRequestDetail;

public interface PurchaseRequestDetailMapper {
	
	/**
	 * ÃÌº”≤…π∫œÍ«È
	 * @param purchaseRequestDetail
	 * @return
	 */
	int purchaseRequestDetailAdd(
			@Param("prd")PurchaseRequestDetail purchaseRequestDetail);
	
}
