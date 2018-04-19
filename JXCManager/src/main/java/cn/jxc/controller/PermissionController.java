package cn.jxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PermissionController {
	
	@RequestMapping("/gopermission")
	public String gopermission(Model model) {
		
		return "permission/Permission";
	}
}
