package cn.jxc.mapper;

import java.util.List;

import cn.jxc.pojo.StoreHouse;

public interface StoreHouseMapper {

	//查询仓库全部信息
	List<StoreHouse> getStoreHouselist();
}
