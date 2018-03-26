package cn.jxc.service;

import java.util.Date;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.PurchaseRequest;

/**
 * �ɹ����� service
 * @author Administrator
 *
 */
public interface PurchaseRequestService {
	/**
	 * ��Ӳɹ����� 
	 * @param purchaseRequest �ɹ���������
	 * @return  �Ƿ�ɹ�
	 */
	int addPurchaseRequest(PurchaseRequest purchaseRequest);
	/**
	 * ��ҳ��ѯ�ɹ����� 
	 * @param num ҳ��
	 * @return  �ɹ�������󼯺�
	 */
	PageInfo<PurchaseRequest> getPurchaseRequestByPage(int num);
	/**
	 * ��ҳ+ģ����ѯ�ɹ�����
	 * @param num      ҳ��
	 * @param empNo    ������
	 * @param singleNo ����
	 * @param suppId   ��Ӧ��
	 * @return
	 */
	PageInfo<PurchaseRequest> getPurchaseRequestByBlurry(int num,String empNo,String singleNo,String suppId);
	/**
	 * ���ݵ��Ų�ѯ�ɹ����뵥
	 * @param no ����
	 * @return �ɹ��������
	 */
	PurchaseRequest getPurchaseRequestById(String no);
	/**
	 * ���²������״̬  
	 * @param singleNo  ���뵥��
	 * @param reviewEmp �����
	 * @param date      ʱ��
	 * @param status    ״̬
	 * @return         �Ƿ�ɹ�
	 */
	int updateDeptReivewStatus(String singleNo,String reviewEmp,Date date,Integer status);
}
