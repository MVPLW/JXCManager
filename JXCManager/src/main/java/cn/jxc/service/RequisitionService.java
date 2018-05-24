package cn.jxc.service;


import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Requisition;

public interface RequisitionService {

	/**
	 * 查询所有的调拨订单详情
	 * 
	 * @param requisitionId
	 * @param rsid
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageInfo<Requisition> getRequisition(String requisitionId, String requisitionnameEmp, Integer pageNo, Integer pageSize);

	Requisition getRequisitionById(String requisitionId);
	// 按条件查询
	Requisition requisitionByid(String requisitionId);

	// 调拨新增
	int Requisitionadd(Requisition requisition);

	// 调拨修改
	int RequisitionUpdate(Requisition requisition);
	
	//根据id删除
	int RequisitionDelete(String requisitionid);
}
