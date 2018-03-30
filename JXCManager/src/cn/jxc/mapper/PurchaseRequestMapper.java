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
	
	/**
	 * ����������ѯ
	 * @param empNo    ������
	 * @param singleNo ���뵥��
	 * @param suppId   ��Ӧ��
	 * @return
	 */
	List<PurchaseRequest> getPurchaseRequestByBlurry(
			@Param("empNo")String empNo,
			@Param("singleNo")String singleNo,
			@Param("suppName")String suppName);
	
	/**
	 * ���
	 * @param purchaseRequest
	 * @return
	 */
	int addPurchaseRequest(@Param("pr")PurchaseRequest purchaseRequest);
	
	
}
