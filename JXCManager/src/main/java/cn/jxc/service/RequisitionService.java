package cn.jxc.service;


import org.apache.ibatis.annotations.Param;

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
	PageInfo<Requisition> getRequisition(String requisitionId, Integer rsid, Integer pageNo, Integer pageSize);

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