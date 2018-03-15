package cn.jxc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jxc.service.EmployeeService;

@Controller
public class LoginController {
	
	@Resource
	private EmployeeService employeeService;
	
	/**
	 * µÇÂ¼·½·¨
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		
		return "index";
	}
	
}
