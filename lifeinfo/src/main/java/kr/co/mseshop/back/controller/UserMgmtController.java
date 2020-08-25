package kr.co.mseshop.back.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mseshop.back.service.LoginService;

@Controller
public class UserMgmtController {

	
	@Resource
	LoginService loginService;
	
	@RequestMapping(value = "/back/userMgmt/groupAuthMap", method = RequestMethod.GET)
	public String groupAuthMap() {
		
		return "groupAuthMap";
	}
	

	@RequestMapping(value = "/back/userMgmt/groupMenu", method = RequestMethod.GET)
	public void groupMenu(HttpServletRequest request,HttpServletResponse response,@RequestParam String group_id) {
		System.out.println("[group_id]" + group_id);
		
		JSONObject obj = new JSONObject();
		
		List<String> arrList = loginService.getGroupMenuList(group_id);
		
		obj.put("list", arrList);
		
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.println(obj);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value = "/back/userMgmt/addGrpMenu", method = RequestMethod.POST)
	public void addGrpMenu(HttpServletRequest request,HttpServletResponse response,@RequestParam String group_id,@RequestParam(value="chkGrpMenu[]") List<String> chkGrpMenu) {
		
		System.out.println("[group_id]" + group_id);

		for (String var : chkGrpMenu) {
			System.out.println("[var]"  + var);
		}
		
		loginService.addGrpMenu(group_id,chkGrpMenu);
		
		
		JSONObject obj = new JSONObject();
		obj.put("result", "success");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.println(obj);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
