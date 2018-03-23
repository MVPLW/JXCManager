package cn.jxc.service;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Product;

public interface ProductService {
	PageInfo<Product> getProductAll(int num);
}
