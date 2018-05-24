package cn.jxc.service;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.StockPile;

public interface StockPileService {
	
	/**
	 * ��ȡ���п����Ϣ����������ѯ
	 * 
	 * @param storeHouseId
	 *            �ֿ�id
	 * @param productId
	 *            ��Ʒid
	 * @param pageNo
	 *            ҳ��
	 * @param pageSize
	 *            ҳ��
	 * @return
	 */
	PageInfo<StockPile> getStockPileAll(Integer storeHouseId, String productId, Integer pageNo, Integer pageSize);
	
}
