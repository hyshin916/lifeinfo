package kr.co.mseshop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import kr.co.mseshop.back.service.LogService;
import kr.co.mseshop.common.Constants;
import kr.co.mseshop.model.ActionLogVO;

@Component
public class ActionLogUtil {

	@Resource
	LogService logService;
	
	public void actionLogUtil(HttpServletRequest request,String flag) {
		System.out.println("#############################################################");	
		System.out.println("[ServletPath] :" + request.getServletPath());
		System.out.println("[SessionID] :" + request.getSession().getAttribute(Constants.USER_SESSION_KEY));
		System.out.println("[Activity] :" + flag);
		System.out.println("[Date] :" + getDate());
		System.out.println("#############################################################");
		
		ActionLogVO actionLogVO = new ActionLogVO();
		actionLogVO.setServletPath(request.getServletPath());
		actionLogVO.setSessionID((String) request.getSession().getAttribute(Constants.USER_SESSION_KEY));
		actionLogVO.setActivity(flag);
		actionLogVO.setDate(getDate());
		actionLogVO.setIp(getClientIp(request));
		try {
			logService.actionLog(actionLogVO);
		} catch (Exception e) {
			System.out.println("[Log] save fail ...");
			e.printStackTrace();
		}
	}
	
	public static String getClientIp(HttpServletRequest req) {
	    String ip = req.getHeader("X-Forwarded-For");
	    if (ip == null) ip = req.getRemoteAddr();
	    return ip;
	}
	
	public String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
