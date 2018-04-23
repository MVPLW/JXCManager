package cn.jxc.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import cn.jxc.pojo.Employee;

public class EmployeeFormAuthenticationFilter extends FormAuthenticationFilter {
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("进入登录成功的方法");
		System.out.println(((Employee)subject.getPrincipal()).getEmpLoginName()+"=============");
		return super.onLoginSuccess(token, subject, request, response);
	}
	
}
