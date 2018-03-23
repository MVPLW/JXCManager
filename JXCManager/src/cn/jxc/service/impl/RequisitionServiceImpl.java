package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxc.mapper.RequisitionMapper;
import cn.jxc.pojo.Requisition;
import cn.jxc.service.RequisitionService;
@Service
public class RequisitionServiceImpl implements RequisitionService{

	@Autowired
	private RequisitionMapper resMapper;
	
	//��������ѯ���еĵ�����������
	@Override
	public List<Requisition> getRequisitionList(String requisitionId,Integer id) {
		
		return resMapper.getRequisitionList(requisitionId,id);
	}
	//��������ѯ
	@Override
	public Requisition requisitionByid(String requisitionId) {
		
		return resMapper.requisitionByid(requisitionId);
	}
	//��ѯ���еĵ�����������
	@Override
	public List<Requisition> getRequisition() {
		
		return resMapper.getRequisition();
	}

}
