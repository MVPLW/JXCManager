package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.PurchaseRequest;

/**
 * �ɹ�����mapper
 * @author Administrator
 *
 */
public interface PurchaseRequestMapper {
	
	List<PurchaseRequest> getPurReqInfoBySearch();
	
	int addPurchaseRequest(@Param("pr")PurchaseRequest purchaseRequest);
	
}
