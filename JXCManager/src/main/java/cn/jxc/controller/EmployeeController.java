package cn.jxc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * ��¼����
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login1(String username, String password, HttpSession session) {
		Employee login = employeeService.login(username, password);
		if (null != login) {
			session.setAttribute("loginEmp", login);// ��ǰ��¼���û�����session��
			return "index";
		} else {
			return "login";
		}
	}

	/**
	 * �˳���¼
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	/**
	 * ��ȡ����Ա����Ϣ
	 * 
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping("/goemployeeAll")
	public String goemployee(@RequestParam(value = "pageNum", required = false) Integer pageNum, Model model) {
		if (pageNum==null) {
			pageNum=1;
		}
		PageInfo<Employee> employeeAll = employeeService.getEmployeeAll(pageNum, 5);
		model.addAttribute("employeeAll", employeeAll);
		return "employee/employee";
	}
}
