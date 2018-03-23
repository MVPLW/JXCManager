package cn.jxc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import cn.jxc.mapper.ReviewStatusMapper;
import cn.jxc.pojo.ReviewStatus;
import cn.jxc.service.ReviewStatusService;

@Service
public class ReviewStatusServiceImpl implements ReviewStatusService {

	@Autowired
	private ReviewStatusMapper rsmapper;
	//��ѯȫ�����״̬
	@Override
	public List<ReviewStatus> getReviewStatus() {
		
		return rsmapper.getReviewStatus();
	}
	
}
