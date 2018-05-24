package cn.jxc.service;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Product;

public interface ProductService {
	/**
	 * 分页查询所有产品信息
	 * @param num 页码
	 * @return   返回产品信息集合
	 */
	PageInfo<Product> getProductAll(int num,int pageSize);
	
	/**
	 * 根据产品名字和编号进行模糊分页查询
	 * @param num  页码
	 * @param name 产品名字
	 * @param no 产品编号
	 * @return
	 */
	PageInfo<Product> getProductByNameAndNum(Integer num,String name,String no);
	
}
