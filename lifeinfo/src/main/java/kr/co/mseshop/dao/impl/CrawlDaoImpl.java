package kr.co.mseshop.dao.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mseshop.dao.CrawlDao;
import kr.co.mseshop.model.CategoryCodeVO;
import kr.co.mseshop.model.CrawlInfoVO;
import kr.co.mseshop.model.MadeCategoryCodeVO;
import kr.co.mseshop.model.RefindDataVO;
import kr.co.mseshop.model.SearchDataVO;

@Repository("crawlDao")
public class CrawlDaoImpl implements CrawlDao {
	
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<CrawlInfoVO> list() {
		return sqlSession.selectList("list");
	}

	@Override
	public List<String> getViewlist(String no) {
		String productNo = no;
		return sqlSession.selectList("getViewlist",productNo);
		
	}

	@Override
	public List<String> codeList() {
		return sqlSession.selectList("codeList");
	}

	@Override
	public List<String> categoryList(String param) {
		return sqlSession.selectList("categoryList",param);
	}

	@Override
	public List<String> categoryListSmall(String param) {
		return sqlSession.selectList("categoryListSmall",param);
	}

	@Override
	public String getLastCode(MadeCategoryCodeVO codeVo) {
		return sqlSession.selectOne("getLastCode",codeVo);
	}

	@Override
	public List<String> categoryListDetailView(String param) {
		return sqlSession.selectList("categoryListDetailView",param);
	}

	@Override
	public void insert(RefindDataVO refindVo) {
		
		try {
			sqlSession.insert("refindInsert",refindVo);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("상품 DB 중복입력");
			}
		}
	
	}

	@Override
	public void updateRefindInfo(RefindDataVO refindVO) {
		sqlSession.update("updateRefindInfo", refindVO);
	}

	@Override
	public List<RefindDataVO> getExportData() {
		return sqlSession.selectList("getExportData");
	}

	@Override
	public int dbInsertChk() {
		return sqlSession.selectOne("dbInsertChk");
	}


	@Override
	public List<RefindDataVO> getRefindData() {
		return sqlSession.selectList("getRefindData");
	}

	@Override
	public void insertExcelData(Map<String, String> exportExcelParam) {
		try {
			System.out.println("=============error Dao");
			sqlSession.insert("insertExcelData",exportExcelParam);
			System.out.println("====" + " " + exportExcelParam.get("sellingCode"));
			sqlSession.commit();
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("상품 DB 중복입력");
			}
		}
	
	}

	@Override
	public List<CrawlInfoVO> searchList(SearchDataVO searchVO) {
		return sqlSession.selectList("searchList",searchVO);
	}

	@Override
	public void deleteExcelData() {
		sqlSession.delete("deleteExcelData");
	}

	@Override
	public List<CrawlInfoVO> searchListCode(SearchDataVO searchVO) {
		return sqlSession.selectList("searchListCode",searchVO);
	}

	@Override
	public List<CrawlInfoVO> refindList() {
		return sqlSession.selectList("refindList");
	}

	@Override
	public void deleteRefind() {
		sqlSession.update("updateInsert");
	}

	@Override
	public List<Object> testpro(Map<String, Object> param) {
		return sqlSession.selectOne("testpro",param);
	}

}
