package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.DamagedRequestDetailMapper;
import cn.jxc.mapper.DamagedRequestMapper;
import cn.jxc.pojo.DamagedRequest;
import cn.jxc.service.DamagedRequestService;
import cn.jxc.util.OrderGenerator;

@Service
public class DamagedRequestServiceImpl implements DamagedRequestService{
	/**
	 * 
	 * 报损
	 */
	@Autowired
	private DamagedRequestMapper damMapper;
	@Autowired
	private DamagedRequestDetailMapper drdmapper;
	/**
	 * 查询所有
	 */
	@Override
	public PageInfo<DamagedRequest> getDamageRequest(String damagedid, String damagredname, Integer pageNo,
			Integer pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		List<DamagedRequest> damaged = damMapper.getDamageRequest(damagedid, damagredname);
		PageInfo<DamagedRequest> pageinfo = new PageInfo<DamagedRequest>(damaged);
		return pageinfo;
	}
	@Override
	public int AddDamagedRequest(DamagedRequest dr) {
		try {
			String damagedrequest=OrderGenerator.getOrderNo("BS");
			dr.setDamagedRequestId(damagedrequest);
			damMapper.AddDamagedRequest(dr);
			for(int i=0;i<dr.getDamagedrequestdetail().size();i++) {
				dr.getDamagedrequestdetail().get(i).setDamagedRequest(dr);
				drdmapper.AddDamagedRequesDetail(dr.getDamagedrequestdetail().get(i));
			}
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	
}
