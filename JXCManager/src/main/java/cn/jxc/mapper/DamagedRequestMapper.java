package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.DamagedRequest;

public interface DamagedRequestMapper {

	/**
	 * ��ѯ���еı�������
	 * @param id    ������
	 * @param name  ����������
	 * @return
	 */
	List<DamagedRequest> getDamageRequest(@Param("id")String id,@Param("name")String name);
	int AddDamagedRequest(DamagedRequest dr);
	
	
}
