package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.EnterStockDetail;

public interface EnterStockDetailMapper {
	/**
	 * 入库详情添加的方法
	 * 
	 * @param enterStockDetail
	 * @return
	 */
	int enterStockDetailAdd(@Param("esd") EnterStockDetail enterStockDetail);

	/**
	 * 根据入库单号查询所有入库详细信息
	 * 
	 * @param singleNo
	 * @return
	 */
	List<EnterStockDetail> getEnterStockDetailsBySingleNo(@Param("singleNo") String singleNo);

	/**
	 * 根据入库编号和产品编号修改入库数量
	 * 
	 * @param singleNo
	 *            入库单号
	 * @param productId
	 *            产品编号
	 * @param count
	 *            产品数量
	 * @return
	 */
	int updateEnterStockDetailByProductAndSingleNo(
			@Param("singleNo") String singleNo,
			@Param("productId") String productId, 
			@Param("count")Integer count);

}
