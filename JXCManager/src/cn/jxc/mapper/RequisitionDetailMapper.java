package cn.jxc.mapper;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.RequisitionDetail;

public interface RequisitionDetailMapper {

	/*
	 * ������ϸ��
	 * */
	//������ϸ������
	int addRequisitionDetail(@Param("rsd")RequisitionDetail requisitiondetail);
}
