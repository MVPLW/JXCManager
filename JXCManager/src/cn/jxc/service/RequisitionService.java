package cn.jxc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Requisition;

public interface RequisitionService {

	
	/*
	 * 
	 * ����
	 * */
	// ��ѯ���еĵ�����������
	PageInfo<Requisition> getRequisition(String requisitionId,
			Integer rsid,Integer num);

	// ��������ѯ
	Requisition requisitionByid(String requisitionId);

	// ��������
	int Requisitionadd(Requisition requisition);

	// �����޸�
	int RequisitionUpdate(Requisition requisition);

}
