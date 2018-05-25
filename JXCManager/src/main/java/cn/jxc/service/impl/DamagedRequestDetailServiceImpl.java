package cn.jxc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.jxc.mapper.DamagedRequestDetailMapper;
import cn.jxc.pojo.DamagedRequestDetail;
import cn.jxc.service.DamagedRequestDetailService;
import cn.jxc.util.OrderGenerator;
@Service
public class DamagedRequestDetailServiceImpl implements DamagedRequestDetailService{
	
	@Autowired
	private DamagedRequestDetailMapper dr;
}
