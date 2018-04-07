package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.RequisitionDetail;

public interface RequisitionDetailMapper {

	/*
	 * 调拨明细表
	 * */
	//调拨明细表新增
	int addRequisitionDetail(@Param("rsd")RequisitionDetail requisitiondetail);
	
	//按条件查询调拨明细表
	List<RequisitionDetail> requisitionDetailById(String rsid);
	
	//根据详情表的id删除数据
	int delrequisitionByid(int reid);
}
