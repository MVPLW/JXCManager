package cn.jxc.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.EnterStock;
import cn.jxc.pojo.EnterStockType;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.BackSalesDetailService;
import cn.jxc.service.BackSalesService;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.EnterStockService;
import cn.jxc.service.EnterStockTypeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.PurchaseRequestDetailService;
import cn.jxc.service.PurchaseRequestService;
import cn.jxc.service.RequisitionService;
import cn.jxc.service.StoreHouseService;

/**
 * 入库
 * 
 * @author 李晓擎
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
	/**
	 * 跳转到入库单页面  
	 * @param singleNo
	 * @param shName
	 * @param start
	 * @param end
	 * @param pageNo
	 * @param model
	 * @return
	 * @throws ParseException
	 */
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
	/**
	 * 跳转到入库添加的页面
	 * @param model
	 * @return
	 */
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
	
	/**
	 * 通过ajax实现级联上游单号
	 * @param type 入库类型
	 * @return
	 */
	@RequestMapping("/getUpstreamNo")
	@ResponseBody
	public String getUpstreamNo(String type) {
		if("1".equals(type)) {
			return JSON.toJSONString(purchaseRequestService.getPurchaseRequestByBlurry(1, 10000, null, null, null).getList());
		}else if("2".equals(type)) {
			return JSON.toJSONString(backSalesService.getBackSalesAll());
		}else if("3".equals(type)) {
			return JSON.toJSONString(requisitionService.getRequisition(null, null, 1,1).getList());
		}else {
			return JSON.toJSONString(backSalesService.getBackSalesAll());
		}
	}
	
	/**
	 * 根据选中的订单号  获取订单详情
	 * @param singleNo
	 * @param type
	 * @return
	 */
	@RequestMapping("/getSingleNoDetail")
	@ResponseBody
	public String getSingleNoDetail(String singleNo,String type) {
		if("1".equals(type)) {             //采购
			return JSON.toJSONString(purchaseRequestDetailService.getPurchaseRequestDetail(singleNo, 1, 10000).getList());
		}else if("2".equals(type)) {    //退货入库
			return JSON.toJSONString(backSalesDetailService.getBackSalesDetailBySingleNo(singleNo));
		}else if("3".equals(type)) {     //调拨入库
			
		}
		return "";
	}

}
