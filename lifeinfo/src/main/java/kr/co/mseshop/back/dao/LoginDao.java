package kr.co.mseshop.back.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.mseshop.model.MemberVO;
import kr.co.mseshop.model.MenuVO;

public interface LoginDao {

	public int getLogin(HashMap<String, String> map);

	public List<MenuVO> getMenuList(String user_id);

	public MemberVO getMemberInfo(String user_id);

	public int chkUserID(String user_id);

	public void addMember(MemberVO memberVO);

	public List<String> getGroupMenuList(String group_id);

	public void addGrpMenu(HashMap<String, String> map);

	public void delGrpMenu(String group_id);

	public List<MemberVO> getEtbAuthUser();

	public void approveUser(HashMap<String, String> map);

	public List<String> getHyposTest();

}
