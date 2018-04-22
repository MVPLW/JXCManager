package cn.jxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
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
		return "role/role";
	}

	@RequestMapping("/goRoleAdd")
	public String goRoleAdd(Role role) {
		int s = roleService.addRole(role);
		if (s > 0) {
			return "redirect:goRole";
		}
		return "error"; // 添加失败 跳转到错误页面
	}

	/**
	 * 提交修改
	 * @param roleId  编号
	 * @param roleName 名称
	 * @param roleCode  代码
	 * @param description 描述
	 * @return
	 */
	@RequestMapping("/roleUpdateForm")
	public String goRoleUpdate(Integer roleId, 
			@RequestParam("roleUpdateName")String roleName, 
			@RequestParam("roleUpdateCode")String roleCode, 
			@RequestParam("updateDescription")String description) {
		Role role=new Role(roleId, roleName, description, roleCode);
		int updateRole = roleService.updateRole(role);
		if (updateRole>0) {   //修改成功
			return "redirect:goRole";
		}
		return "error";
	}
	
	/**
	 * ajax
	 * 根据角色编号查询角色信息 
	 * @param roleId  角色编号
	 * @return
	 */
	@RequestMapping("/findRoleById")
	@ResponseBody
	public String getRoleById(Integer roleId) {
		Role findRoleById = roleService.findRoleById(roleId);
		return JSON.toJSONString(findRoleById);
	}

}
