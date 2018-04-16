package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.BackSalesDetail;

public interface BackSalesDetailMapper {

	List<BackSalesDetail> getBackSalesDetailBySingleNo(@Param("singleNo") String singleNo);

}
