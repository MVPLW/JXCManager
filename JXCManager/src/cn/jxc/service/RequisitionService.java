package cn.jxc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Requisition;

public interface RequisitionService {

	//查询所有的调拨订单详情
	List<Requisition> getRequisition();
	//按条件查询所有的调拨订单详情
	List<Requisition> getRequisitionList(String requisitionId,Integer id);
		
	//按条件查询
	Requisition requisitionByid(String requisitionId);
}
