package cn.jxc.service;

import java.util.Date;


import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Checks;

public interface ChecksService {
	PageInfo<Checks> getALLChecks(String v, String crelationno, Date createStartDate, Date createEndDate,
			Integer pageNo, Integer pageSize);
}
