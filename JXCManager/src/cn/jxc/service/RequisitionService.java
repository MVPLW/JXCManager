package cn.jxc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Requisition;

public interface RequisitionService {

	//��ѯ���еĵ�����������
	List<Requisition> getRequisition();
	//��������ѯ���еĵ�����������
	List<Requisition> getRequisitionList(String requisitionId,Integer id);
		
	//��������ѯ
	Requisition requisitionByid(String requisitionId);
}
