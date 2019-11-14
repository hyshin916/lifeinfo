package kr.co.mseshop.back.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kr.co.mseshop.criteria.BbsInfoCriteria;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.FileVO;

public interface NewsBackDao {

	void add(ArticleVO articleVO);

	List<ArticleVO> list(BbsInfoCriteria criteria, RowBounds rowBounds);

	ArticleVO getDetail(String nsid);

	void updateOrderByNO(HashMap<String, String> paramMap);

	void updateArticle(ArticleVO articleVO);

	void fileUpload(FileVO fileVO);

	void updateFile(FileVO fileVO);

	int getRowCount(BbsInfoCriteria criteria);

	void deleteFile(String fno);

	int getNewsRowCount(BbsInfoCriteria criteria);

	List<ArticleVO> getNewslist(BbsInfoCriteria criteria, RowBounds rowBounds);

	ArticleVO getNewsDetail(String nsid);

	void updateNewsArticle(ArticleVO articleVO);

	String isImgUrlChk(String nsid);

	List<ArticleVO> getLineStatus();

	List<ArticleVO> getImpList();

	List<ArticleVO> getLifeMainList();


}
