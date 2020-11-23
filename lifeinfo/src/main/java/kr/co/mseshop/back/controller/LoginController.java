package kr.co.mseshop.back.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import kr.co.mseshop.agent.ShinClass;
import kr.co.mseshop.back.service.LoginService;
import kr.co.mseshop.common.Constants;
import kr.co.mseshop.common.Member;
import kr.co.mseshop.model.MemberVO;
import kr.co.mseshop.model.MenuVO;
import kr.co.mseshop.util.CommandToken;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	LoginService loginService;

	/**
	 * @date : 2020. 3. 25.
	 * @author : Mr.shin
	 * @version : 1.0
	 * @description : 로그인 화면로딩
	 * @return
	 */
	@Resource
	ShinClass shinClass;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,HttpServletResponse response) {
		return "loginForm";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loginOut(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value="/validator", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void saveMember(@Valid Member member,BindingResult bindingResult) {
		System.out.println("[Start Validator]");
		System.out.println("##############");
		System.out.println(member.getPassword());
         System.out.println("pass:"+member.getPassword());
         System.out.println("error:"+bindingResult.hasErrors());
         
        if(bindingResult.hasErrors()){
              List<ObjectError> list =  bindingResult.getAllErrors();
              for(ObjectError e : list) {
                   System.out.println(e.getDefaultMessage());
              }
        }
	
    }
	

	/**
	 * @date : 2020. 3. 25.
	 * @author : Mr.shin
	 * @version : 1.0
	 * @description : 프론트 AJAX , POST id,passwd 로그인
	 * @param request
	 * @param response
	 * @param user_id
	 * @param user_passwd
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void getLogin(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "user_id", required = false) String user_id,
			@RequestParam(value = "user_passwd", required = false) String user_passwd) {

		
		Cookie ck = new Cookie("PHPSESSID","30c68b936836b5dbb7a2fa187b0e74ea");
		ck.setPath("/");
		response.addCookie(ck);
		
		System.out.println("ssbranch merge1111");
		logger.error("error...");
		int isLoginChk = loginService.getLogin(user_id, user_passwd);
		JSONObject jObj = new JSONObject();

		if (isLoginChk == 1) {
			System.out.println("[user_id]" + user_id);
			MemberVO memberVO = loginService.getMemberInfo(user_id);
			List<MenuVO> menuVO = loginService.getMenuList(user_id);
			request.getSession().setAttribute(Constants.USER_SESSION_KEY, memberVO.getMem_name());
			request.getSession().setAttribute("groupID", memberVO.getGroup_id());
			request.getSession().setAttribute(Constants.USER_SESSION_MENU, menuVO);
			
			String requestToken = CommandToken.set(request);
			System.out.println("[requestToken]:" + requestToken);

			if (memberVO.getGroup_id().equals("admin")) {
				jObj.put("chkGroup", "admin");
			} else if (memberVO.getGroup_id().equals("ms_002")) {
				jObj.put("chkGroup", "ms_002");
			} else {
				jObj.put("chkGroup", "general");
			}
		}

		jObj.put("chkMember", isLoginChk);
		__responseWrite(response, jObj);
	}

	@RequestMapping(value = "/memRegister", method = RequestMethod.GET)
	public String getMemRegister(HttpServletRequest request, HttpServletResponse response) {
		return "memRegister";
	}

	@RequestMapping(value = "/chkUserID", method = RequestMethod.POST)
	public void chkUserID(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "mem_id", required = false) String mem_id) {

		JSONObject jObj = new JSONObject();

		int chkUserCnt = loginService.chkUserID(mem_id);

		jObj.put("chkID", chkUserCnt);
		__responseWrite(response, jObj);
	}

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public void addMember(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();

		try {
			loginService.addMember(memberVO);
			jObj.put("result", "success");
		} catch (Exception e) {
			jObj.put("result", "fail");
		}

		__responseWrite(response, jObj);
	}

	@RequestMapping(value = "/back/login/etbAuthUser")
	public String etbAuthUser(Model model) {

		List<MemberVO> memberList = loginService.getEtbAuthUser();

		model.addAttribute("memberList", memberList);

		return "etbAuthUser";
	}

	/**
	 * @date : 2020. 4. 3.
	 * @author : 사용자
	 * @version : 1.0
	 * @description : 프로젝트 마일스톤 정보
	 * @return
	 */
	@RequestMapping(value = "/back/prj/milestone")
	public String getMilestone() {
		return "milestone";
	}

	@RequestMapping(value = "/back/login/approveUser")
	public void approveUser(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "mem_id", required = false) String mem_id,
			@RequestParam(value = "mem_status", required = false) String mem_status,
			@RequestParam(value = "group_id", required = false) String group_id) {

		System.out.println("[mem_id]" + mem_id);
		System.out.println("[mem_status]" + mem_status);
		System.out.println("[group_id]" + group_id);

		JSONObject jObj = new JSONObject();

		try {
			loginService.approveUser(mem_id, mem_status, group_id);
			jObj.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			jObj.put("result", "fail");
		}

		__responseWrite(response, jObj);

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
