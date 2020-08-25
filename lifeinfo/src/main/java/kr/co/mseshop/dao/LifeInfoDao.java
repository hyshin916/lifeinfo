package kr.co.mseshop.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.PasswdResetVO;
import kr.co.mseshop.model.SearchVO;

public interface LifeInfoDao {

	List<ArticleVO> getNewsList();

	List<ArticleVO> getImpNewsList();

	List<ArticleVO> getNewsAllList(String date);

	ArticleVO getDetailView(String artid);

	List<ArticleVO> getMoreNewsList(SearchVO param);

	int getMoreNewsToCnt(SearchVO param);

	void updateDetailViewCnt(String artid);

	int getArticleNO();

	List<ArticleVO> getMSnewsList(String dateStr);

	ArticleVO getMsDetailView(String artid);

	String getYoutubeID();

	void updateMsDetailViewCnt(String artid);

	PasswdResetVO getUserInfo(String id);

	void passwdUpdate(HashMap<String, String> updateMap);

	List<ArticleVO> getLineNews();

	List<ArticleVO> getKadoNewsList();

	int getMorekadoNewsToCnt(SearchVO param);

	List<ArticleVO> getMorekadoNewsList(SearchVO param);

	PasswdResetVO getUserNewInfo(String id);

	void passwdNewUpdate(PasswdResetVO resetVO);

}
