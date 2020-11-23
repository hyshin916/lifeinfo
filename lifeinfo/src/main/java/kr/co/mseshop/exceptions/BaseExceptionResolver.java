package kr.co.mseshop.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class BaseExceptionResolver implements HandlerExceptionResolver {

	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String view;
	
	public void setView(String view) {
		this.view = view;
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
//		System.out.println("################### Exception Resolver ###################");
//		System.out.println(ex.getMessage());
//		ex.printStackTrace();
		
		logger.error("[ERROR Message]" + ex.getMessage());
		logger.error("[System msg]" + ex);
	
		return new ModelAndView(view,"Exception",ex);
	}

}
