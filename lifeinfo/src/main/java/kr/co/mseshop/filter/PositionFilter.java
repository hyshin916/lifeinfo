package kr.co.mseshop.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class PositionFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		PrintWriter pw = response.getWriter();
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
		pw.println("<script>");
		pw.println("function getLocation() {\r\n" + 
				"	  if (navigator.geolocation) { // GPS를 지원하면\r\n" + 
				"	    navigator.geolocation.getCurrentPosition(function(position) {\r\n" + 
				"	    <!--alert(position.coords.latitude + ' ' + position.coords.longitude);\r\n-->" + 
				"	    $(\"#valueY\").val(position.coords.latitude);\r\n" + 
				"	    $(\"#valueX\").val(position.coords.longitude);\r\n" +
				"		document.location.href = 'positionInfra?x=' + position.coords.longitude + '&y=' + position.coords.latitude" +  
				"	    //$(\"#my_form\").submit();\r\n" + 
				"	    }, function(error) {\r\n" + 
				"	      console.error(error);\r\n" + 
				"	    }, {\r\n" + 
				"	      enableHighAccuracy: false,\r\n" + 
				"	      maximumAge: 0,\r\n" + 
				"	      timeout: Infinity\r\n" + 
				"	    });\r\n" + 
				"	  } else {\r\n" + 
				"	    alert('GPS를 지원하지 않습니다');\r\n" + 
				"	  }\r\n" + 
				"	}\r\n" + 
				"getLocation();");
		pw.println("</script>");
		pw.println("<form name=\"my_form\" id=\"my_form\" action=\"positionInfra\" method=\"POST\">\r\n" + 
				"					<table class=\"table table-striped\">\r\n" + 
				"						<thead>\r\n" + 
				"						</thead>\r\n" + 
				"						<tbody>\r\n" + 
				"							<input type=\"hidden\" name=\"valueX\" id=\"valueX\" value=\"\">\r\n" + 
				"							<input type=\"hidden\" name=\"valueY\" id=\"valueY\" value=\"\">\r\n" + 
				"						</tbody>\r\n" + 
				"					</table>\r\n" + 
				"					</form>");
		//chain.doFilter(request, response);
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
