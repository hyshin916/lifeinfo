package kr.co.mseshop.common;

public class PathClass {

	public final static String host = Constants.HOST_DOMAIN;
	// public final static String OS = "linux";

	public static String news_msnews;
	public static String news_msnews_mainBanner;

	public static String youtubeID;
	public static String news_impnews;
	public static String news_newslist;
	public static String news_newsall;

	public static String photo_upload; // smart edior 안에 포트업로드
	public static String article_upload; // 썸네일 업로드

	public static String line_news;
	public static String beyond_news;
	public static String multy_news;
	public static String real_news;

	public static String deamon_status;

	@SuppressWarnings("unused")
	public static String getDeamon_status() {
		if (host == Constants.LOCAL_IP) {
			deamon_status = "D:\\daemonStatus.properties";
		} else {
			deamon_status = "/usr/local/tomcat/webapps/lifeinfo/resources/daemonStatus.properties";
		}
		return deamon_status;
	}

	@SuppressWarnings("unused")
	public static String getPhoto_upload() {
		if (host == Constants.LOCAL_IP) {
			photo_upload = "C:\\Users\\사용자\\git\\lifeinfo\\lifeinfo\\src\\main\\webapp\\resources";
		} else {
			photo_upload = "/usr/local/tomcat/webapps/lifeinfo/resources";
		}
		return photo_upload;
	}

	@SuppressWarnings("unused")
	public static String getArticle_upload() { // 썸네일 업로드
		if (host == Constants.LOCAL_IP) {
			article_upload = "C:\\Users\\사용자\\git\\lifeinfo\\lifeinfo\\src\\main\\webapp\\resources\\articleImg\\";
		} else {
			article_upload = "/usr/local/tomcat/webapps/lifeinfo/resources/articleImg/";
		}
		return article_upload;
	}

	@SuppressWarnings("unused")
	public static String getLine_news(String kind) {
		if (host == Constants.LOCAL_IP) {
			switch (kind) {
			case "js":
				line_news = "D:\\linenews.js";
				break;
			case "html":
				line_news = "D:\\linenews.html";
			}
		} else {
			switch (kind) {
			case "js":
				line_news = "/usr/local/tomcat/webapps/lifeinfo/resources/js/linenews.js";
				break;
			case "html":
				line_news = "/usr/local/tomcat/webapps/lifeinfo/resources/js/linenews.html";
			}
		}
		return line_news;
	}

	/**
	 * @Description : 비욘드라이프
	 */
	@SuppressWarnings("unused")
	public static String getBeyond_news() {
		if (host == Constants.LOCAL_IP) {
			beyond_news = "D:\\byond.js";
		} else {
			beyond_news = "/usr/local/tomcat/webapps/lifeinfo/resources/js/beyond.js";
		}
		return beyond_news;
	}

	/**
	 * @Description : 생생정보
	 */
	@SuppressWarnings("unused")
	public static String getReal_news() {
		if (host == Constants.LOCAL_IP) {
			real_news = "D:\\real.js";
		} else {
			real_news = "/usr/local/tomcat/webapps/lifeinfo/resources/js/real.js";
		}
		return real_news;
	}

	/**
	 * @Description : 뉴스
	 */
	@SuppressWarnings("unused")
	public static String getMulty_news() {
		if (host == Constants.LOCAL_IP) {
			multy_news = "D:\\multy.js";
		} else {
			multy_news = "/usr/local/tomcat/webapps/lifeinfo/resources/js/multy.js";
		}
		return multy_news;
	}

	@SuppressWarnings("unused")
	public static String getMsNews(String kind) {
		if (host == Constants.LOCAL_IP) {
			switch (kind) {
			case "js":
				news_msnews = "D:\\msnews.js";
				break;
			case "html":
				news_msnews = "D:\\msnews.html";
			}
		} else {
			switch (kind) {
			case "js":
				news_msnews = "/usr/local/tomcat/webapps/lifeinfo/resources/js/msnews.js";
				break;
			case "html":
				news_msnews = "/usr/local/tomcat/webapps/lifeinfo/resources/js/msnews.html";
			}

		}
		return news_msnews;
	}

	@SuppressWarnings("unused")
	public static String getMsNewsMainBanner(String kind) {
		if (host == Constants.LOCAL_IP) {
			switch (kind) {
			case "js":
				news_msnews_mainBanner = "D:\\msnews_mainBanner.js";
				break;
			case "html":
				news_msnews_mainBanner = "D:\\msnews_mainBanner.html";
				break;
			}
		} else {
			switch (kind) {
			case "js":
				news_msnews_mainBanner = "/usr/local/tomcat/webapps/lifeinfo/resources/js/msnews_mainBanner.js";
				break;
			case "html":
				news_msnews_mainBanner = "/usr/local/tomcat/webapps/lifeinfo/resources/js/msnews_mainBanner.html";
				break;
			}
		}
		return news_msnews_mainBanner;
	}

	@SuppressWarnings("unused")
	public static String getYoutubeID() {
		if (host == Constants.LOCAL_IP) {
			youtubeID = "D:\\youtube.js";
		} else {
			youtubeID = "/usr/local/tomcat/webapps/lifeinfo/resources/js/youtube.js";
		}
		return youtubeID;
	}

	@SuppressWarnings("unused")
	public static String getImpNews() {
		if (host == Constants.LOCAL_IP) {
			news_impnews = "D:\\impnews.js";
		} else {
			news_impnews = "/usr/local/tomcat/webapps/lifeinfo/resources/js/impnews.js";
		}
		return news_impnews;
	}

	@SuppressWarnings("unused")
	public static String getNewsList(String press) {
		if (host == Constants.LOCAL_IP) {
			if (press.equals("kwnews")) {
				news_newslist = "D:\\newslist.js";
			} else if (press.equals("kado")) {
				news_newslist = "D:\\kadoNewslist.js";
			}

		} else {
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
		} else {
			news_newsall = "/usr/local/tomcat/webapps/lifeinfo/resources/js/newsall.js";
		}
		return news_newsall;
	}
}
