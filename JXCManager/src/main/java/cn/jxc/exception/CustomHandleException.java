package cn.jxc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * �Զ����쳣����
 * @author LXQ 2018/4/24
 *
 */
public class CustomHandleException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception e) {
		// �������쳣����
		CustomException customException = null;
		// �����쳣������ϵͳ�Զ�����쳣��ֱ��ȡ���쳣��Ϣ�ڴ���ҳ��չʾ���ɡ�
		if (e instanceof CustomException) {
			customException = (CustomException) e;
		} else {
			customException = new CustomException(e.getMessage());
		}
		System.out.println("�����Զ��崦���쳣===========================");
		// ������Ϣ
		String message = customException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		// ��������Ϣ����ҳ��
		modelAndView.addObject("message", message);
		// ָ�����ҳ��
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
