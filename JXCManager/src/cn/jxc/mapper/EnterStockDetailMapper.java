package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.EnterStockDetail;

public interface EnterStockDetailMapper {
	/**
	 * ���������ӵķ���
	 * 
	 * @param enterStockDetail
	 * @return
	 */
	int enterStockDetailAdd(@Param("esd") EnterStockDetail enterStockDetail);

	/**
	 * ������ⵥ�Ų�ѯ���������ϸ��Ϣ
	 * 
	 * @param singleNo
	 * @return
	 */
	List<EnterStockDetail> getEnterStockDetailsBySingleNo(@Param("singleNo") String singleNo);

}
