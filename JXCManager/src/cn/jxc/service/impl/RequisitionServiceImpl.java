package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxc.mapper.RequisitionMapper;
import cn.jxc.pojo.Requisition;
import cn.jxc.pojo.ReviewStatus;
import cn.jxc.service.RequisitionService;
@Service
public class RequisitionServiceImpl implements RequisitionService{

	@Autowired
	private RequisitionMapper resMapper;
	
	//按条件查询
	@Override
	public Requisition requisitionByid(String requisitionId) {
		
		return resMapper.requisitionByid(requisitionId);
	}
	
	//查询所有的调拨订单详情
	@Override
	public List<Requisition> getRequisition(String requisitionId,Integer rsid) {
		
		return resMapper.getRequisition(requisitionId,rsid);
	}
	//调拨新增
	@Override
	public int Requisitionadd(Requisition requisition) {
		// TODO 自动生成的方法存根
		return 0;
	}
	//调拨修改
	@Override
	public int RequisitionUpdate(Requisition requisition) {
		// TODO 自动生成的方法存根
		return 0;
	}

}
