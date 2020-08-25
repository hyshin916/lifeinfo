package kr.co.mseshop.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PwResetController {

	@RequestMapping(value="/back/passwd/reset")
	public String oilInfoList(Model model,@RequestParam(value="id",required=false) String id) {
		  return "passwdReset";
	}
	
	@RequestMapping(value="/passwd/reset")
	public String oilInfoListStore(Model model,@RequestParam(value="id",required=false) String id) {
		  return "passwdResetStore";
	}
	
	@RequestMapping(value="/allNew")
	public String allNew() {
		  return "allNew";
	}
	
	@RequestMapping(value="/mstoday")
	public String mstoday() {
		  return "mstoday";
	}
	
	@RequestMapping(value="/msappnew")
	public String msappnew() {
		  return "msappnew";
	}
}
