package cn.jxc.service;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.EnterStockDetail;

public interface EnterStockDetailService {

	/**
	 * ����������
	 * 
	 * @param enterStockDetail
	 *            ����������
	 * @return
	 */
	int enterStockDetailAdd(EnterStockDetail enterStockDetail);

	/**
	 * ���ݵ��ŷ�ҳ��ѯ�������
	 * 
	 * @param singleNo
	 *            ��ⵥ��
	 * @param pageNo
	 *            ҳ����
	 * @param pageSize
	 *            ÿҳ��ʾ����
	 * @return
	 */
	PageInfo<EnterStockDetail> getEnterStockDetailBySingleNo(String singleNo, Integer pageNo, Integer pageSize);

}
