package cn.jxc.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Requisition;

public interface RequisitionMapper {
	
	/*
	 * 调拨
	 * 
	 * **/
	//查询所有的调拨订单详情
	List<Requisition> getRequisition(
			@Param("requisitionId")String requisitionId,
			@Param("requisitionnameEmp")String requisitionnameEmp);
	//按条件查询
	Requisition requisitionByid(String requisitionId);
	//调拨订单新增
	int Requisitionadd(@Param("rs")Requisition requisition);
	//调拨修改
	int RequisitionUpdete(@Param("rs")Requisition requisition);
	//根据id删除
	int RequisitionDelete(@Param("id")String requisitionid);
	//审核状态操作
	int updaterequisition(
			@Param("requisitionId")String requisitionId,
			@Param("reviewEmp")String reviewEmp,
			@Param("reviewTime")Date reviewTime,
			@Param("status")Integer reviewstatus,
			@Param("order")Integer order,
			@Param("reason")String reason);
	
}
