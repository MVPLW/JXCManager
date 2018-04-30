package cn.jxc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Permission;
import cn.jxc.pojo.Role;
import cn.jxc.service.PermissionService;
import cn.jxc.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	@RequestMapping("/goRole")
	public String goRole(@RequestParam(value = "pageNo", required = false) Integer pageNo, Model model) {
		if (null == pageNo) {
			pageNo = 1;
		}
		PageInfo<Role> roleAll = roleService.getRoleAll(pageNo, 5);
		List<Permission> permissionAll = permissionService.getPermissionAll(1, 10000).getList();
		System.out.println(permissionAll.size());
		model.addAttribute("roleAll", roleAll);
		model.addAttribute("permissionAll", permissionAll);
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
	 * 
	 * @param roleId
	 *            编号
	 * @param roleName
	 *            名称
	 * @param roleCode
	 *            代码
	 * @param description
	 *            描述
	 * @return
	 */
	@RequestMapping("/roleUpdateForm")
	public String goRoleUpdate(Integer roleId, @RequestParam("roleUpdateName") String roleName,
			@RequestParam("roleUpdateCode") String roleCode, @RequestParam("updateDescription") String description) {
		Role role = new Role(roleId, roleName, description, roleCode);
		int updateRole = roleService.updateRole(role);
		if (updateRole > 0) { // 修改成功
			return "redirect:goRole";
		}
		return "error";
	}

	/**
	 * ajax 根据角色编号查询角色信息
	 * 
	 * @param roleId
	 *            角色编号
	 * @return
	 */
	@RequestMapping("/findRoleById")
	@ResponseBody
	public String getRoleById(Integer roleId) {
		Role findRoleById = roleService.findRoleById(roleId);
		return JSON.toJSONString(findRoleById);
	}

	/**
	 * 根据角色ID查询拥有的权限信息
	 * 
	 * @param roleId
	 *            角色编号
	 * @return
	 */
	@RequestMapping("/findPermissionByRoleId")
	@ResponseBody
	public String findPermissionByRoleId(Integer roleId) {
		List<Permission> permissionByRole = permissionService.getPermissionByRole(roleId.toString());
		return JSON.toJSONString(permissionByRole);
	}

	/**
	 * 分配权限 提交修改
	 * 
	 * @param assignRoleId
	 *            要分配的角色
	 * @param assignRole
	 *            要分配的权限
	 * @return
	 */
	@RequestMapping("/goRolePermissionAssign")
	public String goRolePermissionAssign(Integer assignRoleId, Integer[] assignRole) {
		List<Integer> permissions = null;
		if (assignRole != null) {
			permissions = Arrays.asList(assignRole);
		}
		Integer a = permissionService.addRolePermissionAssign(assignRoleId, permissions);
		if (a == 1) { // 权限分配成功
			return "redirect:goRole";
		}
		return "error";
	}

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/deleteRoleById")
	public String deleteRoleById(@RequestParam("roleId") String roleId) {
		System.out.println(roleId);
		int a = roleService.delRoleById(roleId);
		if (a > 0) { // 删除成功
			return "redirect:goRole";
		}
		return "error";
	}

}
