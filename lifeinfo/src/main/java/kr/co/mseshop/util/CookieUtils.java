package kr.co.mseshop.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieUtils {

	static CookieUtils cookieUtils;
	public static CookieUtils getInstance() {
		cookieUtils = new CookieUtils();
		return cookieUtils;
	}
	
	public int chkCookies(HttpServletRequest request,HttpServletResponse response,String articleID) {
		 int result = 0;
		 Cookie[] cookies = (Cookie[]) request.getCookies();
		 Cookie viewCookie = null;
		
		  if (cookies != null && cookies.length > 0)  {
			  for (int i = 0; i < cookies.length; i++) {
				  if (cookies[i].getName().equals("cookie"+articleID))
	                { 
	                    System.out.println("처음 쿠키가 생성한 뒤 들어옴.");
	                    viewCookie = cookies[i];
	                }
			  }
		  }
		  if (viewCookie == null) {  
			   result = 0;
			   Cookie newCookie = new Cookie("cookie"+articleID, "|" + articleID + "|");
               response.addCookie(newCookie);
		  } else {
			  result = 1;
		  }
		  return result;
	}
}
