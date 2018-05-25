package cn.jxc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.DamagedRequest;
import cn.jxc.pojo.Requisition;

public interface DamagedRequestService {

	/**
	 * 
	 * 查询所有和分页
	 * @param id
	 * @param name
	 * @return
	 */
	PageInfo<DamagedRequest> getDamageRequest(String damagedid, String damagredname, Integer pageNo, Integer pageSize);
	int AddDamagedRequest(DamagedRequest dr);
}
