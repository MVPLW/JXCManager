package cn.jxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Role;
import cn.jxc.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("/goRole")
	public String goRole(@RequestParam(value = "pageNo", required = false) Integer pageNo, Model model) {
		if (null == pageNo) {
			pageNo = 1;
		}
		PageInfo<Role> roleAll = roleService.getRoleAll(pageNo, 5);
		model.addAttribute("roleAll", roleAll);
		return "role/Role";
	}

}
