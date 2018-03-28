package cn.jxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SalesController {
	
	
	@RequestMapping("/gosales")
	public String gosales() {
		return "sales/sales";
	}
	
	@RequestMapping("/gosalesadd")
	public String gosalesadd() {
		return "sales/salesAdd";
	}
	
	@RequestMapping("/gosalesupdate")
	public String gosalesupdate() {
		return "sales/salesUpdate";
	}
}
