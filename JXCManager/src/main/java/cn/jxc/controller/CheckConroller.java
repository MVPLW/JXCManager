package cn.jxc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Checks;
import cn.jxc.pojo.Employee;
import cn.jxc.pojo.EnterStockType;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.ReviewStatus;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.BackSalesDetailService;
import cn.jxc.service.BackSalesService;
import cn.jxc.service.ChecksService;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.EnterStockDetailService;
import cn.jxc.service.EnterStockService;
import cn.jxc.service.EnterStockTypeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.PurchaseRequestDetailService;
import cn.jxc.service.PurchaseRequestService;
import cn.jxc.service.RequisitionDetailService;
import cn.jxc.service.RequisitionService;
import cn.jxc.service.ReviewStatusService;
import cn.jxc.service.StoreHouseService;

@Controller
public class CheckConroller {
	@Autowired
	private ReviewStatusService rsmapperservice;
	@Autowired
	private ChecksService  checkService;
	@Autowired
	private EnterStockTypeService enterStockType;
	@Autowired
	private EnterStockService enterStockService;
	@Autowired
	private EnterStockDetailService enterStockDetailService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private StoreHouseService storeHouseService;
	@Autowired
	private ProductService productService;
	@Autowired
	private BackSalesService backSalesService;
	@Autowired
	private RequisitionService requisitionService;
	@Autowired
	private PurchaseRequestService purchaseRequestService;
	@Autowired
	private PurchaseRequestDetailService purchaseRequestDetailService;
	@Autowired
	private BackSalesDetailService backSalesDetailService;
	@Autowired
	private RequisitionDetailService requisitionDetailService;
	private static int pageSize=5;
	@RequestMapping("/goCheck")
	public String gopermission(
			@RequestParam(value = "singleNo", required = false) String singleNo,
			@RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "start", required = false) String start,
			@RequestParam(value = "end", required = false) String end,
			Model model) {
		System.out.println(pageNo);
		if (pageNo==null) {
			pageNo=1;
		}
		System.out.println(pageNo+",,,,,controller pageno");
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//调拨订单表查询
		PageInfo<Checks> checklist=checkService.getALLChecks(null,null,null,null,pageNo,pageSize);
		System.out.println("有数据"+checklist.getList().size());
		System.out.println(checklist.getList().get(0).getOrderStatus().getOrderType()+"ssssssssssssssssssssssssssssss");
		model.addAttribute("cs",checklist);
		model.addAttribute("rslist", rslist);
		return "check/CheckList";
	}
	
	
	/**
	 * 跳转到入库添加的页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/goCheckAdd")
	public String goegoCheckAdd(Model model) {
		List<EnterStockType> enterStockTypeAll = enterStockType.getEnterStockTypeAll();
		PageInfo<Employee> employeeAll = employeeService.getEmployeeAll(1, 10000);
		List<StoreHouse> storeHouselist = storeHouseService.getStoreHouselist();
		PageInfo<Product> productAll = productService.getProductAll(1,5);
		model.addAttribute("estAll", enterStockTypeAll);
		model.addAttribute("employeeAll", employeeAll.getList());
		model.addAttribute("storeHouseAll", storeHouselist);
		model.addAttribute("productAll", productAll);
		return "enterStork/enterStockAdd";
	}
}
