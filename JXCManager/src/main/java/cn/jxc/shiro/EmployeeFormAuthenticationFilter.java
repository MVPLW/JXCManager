package cn.jxc.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import cn.jxc.pojo.Employee;

public class EmployeeFormAuthenticationFilter extends FormAuthenticationFilter {
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		System.err.println("进入登录成功的方法");
		Employee employee=(Employee)subject.getPrincipal();
		System.err.println(employee.getEmpLoginName()+"============="+employee.getEmpLoginPwd());
//		session中添加登录的信息
		((HttpServletRequest)request).getSession().setAttribute("loginEmp", employee);
//		issueSuccessRedirect(request, response);
//		
//		WebUtils.getAndClearSavedRequest(request);  //清理原先的地址
//		WebUtils.redirectToSavedRequest(request, response, "/index");  //跳到指定的页面
		
		return super.onLoginSuccess(token, subject, request, response);
	}
	
	
	
}
