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
	public String login1(String username, String password, HttpSession session, HttpServletRequest request, Model model)
			throws CustomException, Exception {
		// String error=null;
		// String exceptionClassName=(String) req.getAttribute("shiroLoginFailure");
		// if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
		// error="用户名/密码错误";
		// }else
		// if(IncorrectCredentialsException.class.getName().equals(exceptionClassName))
		// {
		// error="用户名/密码错误";
		// }else if(exceptionClassName!=null) {
		// error="其它错误:"+exceptionClassName;
		// }
		// ModelAndView modelAndView=new ModelAndView("login");
		// modelAndView.addObject("error", error);
		// return modelAndView;
		// Subject subject = SecurityUtils.getSubject();
		// UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// Employee login;
		// try {
		// System.out.println("进入登录控制器");
		// subject.login(token);
		// login = (Employee) subject.getPrincipal();
		// session.setAttribute("loginEmp", login);
		// System.out.println("登录完成");
		// return "index";
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// model.addAttribute("message", "用户名或者密码错误");
		// return "login";
		// }
		// 如果登录失败从request中获取认证异常信息,shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				// 最终会抛给异常处理器
				System.out.println("1");
				throw new CustomException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				System.out.println("2");
				throw new CustomException("用户名/密码错误");
			} else if ("randomCodeError".equals(exceptionClassName)) {
				System.out.println("3");
				throw new CustomException("验证码错误");
			} else {
				System.out.println("4");
				throw new Exception();// 最终在异常处理器生成未知错误
			}
		}
		// 此方法不处理登录成功，shiro认证成功会自动跳转到上一个路径
		// 登录失败返回到login页面
		System.out.println("控制器的登录失败======");
		return "login";
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "login";
//	}

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
