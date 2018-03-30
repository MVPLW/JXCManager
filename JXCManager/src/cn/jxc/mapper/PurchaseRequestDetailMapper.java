package cn.jxc.mapper;

import java.util.List;

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
	
	/**
	 * ���ݲɹ����뵥�Ų�ѯ������ϸ
	 * @param singleNo
	 * @return
	 */
	List<PurchaseRequestDetail> getPurchaseRequestDetailBySingleNo(
			@Param("singleNo")String singleNo);
	
}
