package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.EnterStockDetailMapper;
import cn.jxc.pojo.EnterStockDetail;
import cn.jxc.service.EnterStockDetailService;

@Service
public class EnterStockDetailServiceImpl implements EnterStockDetailService {

	@Autowired
	private EnterStockDetailMapper enterStockDetailMapper;

	@Transactional
	@Override
	public int enterStockDetailAdd(EnterStockDetail enterStockDetail) {
		// TODO Auto-generated method stub
		return enterStockDetailMapper.enterStockDetailAdd(enterStockDetail);
	}

	@Override
	public PageInfo<EnterStockDetail> getEnterStockDetailBySingleNo(String singleNo, Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<EnterStockDetail> enterStockDetailsBySingleNo = enterStockDetailMapper
				.getEnterStockDetailsBySingleNo(singleNo);
		return new PageInfo<>(enterStockDetailsBySingleNo);
	}

	@Transactional
	@Override
	public int updateEnterStockDetailByProductAndSingleNo(String singleNo, List<EnterStockDetail> enterStockDetails) {
		try {
			int a = 0;
			for (EnterStockDetail s : enterStockDetails) {
				a = 0;
				a = enterStockDetailMapper.updateEnterStockDetailByProductAndSingleNo(singleNo,
						s.getProduct().getProductId(), s.getProductCount());
				if (a == 0) {
					return 0;
				}
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Transactional
	@Override
	public int deleteEnterStockDetailBySingleNo(String singleNo) {
		// TODO Auto-generated method stub
		return enterStockDetailMapper.deleteEnterStockDetailBySingleNo(singleNo);
	}

}
