package kr.co.mseshop.getmall.api;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mseshop.common.Constants;
import kr.co.mseshop.common.PathClass;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.service.GetmallService;
import kr.co.mseshop.service.LifeInfoService;
import kr.co.mseshop.util.Base64Util;

@Controller
public class GetmallAPI {

	@Inject
	GetmallService getmallService;
	
	@Inject
	LifeInfoService lifeInfoService;
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getmall/users", method = RequestMethod.GET)
	public void passwdChk(HttpServletRequest req, HttpServletResponse resp, @RequestParam String msmart77,
			@RequestParam String msmart19) {

		try {
			String userid = Base64Util.getInstance().deCoder(msmart77);
			String password = Base64Util.getInstance().deCoder(msmart19);
/*			String userid = id;
			String password = passwd;*/
			System.out.println("userid : " + userid);
			System.out.println("password : " + password);
			int resultChk = getmallService.getUserchk(userid, password);

			JSONObject jobj = new JSONObject();
			PrintWriter out = resp.getWriter();
			jobj.put("result", Integer.toString(resultChk));
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			out.println(jobj.toJSONString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
