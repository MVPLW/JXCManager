package cn.jxc.service;


import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.RequisitionDetail;

public interface RequisitionDetailService {

	//按条件查询调拨明细表
	PageInfo<RequisitionDetail> requisitionDetailById(String rsid,Integer num,Integer pageSize);
	//删除
	int delrequisitionByid(int reid);
}
