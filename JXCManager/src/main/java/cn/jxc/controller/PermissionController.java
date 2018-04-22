package cn.jxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Permission;
import cn.jxc.service.PermissionService;

@Controller
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@RequestMapping("/gopermission")
	public String gopermission(@RequestParam(value = "pageNo", required = false) Integer pageNo, Model model) {
		if (null==pageNo) {
			pageNo=1;
		}
		PageInfo<Permission> permissionByPages = permissionService.getPermissionAll(pageNo, 5);
		model.addAttribute("permissionAll", permissionByPages);
		return "permission/permission";
	}
	
	@RequestMapping("/goaddPermission")
	public String gopermissionadd() {
		return "permission/permissionAdd";
	}
}
