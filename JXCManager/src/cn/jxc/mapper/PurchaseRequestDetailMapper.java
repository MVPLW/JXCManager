package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.PurchaseRequestDetail;

public interface PurchaseRequestDetailMapper {

	/**
	 * 添加采购详情
	 * 
	 * @param purchaseRequestDetail
	 * @return
	 */
	int purchaseRequestDetailAdd(@Param("prd") PurchaseRequestDetail purchaseRequestDetail);

	/**
	 * 根据采购申请单号查询所有明细
	 * 
	 * @param singleNo
	 * @return
	 */
	List<PurchaseRequestDetail> getPurchaseRequestDetailBySingleNo(@Param("singleNo") String singleNo);

	/**
	 * 根据明细id删除一条明细
	 * 
	 * @param id
	 * @return 返回受影响的行数
	 */
	int delPurchaseRequestDetail(int id);

	/**
	 * 根据采购单号和产品编号修改采购明细的数量和价格
	 * @param singleNo  采购单号
	 * @param productId 产品编号
	 * @return
	 */
	int updatePurchaseRequestDetailBySingleNoAndProductId(@Param("singleNo") String singleNo,
			@Param("productId") String productId);
	
	/**
	 * 根据采购单号删除所有明细
	 * @param singleNo
	 * @return
	 */
	int delPurchaseRequestDetailBYSingleNo( String singleNo);

}
