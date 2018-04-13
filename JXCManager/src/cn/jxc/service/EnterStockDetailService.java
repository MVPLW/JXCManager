package cn.jxc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.EnterStockDetail;

public interface EnterStockDetailService {

	/**
	 * 添加入库详情
	 * 
	 * @param enterStockDetail
	 *            入库详情对象
	 * @return
	 */
	int enterStockDetailAdd(EnterStockDetail enterStockDetail);

	/**
	 * 根据单号分页查询入库详情
	 * 
	 * @param singleNo
	 *            入库单号
	 * @param pageNo
	 *            页码数
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 */
	PageInfo<EnterStockDetail> getEnterStockDetailBySingleNo(String singleNo, Integer pageNo, Integer pageSize);

	/**
	 * 修改入库的详情数量 根据单号
	 * 
	 * @param singleNo
	 *            单号
	 * @param enterStockDetails
	 *            要修改的详情集合
	 * @return
	 */
	int updateEnterStockDetailByProductAndSingleNo(String singleNo, List<EnterStockDetail> enterStockDetails);

	/**
	 * 根据入库单号删除所有入库明细
	 * 
	 * @param singleNo
	 *            入库单号
	 * @return
	 */
	int deleteEnterStockDetailBySingleNo(String singleNo);

}
