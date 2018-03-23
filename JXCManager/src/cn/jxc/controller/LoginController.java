package cn.jxc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cn.jxc.pojo.Employee;
import cn.jxc.service.EmployeeService;

@Controller
public class LoginController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * ��¼����
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		Employee login = employeeService.login(username, password);
		if (null != login) {
			session.setAttribute("loginEmp", login);// ��ǰ��¼���û�����session��
			return "index";
		} else {
			return "login";
		}
		
	}

}
