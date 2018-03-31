package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;

import cn.jxc.mapper.RequisitionDetailMapper;
import cn.jxc.mapper.RequisitionMapper;
import cn.jxc.pojo.Requisition;
import cn.jxc.service.RequisitionService;
import cn.jxc.util.OrderGenerator;
@Service
public class RequisitionServiceImpl implements RequisitionService{

	/*
	 * 调拨
	 * */
	@Autowired
	private RequisitionMapper resMapper;
	@Autowired
	private RequisitionDetailMapper resdMapper;
	//按条件查询
	@Override
	public Requisition requisitionByid(String requisitionId) {
		
		return resMapper.requisitionByid(requisitionId);
	}
	
	//查询所有的调拨订单详情
	@Override
	public PageInfo<Requisition> getRequisition(String requisitionId,Integer rsid,Integer num) {
		PageHelper.startPage(num, 10);
		List<Requisition> requisition = resMapper.getRequisition(requisitionId,rsid);
		PageInfo<Requisition> pageInfos=new PageInfo<Requisition>(requisition);
		return pageInfos;
	}
	//调拨新增
	@Override
	public int Requisitionadd(Requisition requisition) {
		try {
			String requisitionid=OrderGenerator.getOrderNo("DB");
			requisition.setRequisitionId(requisitionid);
			resMapper.Requisitionadd(requisition);
			for(int i=0;i<requisition.getRequisitiondetails().size();i++) {
				requisition.getRequisitiondetails().get(i).setRequisition(requisition);
				resdMapper.addRequisitionDetail(requisition.getRequisitiondetails().get(i));
			}
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	//调拨修改
	@Override
	public int RequisitionUpdate(Requisition requisition) {
		// TODO 自动生成的方法存根
		return 0;
	}

}