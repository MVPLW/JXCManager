package cn.jxc.service;

import java.util.List;

import cn.jxc.pojo.Requisition;

public interface RequisitionService {

	// ��ѯ���еĵ�����������
	List<Requisition> getRequisition(String requisitionId,Integer rsid);

	// ��������ѯ
	Requisition requisitionByid(String requisitionId);

	// ��������
	int Requisitionadd(Requisition requisition);

	// �����޸�
	int RequisitionUpdate(Requisition requisition);

}
