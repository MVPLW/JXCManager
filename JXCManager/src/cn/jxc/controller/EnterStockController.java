package cn.jxc.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.EnterStock;
import cn.jxc.pojo.EnterStockType;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.EnterStockService;
import cn.jxc.service.EnterStockTypeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.StoreHouseService;

/**
 * Èë¿â
 * 
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
	@Autowired
	private EnterStockService enterStockService;

	@RequestMapping("/goenterstock")
	public String goenterstock(@RequestParam(value = "singleNo", required = false) String singleNo,
			@RequestParam(value = "shName", required = false) String shName,
			@RequestParam(value = "start", required = false) String start,
			@RequestParam(value = "end", required = false) String end,
			@RequestParam(value = "pageNo", required = false) Integer pageNo, Model model) throws ParseException {
		if (null == pageNo) {
			pageNo = 1;
		}
		PageInfo<EnterStock> enterStockBySuless = enterStockService.getEnterStockBySuless(singleNo, shName,
				start,end, pageNo,
				1);
		model.addAttribute("ess", enterStockBySuless);
		model.addAttribute("singleNo", singleNo);
		model.addAttribute("shName", shName);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
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
