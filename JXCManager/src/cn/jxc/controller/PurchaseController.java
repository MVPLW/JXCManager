package cn.jxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchaseController {
	
	@RequestMapping("/gopurchase")
	public String gopurchase() {
		return "purchase";
	}
	
}
