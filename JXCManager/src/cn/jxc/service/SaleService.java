package cn.jxc.service;

import java.util.List;

import cn.jxc.pojo.SalesOrder;

public interface SaleService {
	//查询所有销售订单
	List<SalesOrder>getSaleAll();
	//条件查询
	SalesOrder salesorderbyId(String soId);
	
	//新增
	int SalesAdd(SalesOrder salesOrder);
	//修改
	int SalesUpdate(SalesOrder salesOrder);
}
