package cn.jxc.service;

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

}
