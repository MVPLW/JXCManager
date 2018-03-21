package cn.jxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

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
	
	@RequestMapping("/gosalesorderlist")
	public String gosalesorderlist() {
		return "sales/salesOrderList";
	}
	
	@RequestMapping("/gosalesupdate")
	public String gosalesupdate() {
		return "sales/salesUpdate";
	}
}
