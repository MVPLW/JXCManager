package cn.jxc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.RequisitionDetail;

public interface RequisitionDetailService {

	//��������ѯ������ϸ��
	PageInfo<RequisitionDetail> requisitionDetailById(String rsid,Integer num,Integer pageSize);
	//����������idɾ������
	int delrequisitionByid(int reid);
}
