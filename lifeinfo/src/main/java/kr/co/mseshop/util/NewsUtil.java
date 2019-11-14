package kr.co.mseshop.util;

import java.util.Map;

import org.springframework.ui.Model;

import kr.co.mseshop.model.NewsVO;

public class NewsUtil {
	
	public static String convertNewsID(String newsID) {
		int start = newsID.lastIndexOf("=");
		String resultID = newsID.substring(start + 1, newsID.length());
		System.out.println("resultID : " + resultID);
		return resultID;
	}
	
	
	public static void getMemNews(Map<String,Object> innerMap,Model model, String newsID) {
		System.out.println("##################");
		System.out.println("[NEWSID] : " + newsID);
		NewsVO newsVO = (NewsVO) innerMap.get(newsID);
		System.out.println(newsVO);
		System.out.println("##########################");
		model.addAttribute("newsInfo", newsVO);
	}
	
	
}
