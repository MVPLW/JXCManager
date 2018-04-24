package cn.jxc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import cn.jxc.exception.CustomException;
import cn.jxc.pojo.Employee;
import cn.jxc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	/**
	 * 登录方法
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public ModelAndView login1(String username, String password, HttpSession session, HttpServletRequest request, Model model)
			throws CustomException, Exception {
		// 如果登录失败从request中获取认证异常信息,shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		System.err.println(exceptionClassName + "==============异常xxxx");
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		String message=null;
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				// 最终会抛给异常处理器
				message="账号不存在";
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				message="用户名/密码错误";
			}  else {
				message="未知错误======"+exceptionClassName;
			}
		}
		// 此方法不处理登录成功，shiro认证成功会自动跳转到上一个路径
		// 登录失败返回到login页面
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("message", message);
		return mav;
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */
	// @RequestMapping("/logout")
	// public String logout(HttpSession session) {
	// session.invalidate();
	// return "login";
	// }

	/**
	 * 获取所有员工信息
	 * 
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping("/goemployeeAll")
	public String goemployee(@RequestParam(value = "pageNum", required = false) Integer pageNum, Model model) {
		if (pageNum == null) {
			pageNum = 1;
		}
		PageInfo<Employee> employeeAll = employeeService.getEmployeeAll(pageNum, 5);
		model.addAttribute("employeeAll", employeeAll);
		return "employee/employee";
	}
}
