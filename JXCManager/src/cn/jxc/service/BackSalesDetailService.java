package cn.jxc.service;

import java.util.List;

import cn.jxc.pojo.BackSalesDetail;

public interface BackSalesDetailService {
	List<BackSalesDetail> getBackSalesDetailBySingleNo(String singleNo);
}
