package cn.jxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaveStrockController {
	
	@RequestMapping("/goleaveStock")
	public String goleaveStock() {
		return"levaeStore/leaveStock";
	}
	@RequestMapping("/goleaveStockadd")
	public String goleaveStockadd() {
		return "levaeStore/leaveStockAdd";
	}
	
	@RequestMapping("/goleaveStockupdate")
	public String goleaveStockupdate() {
		return "levaeStore/leaveStockUpdate";
	}
}
