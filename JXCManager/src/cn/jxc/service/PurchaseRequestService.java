package cn.jxc.service;

import java.util.Date;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.PurchaseRequest;

/**
 * �ɹ����� service
 * 
 * @author Administrator
 *
 */
public interface PurchaseRequestService {
	/**
	 * ���Ӳɹ�����
	 * 
	 * @param purchaseRequest
	 *            �ɹ���������
	 * @return �Ƿ�ɹ�
	 */
	int addPurchaseRequest(PurchaseRequest purchaseRequest);

	/**
	 * ��ҳ+ģ����ѯ�ɹ�����
	 * 
	 * @param num
	 *            ҳ��
	 * @param empNo
	 *            ������
	 * @param singleNo
	 *            ����
	 * @param suppId
	 *            ��Ӧ��
	 * @return
	 */
	PageInfo<PurchaseRequest> getPurchaseRequestByBlurry(Integer num, String empNo, String singleNo, String suppName);

	/**
	 * ���ݵ��Ų�ѯ�ɹ����뵥
	 * 
	 * @param no
	 *            ����
	 * @return �ɹ��������
	 */
	PurchaseRequest getPurchaseRequestBySingleNo(String singleNo);

	/**
	 * ���²������״̬
	 * 
	 * @param singleNo
	 *            ���뵥��
	 * @param reviewEmp
	 *            �����
	 * @param date
	 *            ʱ��
	 * @param status
	 *            ״̬
	 * @return �Ƿ�ɹ�
	 */
	int updateDeptReivewStatus(String singleNo, String reviewEmp, Date date, Integer status);

	/**
	 * �޸Ĳɹ�������Ϣ
	 * 
	 * @param purchaseRequest
	 * @return
	 */
	int updatePurchaseRequest(PurchaseRequest purchaseRequest);
	
	/**
	 * ���ݶ����ź�״̬�޸Ķ���״̬
	 * @param singleNo 
	 * @param status   
	 * @return
	 */
	int updatePurchaseOrderStatus(String singleNo, Integer status);

}