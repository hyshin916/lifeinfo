package kr.co.mseshop.back.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.mseshop.back.dao.ActionLogDao;
import kr.co.mseshop.model.ActionLogVO;

@Repository("actionLogDao")
public class ActionLogDaoImpl implements ActionLogDao {
	
	@Resource
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public void addActionLog(ActionLogVO actionLogVO) {
		sqlSession.insert("actionLog.addActionLog",actionLogVO);
	}

}
