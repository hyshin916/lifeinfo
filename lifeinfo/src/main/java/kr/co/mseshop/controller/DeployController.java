package kr.co.mseshop.controller;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.mseshop.common.Constants;
import kr.co.mseshop.common.PathClass;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.service.LifeInfoService;

@Controller
public class DeployController {

	
	@Inject
	LifeInfoService lifeInfoService;
	
	@RequestMapping(value="/deploy.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String deployMsNewsList() {
		Gson gson = new Gson();
		List<ArticleVO>  msNewsList = lifeInfoService.getMslifeList();
		String youtubeID = lifeInfoService.getMainYoutubeID();
		List<ArticleVO>  impNewsList = lifeInfoService.getImpNewsList(); 
		List<ArticleVO>  newsList = lifeInfoService.getNewsList(); // 강원일보
		List<ArticleVO>  kadoNewsList = lifeInfoService.getKadoNewsList(); // 도민일보
		List<ArticleVO>  newsALL = lifeInfoService.getNewsALL();
		
		deployNewsAll(newsALL);

		deployNewsList(newsList,"kwnews");
		deployNewsList(kadoNewsList,"kado");
		
		deployImpNewsList(impNewsList);
		
		deployYoutube(youtubeID);
		getLineNewsJSON(); // 한줄뉴스
		
		String author = "";
		StringBuffer buff = new StringBuffer();	
		buff.append("document.write('");
		for (ArticleVO item : msNewsList) {
			
			if(item.getAuthor() == null){ 
				author = "[MS투데이]";
			} else { 
				author = item.getAuthor(); 
			};
				buff.append("<a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/msNewsDetail?artid=" + item.getNsid() + "\"><li class=\"movie\" style=\"width: 100%; height: 82px; text-align: left; display: inline-block;\">");
				buff.append("<span class=\"thumb\" style=\"position: absolute;\"><img src=\"http://" +  Constants.HOST_DOMAIN + ":8080/lifeinfo/resources/articleImg/"+ item.getFileName() + "\" style=\"margin: 5px 0 0 0; width: 120px; height: 72px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;\" onerror=\"\"></span>");
				buff.append("<span class=\"title\" style=\"color: #333; height: 62px; position: absolute; margin: 10px 20px 10px 130px;\"><span style=\"color:#606060;\"><B>[MS]</B></span><br>" + item.getTitle().replace("'","") + "</span>");
			// 조회수	buff.append("<span style=\"position:absolute;color: #333; padding: 65px 0 0 130px; text-align: left; display: inline-block;\" class=\"author\"><img style=\"padding:16px 2px 0 0;\" class=\"author\" src=\"./resources/images/eye_1.png\"/>"+ item.getUv() + "</span>");
				buff.append("<span style=\"position:absolute;color: #333; padding: 65px 0 0 130px; text-align: left; display: inline-block;\" class=\"author\"></span>");
				buff.append("<span style=\"color: #333; padding: 75px 10px 0px 0; width: 100%; right: 40px; text-align: right; display: inline-block;\" class=\"author\">" +  author + "</span></li></a><hr style=\"margin: 0px;\">");
		}
		buff.append("');");
			
		makeFile(buff,PathClass.getMsNews());
	
		HashMap<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("result", "success");
		return gson.toJson(resultMap);
	}

	/*라인뉴스*/
	public void getLineNewsJSON() {
		
		List<ArticleVO> lineNewsList = lifeInfoService.getLineNews();
		
		StringBuffer buff = new StringBuffer();
		
		buff.append("document.write('<div><ul id=\"scroller\">");
		String detailURI = "";
		for (ArticleVO article : lineNewsList) {
			
			if (article.getPcode().equals("M001")) {
				detailURI = "msNewsDetail";
			} else {
				detailURI = "newsDetail";
			}
			
			buff.append("<li>");
			buff.append("<a href=\""+ "http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/"+ detailURI +"?artid="+ article.getNsid()+"\" >" +article.getTitle().replace("'","") +"</a></li>");
		}
		buff.append("</ul></div>');");
		
		try {
			FileOutputStream out = new FileOutputStream(PathClass.getLine_news());
			out.write(buff.toString().getBytes());
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/*많이본뉴스*/
	private void deployNewsAll(List<ArticleVO> newsALL) {
		StringBuffer buff = new StringBuffer();	
		buff.append("document.write('");
		
		for (ArticleVO item : newsALL) {
			String temp = "";
			if (item.getPcode().equals("M001")) {
				temp = "msNewsDetail";
			} else {
				temp = "newsDetail";
			}
			
			buff.append("<li class=\"newsallClass\"><a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/" + temp + "?artid=" + item.nsid + "\">" + item.title.replace("'","") + "</a></li>");
		}
		
		buff.append("');");
		makeFile(buff,PathClass.getNewsAll());
		
	}

	/*카드뉴스리스트*/
	private void deployNewsList(List<ArticleVO> newsList, String press) {
		StringBuffer buff = new StringBuffer();	
		buff.append("document.write('");
		for (ArticleVO item : newsList) {
			buff.append("<li style=\"display: block;\"><a href=\"http://" +  Constants.HOST_DOMAIN + ":8080/lifeinfo/newsDetail?artid=" + item.nsid + "\"><span class=\"thumb\"><img class=\"img_thum\" src=\"" + item.imgurl + "\" onerror=\"\"/></span></a>");
			buff.append("<div class=\"alt_1_detail\" style=\"height:50px;\">");
			buff.append("<a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/newsDetail?artid=" + item.nsid + "\" class=\"alt_1_detail_link\"><strong>");
			if (item.getPcode().equals("0001")) {
				buff.append("[강원일보]");
			} else if (item.getPcode().equals("0002")) {
				buff.append("[도민일보]");
			}
			buff.append( "</strong>" + item.title.replace("'","") + "</a>");
			// 조회수 buff.append("</div><div class=\"viewCntPrt\"><p class=\"viewCnt\"><img src=\"./resources/images/eye_1.png\"/>" + item.uv + "</p></div></li>");
			buff.append("</div></li>");
		}
		buff.append("');");
		makeFile(buff,PathClass.getNewsList(press));
	}

	/*주요뉴스리스트*/
	private void deployImpNewsList(List<ArticleVO> impNewsList) {
		StringBuffer buff = new StringBuffer();	
		buff.append("document.write('");
		for (ArticleVO item : impNewsList) {
			buff.append("<div class=\"swiper-slide\" id=\"mslifeA\">");
			buff.append("<a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/newsDetail?artid=" + item.nsid +"\"><div>" + item.title.replace("'", "")  +"</div><img src=\"" + item.imgurl +"\" alt=\""+ item.title.replace("'","") + "\" /></a>");
			buff.append("</div>");
		}
		buff.append("');");
		makeFile(buff,PathClass.getImpNews());
	}

	private void makeFile(StringBuffer buff, String newsMsnews) {
		try {
			@SuppressWarnings("resource")
			FileOutputStream out = new FileOutputStream(newsMsnews);
			out.write(buff.toString().getBytes());
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void deployYoutube(String youtubeID) {
		StringBuffer buff = new StringBuffer();	
		buff.append("document.write('");
		buff.append("<iframe id=\"ytplayer\" type=\"text/html\" width=\"100%\" height=\"200\" src=\"https://www.youtube.com/embed/" + youtubeID + "?autoplay=1\" frameborder=\"0\"></iframe>");
		buff.append("');");
		makeFile(buff,PathClass.getYoutubeID());
	}
	
	
	
}
