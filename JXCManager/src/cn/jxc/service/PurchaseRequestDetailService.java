package cn.jxc.service;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.PurchaseRequestDetail;

/**
 * �ɹ�������ϸ service
 * @author Administrator
 *
 */
public interface PurchaseRequestDetailService {
	/**
	 * ��Ӳɹ�������ϸ
	 * @param purchaseRequestDetail
	 * @return
	 */
	int addPurchaseRequestDetail(PurchaseRequestDetail purchaseRequestDetail);
	
	/**
	 * ������ϸidɾ����ϸ
	 * @param id
	 * @return
	 */
	int delPurchaseRequestDetail(int id);
	
	/**
	 *  ��ҳ��ѯ�ɹ����뵥�Ĳɹ���ϸ 
	 * @param purchaseRequestNo �ɹ����뵥��
	 * @param num  ҳ��
	 * @return
	 */
	PageInfo<PurchaseRequestDetail> getPurchaseRequestDetail(String purchaseRequestNo,Integer num);
	
}
