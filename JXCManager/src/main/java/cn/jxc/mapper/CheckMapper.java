package cn.jxc.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Checks;

public interface CheckMapper {
	List<Checks> getALLChecks(@Param("cid") String cid, @Param("crelationno") String crelationno,
			@Param("createStartDate") Date createStartDate, @Param("createEndDate") Date createEndDate);
}
