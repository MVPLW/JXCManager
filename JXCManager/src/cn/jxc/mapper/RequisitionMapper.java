package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Requisition;
import cn.jxc.pojo.ReviewStatus;

public interface RequisitionMapper {
	//��ѯ���еĵ�����������
	List<Requisition> getRequisition();
	//��������ѯ���еĵ�����������
	List<Requisition> getRequisitionList(
			@Param("requisitionId")String requisitionId,
			@Param("id")Integer id);
	//��������ѯ
	Requisition requisitionByid(String requisitionId);
}
