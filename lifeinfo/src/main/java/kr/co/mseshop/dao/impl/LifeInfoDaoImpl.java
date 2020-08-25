package kr.co.mseshop.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mseshop.dao.LifeInfoDao;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.PasswdResetVO;
import kr.co.mseshop.model.SearchVO;

@Repository("lifeInfoDao")
public class LifeInfoDaoImpl implements LifeInfoDao{

	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<ArticleVO> getNewsList() {
		return sqlSession.selectList("getNewsList");
	}

	@Override
	public List<ArticleVO> getImpNewsList() {
		return sqlSession.selectList("getImpNewsList");
	}

	@Override
	public List<ArticleVO> getNewsAllList(String date) {
		return sqlSession.selectList("getNewsAllList",date);
	}

	@Override
	public ArticleVO getDetailView(String artid) {
		return sqlSession.selectOne("getDetailView",artid);
	}

	@Override
	public List<ArticleVO> getMoreNewsList(SearchVO param) {
		return sqlSession.selectList("getMoreNewsList",param);
	}

	@Override
	public int getMoreNewsToCnt(SearchVO param) {
		return sqlSession.selectOne("getMoreNewsToCnt");
	}

	@Override
	public void updateDetailViewCnt(String artid) {
		sqlSession.update("updateViewCnt",artid);
	}

	@Override
	public int getArticleNO() {
		return sqlSession.selectOne("newsBack.getArticleNO");
	}

	@Override
	public List<ArticleVO> getMSnewsList(String dateStr) {
		return sqlSession.selectList("newsFront.getMSnewsList",dateStr);
	}

	@Override
	public ArticleVO getMsDetailView(String artid) {
		return sqlSession.selectOne("newsFront.getMsDetailView",artid);
	}

	@Override
	public String getYoutubeID() {
		return sqlSession.selectOne("newsFront.getYoutubeID");
	}

	@Override
	public void updateMsDetailViewCnt(String artid) {
		sqlSession.update("updateMsDetailViewCnt",artid);
	}

	@Override
	public PasswdResetVO getUserInfo(String id) {
		return sqlSession.selectOne("newsBack.getUserInfo",id);
	}


	@Override
	public void passwdUpdate(HashMap<String, String> updateMap) {
		sqlSession.update("newsBack.passwdUpdate",updateMap);
	}

	@Override
	public List<ArticleVO> getLineNews() {
		return sqlSession.selectList("newsFront.getLineNews");
	}

	@Override
	public List<ArticleVO> getKadoNewsList() {
		return sqlSession.selectList("getKadoNewsList");
	}

	@Override
	public int getMorekadoNewsToCnt(SearchVO param) {
		return sqlSession.selectOne("getMorekadoNewsToCnt");
	}

	@Override
	public List<ArticleVO> getMorekadoNewsList(SearchVO param) {
		return sqlSession.selectList("getMorekadoNewsList",param);
	}

	@Override
	public PasswdResetVO getUserNewInfo(String id) {
		return sqlSession.selectOne("newsBack.getUserNewInfo",id);
	}

	@Override
	public void passwdNewUpdate(PasswdResetVO resetVO) {
		sqlSession.update("newsBack.passwdNewUpdate",resetVO);
	}


}
