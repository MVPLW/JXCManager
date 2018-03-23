
package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Product;
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
		PageInfo<Product> productAll = productService.getProductAll(1);  //分页查询
		Integer productPageNum = productAll.getPages();                  //获取页码总数
		
		model.addAttribute("employees", employees);
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("products", productAll.getList());
		model.addAttribute("productPageNum", productPageNum);
		return "purchase/purchaseRequestAdd";
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
