package cn.jxc.mapper;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.PurchaseRequestDetail;

public interface PurchaseRequestDetailMapper {
	
	/**
	 * ��Ӳɹ�����
	 * @param purchaseRequestDetail
	 * @return
	 */
	int purchaseRequestDetailAdd(
			@Param("prd")PurchaseRequestDetail purchaseRequestDetail);
	
}
