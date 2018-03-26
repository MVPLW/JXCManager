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
	
	//��������ѯ
	@Override
	public Requisition requisitionByid(String requisitionId) {
		
		return resMapper.requisitionByid(requisitionId);
	}
	
	//��ѯ���еĵ�����������
	@Override
	public List<Requisition> getRequisition(String requisitionId,Integer rsid) {
		
		return resMapper.getRequisition(requisitionId,rsid);
	}
	//��������
	@Override
	public int Requisitionadd(Requisition requisition) {
		// TODO �Զ����ɵķ������
		return 0;
	}
	//�����޸�
	@Override
	public int RequisitionUpdate(Requisition requisition) {
		// TODO �Զ����ɵķ������
		return 0;
	}

}
