package cn.jxc.mapper;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.RequisitionDetail;

public interface RequisitionDetailMapper {

	/*
	 * 调拨明细表
	 * */
	//调拨明细表新增
	int addRequisitionDetail(@Param("rsd")RequisitionDetail requisitiondetail);
}
