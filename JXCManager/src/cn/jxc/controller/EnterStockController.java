package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.EnterStockType;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.EnterStockTypeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.StoreHouseService;

/**
 * Èë¿â
 * @author ÀîÏþÇæ
 *
 */
@Controller
public class EnterStockController {
	
	@Autowired
	private EnterStockTypeService enterStockType;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private StoreHouseService storeHouseService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/goenterstock")
	public String goenterstock() {
		return "enterStork/enterStock";
	}
	
	@RequestMapping("/goenterstockadd")
	public String goenterstockadd(Model model) {
		List<EnterStockType> enterStockTypeAll = enterStockType.getEnterStockTypeAll();
		List<Employee> employeeAll = employeeService.getEmployeeAll();
		List<StoreHouse> storeHouselist = storeHouseService.getStoreHouselist();
		PageInfo<Product> productAll = productService.getProductAll(1);
		model.addAttribute("estAll", enterStockTypeAll);
		model.addAttribute("employeeAll", employeeAll);
		model.addAttribute("storeHouseAll", storeHouselist);
		model.addAttribute("productAll", productAll);
		return "enterStork/enterStockAdd";
	}
	
}
