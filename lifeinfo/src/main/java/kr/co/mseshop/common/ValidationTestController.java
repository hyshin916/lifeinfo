package kr.co.mseshop.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class ValidationTestController {
	
	@RequestMapping(value="/validator", method = RequestMethod.GET)
    public void saveMember(@Valid Member member,HttpServletResponse response) {
		System.out.println("[Start Validator]");
		JSONObject jObj = new JSONObject();
		jObj.put("val", 1);
		__responseWrite(response,jObj);
    }
    
	private void __responseWrite(HttpServletResponse response, JSONObject jObj) {
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.println(jObj);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}