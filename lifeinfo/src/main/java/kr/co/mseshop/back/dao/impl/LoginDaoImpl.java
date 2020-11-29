package kr.co.mseshop.back.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.mseshop.back.dao.LoginDao;
import kr.co.mseshop.model.MemberVO;
import kr.co.mseshop.model.MenuVO;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Resource
	private SqlSession sqlSession;
	
	@Resource
	private SqlSession sqlSession2;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int getLogin(HashMap<String, String> map) {
		return sqlSession.selectOne("newsBack.getLogin",map);
	}
	@Override
	public List<MenuVO> getMenuList(String user_id) {
		System.out.println("[Dao] userid : " +user_id); 
		return sqlSession.selectList("newsBack.getMenuList",user_id);
	}
	@Override
	public MemberVO getMemberInfo(String user_id) {
		return sqlSession.selectOne("newsBack.getMemberInfo",user_id);
	}
	@Override
	public int chkUserID(String user_id) {
		return sqlSession.selectOne("newsBack.chkUserID",user_id);
	}
	@Override
	public void addMember(MemberVO memberVO) {
		sqlSession.insert("newsBack.addMember",memberVO);
	}
	@Override
	public List<String> getGroupMenuList(String group_id) {
		return sqlSession.selectList("newsBack.getGroupMenuList",group_id);
	}
	@Override
	public void addGrpMenu(HashMap<String, String> map) {
		sqlSession.insert("newsBack.addGrpMenu",map);
	}
	@Override
	public void delGrpMenu(String group_id) {
		sqlSession.delete("newsBack.delGrpMenu",group_id);
	}
	@Override
	public List<MemberVO> getEtbAuthUser() {
		return sqlSession.selectList("newsBack.getEtbAuthUser");
	}
	@Override
	public void approveUser(HashMap<String, String> map) {
		sqlSession.update("newsBack.approveUser",map);
	}
	@Override
	public List<String> getHyposTest() {
		return sqlSession2.selectList("newsBack.getHyposTest");
	}
	

	
}
