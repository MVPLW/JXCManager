package cn.jxc.service;

import java.util.List;

import cn.jxc.pojo.SalesOrder;

public interface SaleService {
	//��ѯ�������۶���
	List<SalesOrder>getSaleAll();
	//������ѯ
	SalesOrder salesorderbyId(String soId);
	
	//����
	int SalesAdd(SalesOrder salesOrder);
	//�޸�
	int SalesUpdate(SalesOrder salesOrder);
}
