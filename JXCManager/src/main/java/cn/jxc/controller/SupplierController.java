package cn.jxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupplierController {

	@RequestMapping("supplier")
	public String supplierlist() {
		return "supplier/supplierlist";
	}
	
}
