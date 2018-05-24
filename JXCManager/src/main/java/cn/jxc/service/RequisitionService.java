package cn.jxc.service;


import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Requisition;

public interface RequisitionService {

	/**
	 * ��ѯ���еĵ�����������
	 * 
	 * @param requisitionId
	 * @param rsid
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageInfo<Requisition> getRequisition(String requisitionId, String requisitionnameEmp, Integer pageNo, Integer pageSize);

	Requisition getRequisitionById(String requisitionId);
	// ��������ѯ
	Requisition requisitionByid(String requisitionId);

	// ��������
	int Requisitionadd(Requisition requisition);

	// �����޸�
	int RequisitionUpdate(Requisition requisition);
	
	//����idɾ��
	int RequisitionDelete(String requisitionid);
}
