package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.RequisitionDetailMapper;
import cn.jxc.pojo.RequisitionDetail;
import cn.jxc.service.RequisitionDetailService;
@Service
public class RequisitionDetailServiceImpl implements RequisitionDetailService{

	@Autowired
	private RequisitionDetailMapper rsdMapper;
	//按条件查询

	@Override
	public PageInfo<RequisitionDetail> requisitionDetailById(String rsid, Integer num, Integer pageSize) {
		PageHelper.startPage(num, pageSize);
		List<RequisitionDetail> requisitionbyid = rsdMapper.requisitionDetailById(rsid);
		PageInfo<RequisitionDetail> pageInfo = new PageInfo<RequisitionDetail>(requisitionbyid);
		return pageInfo;
	}
	
	//根据详情表的id删除数据
	@Transactional
	@Override
	public int delrequisitionByid(int reid) {
		
		return rsdMapper.delrequisitionByid(reid);
	}
	

}
