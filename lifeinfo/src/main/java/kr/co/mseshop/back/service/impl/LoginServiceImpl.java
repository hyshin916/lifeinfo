package kr.co.mseshop.back.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.mseshop.back.dao.LoginDao;
import kr.co.mseshop.back.service.LoginService;
import kr.co.mseshop.model.MemberVO;
import kr.co.mseshop.model.MenuVO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	
	@Resource
	LoginDao loginDao;
	
	@Override
	public int getLogin(String user_id, String user_passwd) {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id);
		map.put("user_passwd", user_passwd);
		return loginDao.getLogin(map);
	}

	@Override
	public List<MenuVO> getMenuList(String user_id) {
		return loginDao.getMenuList(user_id);
	}

	@Override
	public MemberVO getMemberInfo(String user_id) {
		return loginDao.getMemberInfo(user_id);
	}

	@Override
	public int chkUserID(String user_id) {
		return loginDao.chkUserID(user_id);
	}

	@Override
	public void addMember(MemberVO memberVO) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		memberVO.setMem_regDate(sdf.format(date));
		loginDao.addMember(memberVO);
	}

	@Override
	public List<String> getGroupMenuList(String group_id) {
		return loginDao.getGroupMenuList(group_id);
	}

	@Override
	public void addGrpMenu(String group_id, List<String> chkGrpMenu) {
		HashMap<String,String> map = new HashMap<String,String>();
		loginDao.delGrpMenu(group_id);
		for (String menus : chkGrpMenu) {
			map.put("group_id",group_id);
			map.put("menu_id",menus);
			loginDao.addGrpMenu(map);
		}
	}

	@Override
	public List<MemberVO> getEtbAuthUser() {
		return loginDao.getEtbAuthUser();
	}

	@Override
	public void approveUser(String mem_id, String mem_status,String group_id) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("mem_id",mem_id);
		map.put("group_id", group_id);
		String status = "";
		if (mem_status.equals("true")) {
			status = "Y";
		} else if (mem_status.equals("false")) {
			status = "N";
		}
		map.put("mem_status", status);
		loginDao.approveUser(map);
	}

	@Override
	public List<String> getHyposTest() {
		return loginDao.getHyposTest();
	}


}
