package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Requisition;
import cn.jxc.pojo.ReviewStatus;

public interface RequisitionMapper {
	//查询所有的调拨订单详情
	List<Requisition> getRequisition();
	//按条件查询所有的调拨订单详情
	List<Requisition> getRequisitionList(
			@Param("requisitionId")String requisitionId,
			@Param("id")Integer id);
	//按条件查询
	Requisition requisitionByid(String requisitionId);
}
