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
	//根据调拨详情表id删除
	int delrequisitionByid(int reid);
	//根据调拨表的id删除数据
	int RequisitionDetailDelete(@Param("id")String requisitionid);
}
