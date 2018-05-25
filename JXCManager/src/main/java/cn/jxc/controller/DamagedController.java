package cn.jxc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import cn.jxc.pojo.DamagedRequest;
import cn.jxc.pojo.DamagedRequestDetail;
import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.DamagedRequestDetailService;
import cn.jxc.service.DamagedRequestService;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.StoreHouseService;

@Controller
public class DamagedController {
	
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private StoreHouseService storehouseservice;
	@Autowired
	private ProductService productService;	
	@Autowired
	private DamagedRequestService damservice;
	@Autowired
	private DamagedRequestDetailService drds;
	/*
	 * 报损操作
	 * */
	@RequestMapping("/godamaged")
	public String godamaged(
			@RequestParam(value="damagedRequestId",required=false) String damagedRequestId,
			@RequestParam(value="requestEmp",required=false) String requestEmp,
			Integer pageNo,Model model) {
		if(pageNo==null || pageNo==0) {
			pageNo=1;
		}
		PageInfo<DamagedRequest> damged = damservice.getDamageRequest(damagedRequestId, requestEmp, pageNo, 8);
		System.out.println(damged.getList().get(0).getOrderStatus().toString()+"......................................");
		model.addAttribute("damged", damged);
		model.addAttribute("damagedRequestId", damagedRequestId);
		model.addAttribute("requestEmp", requestEmp);
		return "damaged/Damaged";
	}
	/**
	 * 报损订单新增
	 * 
	 */
	@RequestMapping("damagedrequestadd")
	public String addDamafedRequest(Model model){
		//员工信息
		PageInfo<Employee> employees = employeeservice.getEmployeeAll(1,10000);
		//仓库信息
		List<StoreHouse> storehouse = storehouseservice.getStoreHouselist();
		//产品信息
		PageInfo<Product> productAll = productService.getProductAll(1,5); 
		model.addAttribute("employees", employees.getList());
		model.addAttribute("storehouse", storehouse);
		model.addAttribute("productAll", productAll);
		return "damaged/DamagedRequestadd";
	}
	
	//新增
	@RequestMapping("AddDamageRequest")
	public String AddDamafedRequest(DamagedRequest dr,String products) {
		List<DamagedRequestDetail> requisitionDetail = JSONObject.parseArray(products,DamagedRequestDetail.class);
		dr.setDamagedrequestdetail(requisitionDetail);
		dr.setRequestTime(new Date());
		int result=damservice.AddDamagedRequest(dr);
		System.out.println(result);
		if(result>0) {
			return "/damagedrequestadd";
		}else {
			return "redirect:/godamaged";
		}
		
	}
	
	
}
