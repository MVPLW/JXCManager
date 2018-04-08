package cn.jxc.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.EnterStockMapper;
import cn.jxc.pojo.EnterStock;
import cn.jxc.service.EnterStockService;
import cn.jxc.util.DateConverter;

@Service
public class EnterStockServiceImpl implements EnterStockService {

	@Autowired
	private EnterStockMapper enterStockMapper;

	@Override
	public PageInfo<EnterStock> getEnterStockBySuless(String singleNo, String shName, String start, String end,
			Integer pageNo, Integer pageSize) throws ParseException {
		PageHelper.startPage(pageNo, pageSize);
		List<EnterStock> enterStocks = enterStockMapper.getEnterStockBySuless(singleNo, shName,
				DateConverter.convertStringyyyy(start), DateConverter.convertStringyyyy(end));
		return new PageInfo<EnterStock>(enterStocks);
	}

	@Override
	public int enterStockAdd(EnterStock enterStock) {
		// TODO Auto-generated method stub
		return enterStockMapper.enterStockAdd(enterStock);
	}

	@Override
	public int enterStockReview(String singleNo, String emp, Date date, Integer reviewStatus, String reason) {
		// TODO Auto-generated method stub
		return enterStockMapper.enterStockReview(singleNo, emp, date, reviewStatus, reason);
	}

	@Override
	public int enterStockUpdate(EnterStock enterStock) {
		// TODO Auto-generated method stub
		return enterStockMapper.enterStockUpdate(enterStock);
	}

}
