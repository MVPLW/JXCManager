package cn.jxc.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Permission;
import cn.jxc.service.PermissionService;

public class EmployeeFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private PermissionService permissionService;

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		System.err.println("进入登录成功的方法");
		Employee employee = (Employee) subject.getPrincipal();
		System.err.println(employee.getEmpLoginName() + "=============" + employee.getEmpLoginPwd());
		// session中添加登录的信息
		((HttpServletRequest) request).getSession().setAttribute("loginEmp", employee);
		// issueSuccessRedirect(request, response);
		//
		// WebUtils.getAndClearSavedRequest(request); //清理原先的地址
		// WebUtils.redirectToSavedRequest(request, response, "/index"); //跳到指定的页面
		List<Permission> list = permissionService.findPermissionByEmp(employee.getEmpLoginName());
		List<Permission> navi = new ArrayList<Permission>();
		for (Permission permission : list) {
			if (permission.getIsNavi() == 1) {
				navi.add(permission); // 如果是一级加入集合
			}
		}
		((HttpServletRequest) request).getSession().setAttribute("navibar", navi);
		return super.onLoginSuccess(token, subject, request, response);
	}

}
