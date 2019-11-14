package kr.co.mseshop.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mseshop.dao.GetmallDao;

@Repository("getmallDao")
public class GetmallDaoImpl implements GetmallDao {
	
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public String getUserchk(String userid) {
		return sqlSession.selectOne("getUserPasswd",userid);
	}
	

}
