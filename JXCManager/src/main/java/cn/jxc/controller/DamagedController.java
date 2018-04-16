package cn.jxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DamagedController {
	
	@RequestMapping("/godamaged")
	public String godamaged() {
		return "damaged";
	}
	
}
