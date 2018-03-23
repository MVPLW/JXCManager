package cn.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jxc.mapper.ProductMapper;
import cn.jxc.pojo.Product;
import cn.jxc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * 分页获取产品信息
	 */
	@Override
	public PageInfo<Product> getProductAll(int num) {
		PageHelper.startPage(num, 5);
		List<Product> productAll = productMapper.getProductAll();
		PageInfo<Product> pageInfo=new PageInfo<Product>(productAll);
		return pageInfo;
	}

}
