package cn.jxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequisitionController {
	
	@RequestMapping("/gorequisition")
	public String gorequisition() {
		return "requisition";
	}
	
	@RequestMapping("/gorequisitionadd")
	public String gorequisitionadd() {
		return "requisitionAdd";
	}
	
	@RequestMapping("/gorequisitionupdate")
	public String gorequisitionupdate() {
		return "requisitionUpdate";
	}
	
}
