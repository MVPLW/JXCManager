package cn.jxc.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import cn.jxc.exception.CustomException;
import cn.jxc.pojo.Dept;
import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Role;
import cn.jxc.service.DeptService;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.RoleService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService roleService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/gowelcome")
	public String gowelcome() {
		return "redirect:welcome.jsp";
	}

	/**
	 * 只处理登录错误的情况
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public ModelAndView login1(String username, String password, HttpSession session, HttpServletRequest request,
			Model model) throws CustomException, Exception {
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		String message = null;
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				message = "没有此账户";
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				message = "账户用户名错误";
			} else {
				message = "其他错误======" + exceptionClassName;
			}
		}
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("message", message);
		return mav;
	}

	/**
	 * 
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequiresPermissions("employee:list")
	@RequestMapping("/goEmployee")
	public String goemployee(@RequestParam(value = "pageNo", required = false) Integer pageNum, Model model) {
		if (pageNum == null) {
			pageNum = 1;
		}
		PageInfo<Employee> employeeAll = employeeService.getEmployeeAll(pageNum, 5);
		List<Role> roles = roleService.getRoleAll(1, 10000).getList();
		model.addAttribute("employeeAll", employeeAll);
		model.addAttribute("roleAll", roles);
		return "employee/employee";
	}

	@RequiresPermissions("employee:add")
	@RequestMapping("/goEmployeeAdd")
	public String goemployeeadd(Model model) {
		List<Dept> deptAll = deptService.getDeptAll();
		model.addAttribute("deptAll", deptAll);
		return "employee/employeeAdd";
	}

	@RequestMapping("/goEmployeeInsert")
	public String goEmployeeInsert(Employee employee) throws Exception {
		try {
			employeeService.addEmployee(employee);
			return "redirect:goEmployee";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("qnmlgb" + e.getMessage());
			// return "";
		}
	}

	@RequestMapping("/findRolesByEmp")
	@ResponseBody
	public String findRolesByEmp(@RequestParam("emploginname") String empLoginName) {
		System.out.println(empLoginName);
		List<Role> findRoleByEmp = roleService.findRoleByEmp(empLoginName);
		return JSON.toJSONString(findRoleByEmp);
	}

	@RequestMapping("/goEmpRoleAssign")
	public String goEmpRoleAssign(String[] assignRole, String empLoginName) {
		List<String> list = Arrays.asList(assignRole);
		int addEmpRole = roleService.addEmpRole(list, empLoginName);
		if (addEmpRole > 0) {
			return "redirect:goEmployee";
		}
		return "error";
	}

}
