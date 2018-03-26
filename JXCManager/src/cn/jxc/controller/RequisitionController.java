package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.jxc.pojo.Requisition;
import cn.jxc.pojo.ReviewStatus;
import cn.jxc.service.RequisitionService;
import cn.jxc.service.ReviewStatusService;

@Controller
public class RequisitionController {
	
	@Autowired
	private ReviewStatusService rsmapperservice;
	@Autowired
	private RequisitionService resmapperservice;
	//进入调拨查询页面
	@RequestMapping("/gorequisition")
	public String gorequisition(Model model) {
		//审核状态
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//调拨订单表查询
		List<Requisition> reslist = resmapperservice.getRequisition(null,null);
		model.addAttribute("rslist", rslist);
		model.addAttribute("reslist", reslist);
		//翻页查询
		
		return "resuisition/requisition";
	}
	//按条件查询
	@RequestMapping("getbyrsid")
	public String getByrsid(
			@RequestParam(value="requisitionId",required=false) String requisitionId,
			@RequestParam(value="rs_id",required=false) String rs_id,
			Model model) {
		//审核状态
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//调拨订单表查询
		Integer rsid =Integer.parseInt(rs_id); 
		if(rsid==0) {
			rsid=null;
		}
		List<Requisition> reslist = resmapperservice.getRequisition(requisitionId,rsid);
		model.addAttribute("rslist", rslist);
		model.addAttribute("reslist", reslist);
		return "resuisition/requisition";
	}
	
	//跳转至新增
	@RequestMapping("/gorequisitionadd")
	public String gorequisitionadd() {
		return "resuisition/requisitionAdd";
	}
	//跳转至修改
	@RequestMapping("/gorequisitionupdate")
	public String gorequisitionupdate(String requisitionId,Model model) {
		
		Requisition requ = resmapperservice.requisitionByid(requisitionId);
		model.addAttribute("requ", requ);
		return "resuisition/requisitionUpdate";
	}
	
	
	
}
