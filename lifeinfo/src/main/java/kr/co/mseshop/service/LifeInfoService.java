package kr.co.mseshop.service;

import java.util.List;

import org.springframework.ui.Model;

import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.NewsVO;
import kr.co.mseshop.model.PasswdResetVO;
import kr.co.mseshop.model.SearchVO;

public interface LifeInfoService {

	public String getResultParser();


	public void getMemNews(Model model, String newsID);

	public void getFestival(Model model);

	public void getPositionInfra(Model model, String x, String y);

	public void getPositionDetail(Model model, String contentid);

	public ArticleVO getDetailView(String artid);

	public List<ArticleVO> getMoreNewsList(SearchVO param);

	public int getMoreNewsToCnt(SearchVO param);

	public void updateDetailViewCnt(String artid);

	public int getArticleNO();


	public ArticleVO getMsDetailView(String artid);


	public void updateMsDetailViewCnt(String artid);


	public List<ArticleVO> getGetmallImpNewsList();


	public List<ArticleVO> getNewsALL();


	public List<ArticleVO> getImpNewsList();


	public List<ArticleVO> getNewsList();


	public List<ArticleVO> getMslifeList();


	public String getMainYoutubeID();


	public PasswdResetVO getUserInfo(String id);

	public void passwdUpdate(String id, String passwordHashed);


	public List<ArticleVO> getLineNews();


	public List<ArticleVO> getKadoNewsList();


	public int getMorekadoNewsToCnt(SearchVO param);


	public List<ArticleVO> getMorekadoNewsList(SearchVO param);


	public PasswdResetVO getUserNewInfo(String id);


	public void passwdNewUpdate(PasswdResetVO resetVO);

}
