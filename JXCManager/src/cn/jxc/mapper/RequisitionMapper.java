package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Requisition;

public interface RequisitionMapper {
	
	/*
	 * ����
	 * 
	 * **/
	//��ѯ���еĵ�����������
	List<Requisition> getRequisition(
			@Param("requisitionId")String requisitionId,
			@Param("rsid")Integer rsid);
	//��������ѯ
	Requisition requisitionByid(String requisitionId);
	//������������
	int Requisitionadd(@Param("rs")Requisition requisition);
}
