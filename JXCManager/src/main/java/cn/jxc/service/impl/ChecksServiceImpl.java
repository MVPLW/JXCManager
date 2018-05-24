package cn.jxc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.CheckMapper;
import cn.jxc.pojo.Checks;
import cn.jxc.service.ChecksService;

@Service
public class ChecksServiceImpl implements ChecksService {
	@Autowired
	private CheckMapper checkmapper;

	@Override
	public PageInfo<Checks> getALLChecks(String cid, String crelationno, Date createStartDate, Date createEndDate,
			Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaservice业务层");
		System.out.println(pageNo);
		System.out.println(pageSize);
		PageHelper.startPage(pageNo, pageSize);
		System.err.println("进入service业务层");
		List<Checks> allChecks = checkmapper.getALLChecks(cid, crelationno, createStartDate, createEndDate);
		PageInfo<Checks> pageInfo = new PageInfo<Checks>(allChecks);
		return pageInfo;
	}

}
