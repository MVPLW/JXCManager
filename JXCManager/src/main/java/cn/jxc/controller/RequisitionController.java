package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
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
import cn.jxc.service.RequisitionDetailService;
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
	@Autowired
	private RequisitionDetailService requisitiondetailservice;
	//进入调拨查询页面
	@RequestMapping("/gorequisition")
	public String gorequisition(Integer pageNo,Model model) {
		if(pageNo==null || pageNo==0) {
			pageNo=1;
		}
		//审核状态
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//调拨订单表查询
		PageInfo<Requisition> reslist = requisitionmapperservice.getRequisition(null,null,pageNo,10);
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
		PageInfo<Requisition> reslist = requisitionmapperservice.getRequisition(requisitionId,rsid,pageNo,10);
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
		PageInfo<Employee> employees = employeeservice.getEmployeeAll(1,10000);
		//仓库信息
		List<StoreHouse> storehouse = storehouseservice.getStoreHouselist();
		//产品信息
		PageInfo<Product> productAll = productService.getProductAll(1); 
		model.addAttribute("employees", employees.getList());
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
	public String gorequisitionupdate(String requisitionId,Model model, Integer productPageNo) {
		if (null == productPageNo) {
			productPageNo = 1;
		}
		//调拨订单表
		Requisition requisition = requisitionmapperservice.requisitionByid(requisitionId);
		//调拨订单详情表
		PageInfo<RequisitionDetail> requisitionDetail = requisitiondetailservice
				.requisitionDetailById(requisitionId, 1, 1000);
		//员工信息
		PageInfo<Employee> employees = employeeservice.getEmployeeAll(1,10000);
		//仓库信息
		List<StoreHouse> storehouse = storehouseservice.getStoreHouselist();
		//产品信息
		PageInfo<Product> productAll = productService.getProductAll(1); 
		model.addAttribute("requisition",requisition);
		model.addAttribute("requisitionDetail",requisitionDetail);
		model.addAttribute("employees",employees.getList());
		model.addAttribute("storehouse",storehouse);
		model.addAttribute("productAll",productAll);
		return "resuisition/requisitionUpdate";
	}
	/**
	 * 使用ajax实现根据id删除一条采购明细
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("delrequisitionDetailById")
	public String delrequisitionByid(int id) {
		int delPurchaseRequestDetail = requisitiondetailservice.delrequisitionByid(id);
		if (delPurchaseRequestDetail > 0) { // 删除成功
			return "1";
		} else
			return "0";
	}	
	
	//修改提交
	@RequestMapping("requisitionUpdate")
	public String requisitionUpdate(Requisition requisition, Model model, String products) {
		try {
			// 修改基本信息
			List<RequisitionDetail> parseArray = JSONObject.parseArray(products, RequisitionDetail.class);
			requisition.setRequisitiondetails(parseArray);// 为产品详情赋值
			int requisitioncount = requisitionmapperservice.RequisitionUpdate(requisition);
			System.out.println(requisition.getRequisitionId());
			if (requisitioncount > 0) {
				return "redirect:gorequisition";
			} else {
				return "error";
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 通过ajax实现 根据单号查询一个采购订单所有信息
	 * 
	 * @param singleNo
	 * @return
	 */
	@RequestMapping("getRequisitionBySingleNo")
	@ResponseBody
	public String getPurchaseRequestBySingleNo(@RequestParam("singleNo") String singleNo,
			@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		if (null == pageNo) {
			pageNo = 1;
		}
		Requisition requisition = requisitionmapperservice.requisitionByid(singleNo);
		PageInfo<RequisitionDetail> pageinfos = requisitiondetailservice.requisitionDetailById(singleNo, pageNo, 3);
		//System.out.println(requisition.getReviewTime());
		pageinfos.getList().get(0).setRequisition(requisition);
		String jsonString = JSON.toJSONString(pageinfos);
		return jsonString;
	}
	/**
	 * 删除调拨订单
	 * 
	 * */
	@RequestMapping("deleteRequisition")
	public String deleteRequisition(String requisitionid) {
		try {
			String[] single = requisitionid.split("-");
			for (int i = 1; i < single.length; i++) {
				requisitionmapperservice.RequisitionDelete(single[i]);
				System.out.println("id是"+single[i]);
			}
			return "redirect:gorequisition";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping("judgmens")
	@ResponseBody
	public String judgmen(String singleNo) {
		Requisition requisitionByid=requisitionmapperservice.getRequisitionById(singleNo);
		int no = requisitionByid.getReviewstatus().getRsId();
		String num = "";
		System.out.println(no+"\t"+requisitionByid.getReviewstatus().getRsName());
		if (no == 1 || no == 3 ) { // 当订单状态处于状态才可以删除
			num = "1";
			return num;
		} else {
			num = "0";
			return num; // 不可以删除
		}
		}
	
}