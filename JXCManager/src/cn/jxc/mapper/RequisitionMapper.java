package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Requisition;
import cn.jxc.pojo.ReviewStatus;

public interface RequisitionMapper {
	//查询所有的调拨订单详情
	List<Requisition> getRequisition(
			@Param("requisitionId")String requisitionId,
			@Param("rsid")Integer rsid);
	//按条件查询
	Requisition requisitionByid(String requisitionId);
}
