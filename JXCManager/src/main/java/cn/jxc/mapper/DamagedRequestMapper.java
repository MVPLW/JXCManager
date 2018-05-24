package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.DamagedRequest;

public interface DamagedRequestMapper {

	/**
	 * 查询所有的报损详情
	 * @param id    报损编号
	 * @param name  申请人姓名
	 * @return
	 */
	List<DamagedRequest> getDamageRequest(@Param("id")String id,@Param("name")String name);
	int AddDamagedRequest(DamagedRequest dr);
	
	
}
