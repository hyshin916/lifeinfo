package kr.co.mseshop.back.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kr.co.mseshop.criteria.BbsInfoCriteria;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.FileVO;

public interface LifeInfoBackService {

	public void add(ArticleVO articleVO);

	public List<ArticleVO> list(BbsInfoCriteria criteria, RowBounds rowBounds);

	public ArticleVO getDetail(String nsid);

	public void updateOrderByNO(String nsid, String idx);

	public void updateArticle(ArticleVO articleVO);

	public void fileUpload(FileVO fileVO);

	public void updateFile(FileVO fileVO);

	public int getRowCount(BbsInfoCriteria criteria);

	public void deleteFile(String fno);

	public int getNewsRowCount(BbsInfoCriteria criteria);

	public List<ArticleVO> getNewslist(BbsInfoCriteria criteria, RowBounds rowBounds);

	public ArticleVO getNewsDetail(String nsid);

	public void updateNewsArticle(ArticleVO articleVO);

	public String isImgUrlChk(String nsid);

	public List<ArticleVO> getLineStatus();

	public List<ArticleVO> getImpList();

	public List<ArticleVO> getLifeMainList();


}
