package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.Requisition;
import cn.jxc.pojo.RequisitionDetail;
import cn.jxc.pojo.ReviewStatus;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.RequisitionService;
import cn.jxc.service.ReviewStatusService;
import cn.jxc.service.StoreHouseService;

@Controller
public class RequisitionController {
	
	@Autowired
	private ReviewStatusService rsmapperservice;
	@Autowired
	private RequisitionService requisitionmapperservice;
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private StoreHouseService storehouseservice;
	@Autowired
	private ProductService productService;
	//进入调拨查询页面
	@RequestMapping("/gorequisition")
	public String gorequisition(Integer pageNo,Model model) {
		if(pageNo==null || pageNo==0) {
			pageNo=1;
		}
		//审核状态
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//调拨订单表查询
		PageInfo<Requisition> reslist = requisitionmapperservice.getRequisition(null,null,pageNo);
		model.addAttribute("rslist", rslist);
		model.addAttribute("reslist", reslist);
		return "resuisition/requisition";
	}
	
	//按条件查询
	@RequestMapping("getbyrsid")
	public String getByrsid(
			@RequestParam(value="requisitionId",required=false) String requisitionId,
			@RequestParam(value="rs_id",required=false) String rs_id,
			Integer pageNo,
			Model model) {
		if(pageNo==null || pageNo==0) {
			pageNo=1;
		}
		//审核状态
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//调拨订单表查询	
		Integer rsid =Integer.parseInt(rs_id); 
		if(rsid==0) {
			rsid=null;
		}
		PageInfo<Requisition> reslist = requisitionmapperservice.getRequisition(requisitionId,rsid,pageNo);
		model.addAttribute("rslist", rslist);
		model.addAttribute("reslist", reslist);
		return "resuisition/requisition";
	}
	
	//明细查询
	@RequestMapping("/requisitionId")
	public String requisitionId(String requisitionId,Model model) {
		Requisition requisition = requisitionmapperservice.requisitionByid(requisitionId);
		model.addAttribute("requisition",requisition);
		System.out.println("选中的订单号是："+requisition.getRequisitionId());
		return "resuisition/requisition";
	}
	
	//跳转至新增
	@RequestMapping("/gorequisitionadd")
	public String gorequisitionadd(Model model) {
		//员工信息
		List<Employee> employees = employeeservice.getEmployeeAll();
		//仓库信息
		List<StoreHouse> storehouse = storehouseservice.getStoreHouselist();
		//产品信息
		PageInfo<Product> productAll = productService.getProductAll(1); 
		model.addAttribute("employees", employees);
		model.addAttribute("storehouse", storehouse);
		model.addAttribute("productAll", productAll);
		return "resuisition/requisitionAdd";
	}
	
	
	//调拨新增
	@RequestMapping("requisitionAdd")
	public String addRequisition(Requisition requisition,String products) {
		List<RequisitionDetail> requisitionDetail = JSONObject.parseArray(products,RequisitionDetail.class);
		requisition.setRequisitiondetails(requisitionDetail);
		int requisitioncount = requisitionmapperservice.Requisitionadd(requisition);
		if(requisitioncount==1) {
			return "gorequisitionadd";
		}else {
			return "redirect:gorequisition";
		}
	}
	
	
	//跳转至修改
	@RequestMapping("gorequisitionupdate")
	public String gorequisitionupdate(String requisitionId,Model model) {
		Requisition requ = requisitionmapperservice.requisitionByid(requisitionId);
		System.out.println("调拨单的ID是："+requisitionId);
		model.addAttribute("requ", requ);
		return "resuisition/requisitionUpdate";
	}
}