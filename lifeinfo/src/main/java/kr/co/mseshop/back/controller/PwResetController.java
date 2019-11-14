package kr.co.mseshop.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PwResetController {

	@RequestMapping(value="/passwd/reset")
	public String oilInfoList(Model model,@RequestParam(value="id",required=false) String id) {
		  return "passwd/reset";
	}
	
	@RequestMapping(value="/allNew")
	public String allNew() {
		  return "allNew";
	}
}
