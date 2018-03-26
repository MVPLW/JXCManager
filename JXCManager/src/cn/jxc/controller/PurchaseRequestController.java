
package cn.jxc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.PurchaseRequest;
import cn.jxc.pojo.Supplier;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.SupplierService;

@Controller
public class PurchaseRequestController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/gopurchase")
	public String gopurchase() {
		return "purchase/purchaseRequest";
	}
	
	@RequestMapping("/goPurchaseRequest")
	public String goPurchaseRequest(Model model) {
		List<Employee> employees=employeeService.getEmployeeAll();
		List<Supplier> suppliers=supplierService.getSupplierAll();
		PageInfo<Product> productAll = productService.getProductAll(1);  //分页查询  刚开始进入查询第一页的数据
		
		model.addAttribute("employees", employees);
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("productAll", productAll);
		
		return "purchase/purchaseRequestAdd";
	}
	
	/**
	 * 通过ajax实现分页产品信息
	 * @return
	 */
	@RequestMapping(value="/getProductByPage",method=RequestMethod.POST)
	@ResponseBody
	public String getProductPage(@RequestParam("pageNum") Integer pageNum) {
		PageInfo<Product> productAll = productService.getProductAll(pageNum);
		return JSON.toJSONString(productAll.getList());
	}
	
	/**
	 * 采购申请表的添加
	 * @return
	 * @author Killy
	 * @param purchaseRequestadd 表单中的参数
	 * @param products           采购申请明细
	 */
	@RequestMapping("/productRequestAdd")
	public String productRequestAdd(
			PurchaseRequest purchaseRequestadd,
			String products
			) {
		System.out.println(purchaseRequestadd.getEmployeeByRequestEmpId().getEmpLoginName());
		System.out.println(products);
		return "#";
	}
	
	@RequestMapping("/goPurchaseDetail")
	public String goPurchaseDetail() {
		return "purchase/purchaseDetail";
	}
	
	@RequestMapping("/goPurchaseUpdate")
	public String goPurchaseUpdate() {
		return "purchase/purchaseUpdate";
	}
	
}
