package cn.jxc.service;

import java.text.ParseException;
import java.util.Date;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.EnterStock;

public interface EnterStockService {

	/**
	 * 根据条件查询所有入库单
	 * 
	 * @param singleNo
	 *            单号
	 * @param shName
	 *            仓库名称
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @param pageNo
	 *            页码数
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 * @throws ParseException
	 */
	PageInfo<EnterStock> getEnterStockBySuless(String singleNo, String shName, String start, String end, Integer pageNo,
			Integer pageSize) throws ParseException;

	/**
	 * 添加一个入库单
	 * 
	 * @param enterStock
	 * @return
	 */
	int enterStockAdd(EnterStock enterStock);

	/**
	 * 入库单的审核
	 * 
	 * @param singleNo
	 *            单号
	 * @param emp
	 *            审核员工
	 * @param date
	 *            审核时间
	 * @param reviewStatus
	 *            审核状态
	 * @param reason
	 *            审核原因
	 * @return
	 */
	int enterStockReview(String singleNo, String emp, Date date, Integer reviewStatus, String reason);

	/**
	 * 入库单的信息修改
	 * 
	 * @param enterStock
	 *            入库单对象
	 * @return
	 */
	int enterStockUpdate(EnterStock enterStock);

	/**
	 * 根据订单号查询入库订单
	 * 
	 * @param singleNo   入库单号
	 * @return
	 */
	EnterStock getEnterStockBySingleNo(String singleNo);

}
