package cn.jxc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomHandleException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception e) {
		CustomException customException = null;
		if (e instanceof CustomException) {
			customException = (CustomException) e;
		} else {
			customException = new CustomException(e.getMessage());
		}
		String message = customException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
