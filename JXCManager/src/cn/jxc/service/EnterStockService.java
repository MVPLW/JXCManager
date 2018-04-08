package cn.jxc.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.EnterStock;

public interface EnterStockService {

	PageInfo<EnterStock> getEnterStockBySuless(String singleNo, String shName, String start, String end, Integer pageNo,
			Integer pageSize) throws ParseException;

	int enterStockAdd(EnterStock enterStock);

	int enterStockReview(String singleNo, String emp, Date date, Integer reviewStatus, String reason);

	int enterStockUpdate(EnterStock enterStock);
	
}
