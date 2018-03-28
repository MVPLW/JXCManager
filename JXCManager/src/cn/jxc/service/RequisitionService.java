package cn.jxc.service;

import java.util.List;

import cn.jxc.pojo.Requisition;

public interface RequisitionService {

	// 查询所有的调拨订单详情
	List<Requisition> getRequisition(String requisitionId,Integer rsid);

	// 按条件查询
	Requisition requisitionByid(String requisitionId);

	// 调拨新增
	int Requisitionadd(Requisition requisition);

	// 调拨修改
	int RequisitionUpdate(Requisition requisition);

}
