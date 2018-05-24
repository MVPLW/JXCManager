package cn.jxc.service;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.StockPile;

public interface StockPileService {
	
	/**
	 * 获取所有库存信息根据条件查询
	 * 
	 * @param storeHouseId
	 *            仓库id
	 * @param productId
	 *            产品id
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            页数
	 * @return
	 */
	PageInfo<StockPile> getStockPileAll(Integer storeHouseId, String productId, Integer pageNo, Integer pageSize);
	
}
