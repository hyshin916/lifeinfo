package kr.co.mseshop.back.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mseshop.back.dao.NewsBackDao;
import kr.co.mseshop.criteria.BbsInfoCriteria;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.FileVO;

@Repository("newsBackDao")
public class NewsBackDaoImpl implements NewsBackDao {

	
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public void add(ArticleVO articleVO) {
		sqlSession.insert("newsBack.newsAdd",articleVO);
	}
	@Override
	public List<ArticleVO> list(BbsInfoCriteria criteria,RowBounds rowBounds) {
		return sqlSession.selectList("newsBack.newsList",criteria,rowBounds);
	}
	@Override
	public ArticleVO getDetail(String nsid) {
		return sqlSession.selectOne("newsBack.getDetail",nsid);
	}
	@Override
	public void updateOrderByNO(HashMap<String, String> paramMap) {
		System.out.println(paramMap.get("nsid") + ";" + paramMap.get("idx"));
		sqlSession.update("newsBack.updateOrderByNO",paramMap);
	}
	@Override
	public void updateArticle(ArticleVO articleVO) {
		sqlSession.update("newsBack.updateArticle",articleVO);
	}
	@Override
	public void fileUpload(FileVO fileVO) {
		sqlSession.insert("newsBack.fileUpload",fileVO);
	}
	@Override
	public void updateFile(FileVO fileVO) {
		sqlSession.update("newsBack.updateFile",fileVO);
	}
	@Override
	public int getRowCount(BbsInfoCriteria criteria) {
		return sqlSession.selectOne("newsBack.getRowCount",criteria);
	}
	@Override
	public void deleteFile(String fno) {
		sqlSession.delete("newsBack.deleteFile",fno);
	}
	@Override
	public int getNewsRowCount(BbsInfoCriteria criteria) {
		return sqlSession.selectOne("newsBack.getNewsRowCount",criteria);
	}
	@Override
	public List<ArticleVO> getNewslist(BbsInfoCriteria criteria, RowBounds rowBounds) {
		return sqlSession.selectList("newsBack.getNewslist",criteria,rowBounds);
	}
	@Override
	public ArticleVO getNewsDetail(String nsid) {
		return sqlSession.selectOne("newsBack.getNewsDetail",nsid);
	}
	@Override
	public void updateNewsArticle(ArticleVO articleVO) {
		sqlSession.update("newsBack.updateNewsArticle",articleVO);
	}
	@Override
	public String isImgUrlChk(String nsid) {
		return sqlSession.selectOne("newsBack.isImgUrlChk",nsid);
	}
	@Override
	public List<ArticleVO> getLineStatus() {
		return sqlSession.selectList("newsBack.getLineStatus");
	}
	@Override
	public List<ArticleVO> getImpList() {
		return sqlSession.selectList("newsBack.getImpList");
	}
	@Override
	public List<ArticleVO> getLifeMainList() {
		return sqlSession.selectList("newsBack.getLifeMainList");
	}

}
