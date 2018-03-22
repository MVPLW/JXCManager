package cn.jxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchaseController {
	
	@RequestMapping("/gopurchase")
	public String gopurchase() {
		return "purchase/purchase";
	}
	
	@RequestMapping("/goPurchaseRequest")
	public String goPurchaseRequest() {
		return "purchase/purchaseRequest";
	}
	
	@RequestMapping("/goPurchaseDetail")
	public String goPurchaseDetail() {
		return "purchase/purchaseDetail";
	}
	
	@RequestMapping("/goPurchaseUpdate")
	public String goPurchaseUpdate() {
		return "purchase/purchaseUpdate";
	}
	
}
