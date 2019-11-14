package kr.co.mseshop.common;

public class PathClass {

	public final static String host = Constants.HOST_DOMAIN;
	// public final static String OS = "linux";
	
	public static String news_msnews;
	public static String youtubeID;
	public static String news_impnews;
	public static String news_newslist;
	public static String news_newsall;

	public static String photo_upload; // smart edior 안에 포트업로드
	public static String article_upload; // 썸네일 업로드
	
	public static String line_news;
	
	
	@SuppressWarnings("unused")
	public static String getPhoto_upload() {
		if (host == Constants.LOCAL_IP) {
			photo_upload = "D:\\eclipse-workspace\\lifeinfo\\src\\main\\webapp\\resources";
		} else  {
			photo_upload = "/usr/local/tomcat/webapps/lifeinfo/resources";
		}
		return photo_upload;
	}

	@SuppressWarnings("unused")
	public static String getArticle_upload() { // 썸네일 업로드
		if (host == Constants.LOCAL_IP) {
			article_upload = "D:\\eclipse-workspace\\lifeinfo\\src\\main\\webapp\\resources\\articleImg\\";
		} else{
			article_upload = "/usr/local/tomcat/webapps/lifeinfo/resources/articleImg/";
		}
		return article_upload;
	}


	
	@SuppressWarnings("unused")
	public static String getLine_news() {
		if (host == Constants.LOCAL_IP) {
			line_news = "D:\\linenews.js";
		} else  {
			line_news = "/usr/local/tomcat/webapps/lifeinfo/resources/js/linenews.js"; 
		}
		return line_news;
	}
	
	
	@SuppressWarnings("unused")
	public static String getMsNews() {
		if (host == Constants.LOCAL_IP) {
			news_msnews = "D:\\msnews.js";
		} else  {
			news_msnews = "/usr/local/tomcat/webapps/lifeinfo/resources/js/msnews.js";
		}
		return news_msnews;
	}

	@SuppressWarnings("unused")
	public static String getYoutubeID() {
		if (host == Constants.LOCAL_IP) {
			youtubeID = "D:\\youtube.js";
		} else  {
			youtubeID = "/usr/local/tomcat/webapps/lifeinfo/resources/js/youtube.js";
		}
		return youtubeID;
	}

	@SuppressWarnings("unused")
	public static String getImpNews() {
		if (host == Constants.LOCAL_IP) {
			news_impnews = "D:\\impnews.js";
		} else  {
			news_impnews = "/usr/local/tomcat/webapps/lifeinfo/resources/js/impnews.js";
		}
		return news_impnews;
	}

	@SuppressWarnings("unused")
	public static String getNewsList(String press) {
		if (host == Constants.LOCAL_IP) {
			if (press.equals("kwnews")) {
				news_newslist = "D:\\newslist.js";
			} else if(press.equals("kado")) {
				news_newslist = "D:\\kadoNewslist.js";
			}
			
		} else  {
			if (press.equals("kwnews")) {
				news_newslist = "/usr/local/tomcat/webapps/lifeinfo/resources/js/newslist.js";
			} else if (press.equals("kado")) {
				news_newslist = "/usr/local/tomcat/webapps/lifeinfo/resources/js/kadoNewslist.js";
			}
			
		}
		return news_newslist;
	}

	@SuppressWarnings("unused")
	public static String getNewsAll() {
		if (host == Constants.LOCAL_IP) {
			news_newsall = "D:\\newsall.js";
		} else  {
			news_newsall = "/usr/local/tomcat/webapps/lifeinfo/resources/js/newsall.js";
		}
		return news_newsall;
	}
}
