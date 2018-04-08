package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.SalesOrder;

public interface SalesOrderMapper {
		List<SalesOrder> getSaleAll();
		
		List<SalesOrder> getSale(
				@Param("soId")String soId,
				@Param("empLoginName")String empLoginName,
				@Param("customerId")Integer customerId);
		SalesOrder salesorderbyId(String soId);
}
