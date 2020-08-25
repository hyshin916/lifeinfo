package kr.co.mseshop.back.service;

import java.util.List;

import kr.co.mseshop.model.MemberVO;
import kr.co.mseshop.model.MenuVO;

public interface LoginService {

	public int getLogin(String user_id, String user_passwd);

	public List<MenuVO> getMenuList(String user_id);

	public MemberVO getMemberInfo(String user_id);

	public int chkUserID(String user_id);

	public void addMember(MemberVO memberVO);

	public List<String> getGroupMenuList(String group_id);

	public void addGrpMenu(String group_id, List<String> chkGrpMenu);

	public List<MemberVO> getEtbAuthUser();

	public void approveUser(String mem_id, String mem_status, String group_id);
	
}
