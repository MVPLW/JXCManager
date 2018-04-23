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
	 * ��¼����
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
		// error="�û���/�������";
		// }else
		// if(IncorrectCredentialsException.class.getName().equals(exceptionClassName))
		// {
		// error="�û���/�������";
		// }else if(exceptionClassName!=null) {
		// error="��������:"+exceptionClassName;
		// }
		// ModelAndView modelAndView=new ModelAndView("login");
		// modelAndView.addObject("error", error);
		// return modelAndView;
		// Subject subject = SecurityUtils.getSubject();
		// UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// Employee login;
		// try {
		// System.out.println("�����¼������");
		// subject.login(token);
		// login = (Employee) subject.getPrincipal();
		// session.setAttribute("loginEmp", login);
		// System.out.println("��¼���");
		// return "index";
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// model.addAttribute("message", "�û��������������");
		// return "login";
		// }
		// �����¼ʧ�ܴ�request�л�ȡ��֤�쳣��Ϣ,shiroLoginFailure����shiro�쳣���ȫ�޶���
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		// ����shiro���ص��쳣��·���жϣ��׳�ָ���쳣��Ϣ
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				// ���ջ��׸��쳣������
				System.out.println("1");
				throw new CustomException("�˺Ų�����");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				System.out.println("2");
				throw new CustomException("�û���/�������");
			} else if ("randomCodeError".equals(exceptionClassName)) {
				System.out.println("3");
				throw new CustomException("��֤�����");
			} else {
				System.out.println("4");
				throw new Exception();// �������쳣����������δ֪����
			}
		}
		// �˷����������¼�ɹ���shiro��֤�ɹ����Զ���ת����һ��·��
		// ��¼ʧ�ܷ��ص�loginҳ��
		System.out.println("�������ĵ�¼ʧ��======");
		return "login";
	}

	/**
	 * �˳���¼
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
	 * ��ȡ����Ա����Ϣ
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
