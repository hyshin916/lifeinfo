package kr.co.mseshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import kr.co.mseshop.common.Constants;

public class ChkLoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		if (request.getSession().getAttribute(Constants.USER_SESSION_MENU) == null) {
			response.sendRedirect("/lifeinfo/login");
			return false;
		}

		request.setAttribute("memName", request.getSession().getAttribute(Constants.USER_SESSION_KEY));
		request.setAttribute("menuList", request.getSession().getAttribute(Constants.USER_SESSION_MENU));

		return true;
	}

}
