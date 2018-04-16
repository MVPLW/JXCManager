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
	 * ����
	 * */
	@Autowired
	private RequisitionMapper resMapper;
	@Autowired
	private RequisitionDetailMapper resdMapper;
	//��������ѯ
	@Override
	public Requisition requisitionByid(String requisitionId) {
		
		return resMapper.requisitionByid(requisitionId);
	}
	
	//��ѯ���еĵ�����������
	@Override
	public PageInfo<Requisition> getRequisition(String requisitionId,Integer rsid,Integer num,Integer pageSize) {
		PageHelper.startPage(num, pageSize);
		List<Requisition> requisition = resMapper.getRequisition(requisitionId,rsid);
		PageInfo<Requisition> pageInfos=new PageInfo<Requisition>(requisition);
		return pageInfos;
	}
	//��������
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
	//�����޸�
	@Override
	public int RequisitionUpdate(Requisition requisition) {
		
		return resMapper.RequisitionUpdete(requisition);
	}
	//����ɾ��
	@Override
	public int RequisitionDelete(String requisitionid) {
		try {
		resMapper.RequisitionDelete(requisitionid);
		resdMapper.RequisitionDetailDelete(requisitionid);
		return 1;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Requisition getRequisitionById(String requisitionId) {
		List<Requisition> requisitionByid = resMapper.getRequisition(requisitionId, null);
		
		return requisitionByid.get(0);
	}

}