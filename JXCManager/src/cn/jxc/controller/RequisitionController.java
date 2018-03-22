package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jxc.pojo.ReviewStatus;
import cn.jxc.service.ReviewStatusService;

@Controller
public class RequisitionController {
	
	
	
	@Autowired
	private ReviewStatusService rsmapperservice;
	
	//进入查询
	@RequestMapping("/gorequisition")
	public String gorequisition(Model model) {
		//审核状态
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		model.addAttribute("rslist", rslist);
		System.out.println(rslist.size());
		//翻页查询
		
		return "resuisition/requisition";
	}
	//跳转至新增
	@RequestMapping("/gorequisitionadd")
	public String gorequisitionadd() {
		return "resuisition/requisitionAdd";
	}
	//跳转至修改
	@RequestMapping("/gorequisitionupdate")
	public String gorequisitionupdate() {
		return "resuisition/requisitionUpdate";
	}
	
	
	
}
