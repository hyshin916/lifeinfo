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
		buff.append("<ul class=\"article_box\">");
		
		
		for (ArticleVO item : msNewsList) {
			buff.append("<li>");
			buff.append("<a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/msNewsDetail?artid="+item.getNsid()+"\">");
			buff.append("<div class=\"box_img\">");
			buff.append("<img src=\"http://"+ Constants.HOST_DOMAIN + ":8080/lifeinfo/resources/articleImg/"+ item.getFileName() + "\">");
			buff.append("</div>");
			buff.append("<div class=\"box_text\">");
			buff.append("<div class=\"txt_position\">");
			buff.append("<h3>MS투데이</h3>");
			buff.append("<div class=\"text_num\">" + item.getTitle().replace("'","") + "</div>");
			buff.append("</div>");
			buff.append("</div>");
			buff.append("</a>");
			buff.append("</li>");
		}
		
		
/*		int listSize = 3;
		int totalRecord = msNewsList.size();
		int pageSize = totalRecord/listSize;

		if (totalRecord%listSize>0) {
			pageSize++;
		}
		System.out.println("MsListSize : " + listSize);
		System.out.println("totalRecord : " + totalRecord);
		System.out.println("pageSize:" + pageSize);
	
		int k = 0;
		int innerCnt = listSize;
	
		
		for (int i=0; i<pageSize ; i++) {
			
			System.out.println("[getTitle] :" + msNewsList.get(k).getTitle());
			
			buff.append("<li><div class=\"article_box\">");
			
			try {
				for (int j=k; j<innerCnt; k=j++) {
					msNewsList.get(j);
					String imgURL = "";
					if (Constants.HOST_DOMAIN.equals("ms-eshop.co.kr")) {
						imgURL = Constants.HOST_DOMAIN  +":8080/lifeinfo/resources/articleImg/" + msNewsList.get(j).getFileName();
					} else {
						imgURL = "ms-eshop.co.kr:8080/lifeinfo/resources/articleImg/yTJJ6dnTY8RmCYO2LSjkcAVORWvjql6X.jpg";
					}
					//buff.append("<a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/msNewsDetail?artid=" + msNewsList.get(j).getNsid()+ "\"><img src=\"http://"+ Constants.HOST_DOMAIN + ":8080/lifeinfo/resources/articleImg/"+ msNewsList.get(j).getFileName()+ "\" width=\"550\" alt=\"\"><div><h3>| 생활</h3><p class=\"text_num\">"+msNewsList.get(j).getTitle() +"</p><p>MS투데이</p></div></a>");
					buff.append("<a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/msNewsDetail?artid=" + msNewsList.get(j).getNsid()+ "\"><div class=\"box_img\"><img src=\"http://" +  imgURL + "\" width=\"550\" alt=\"\"></div><div class=\"box_text\"><h3>| 생활</h3><p class=\"text_num\">"+msNewsList.get(j).getTitle().replace("'", "") +"</p><p>MS투데이</p></div></a>");
				}
				k++;
				innerCnt = k+listSize;
				System.out.println("k: " + k + "innerCnt:" + innerCnt);
				buff.append("</div></li>");
			} catch (IndexOutOfBoundsException e) {
				break;
			}
			
		
		}*/
		
	/*	for (ArticleVO item : msNewsList) {
			
			if(item.getAuthor() == null){ 
				author = "[MS투데이]";
			} else { 
				author = item.getAuthor(); 
			};
			buff.append("<li><div class=\"article_box\"><a href=\"#\"><img src=\"./resources/front/img/ex9.PNG\" width=\"550\" alt=\"\"><div><h3>| 생활</h3><p class=\"text_num\">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p><p>MS투데이</p></div></a></div></li>");
		}*/
		buff.append("</ul>");
		buff.append("');");
			
		//makeFile(buff,PathClass.getMsNews());
	
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
			
			String title = article.getTitle().replace("'","");
			if (title.indexOf("긴급")!=-1 || title.indexOf("단독")!=-1 ) {
				title = "<span style=\"color:#FF0000;\"><B>" + title+ "</B></span>";
			}
			
			buff.append("<a href=\""+ "http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/"+ detailURI +"?artid="+ article.getNsid()+"\" >" + title +"</a></li>");
		}
		buff.append("</ul></div>');");
		
		try {
			/*FileOutputStream out = new FileOutputStream(PathClass.getLine_news());
			out.write(buff.toString().getBytes());
			out.flush();*/
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	/*많이본뉴스*/
	private void deployNewsAll(List<ArticleVO> newsALL) {
		StringBuffer buff = new StringBuffer();	
		buff.append("document.write('");
		int cnt = 1;
		for (ArticleVO item : newsALL) {
			String temp = "";
			if (item.getPcode().equals("M001")) {
				temp = "msNewsDetail";
			} else {
				temp = "newsDetail";
			}
			String activeCnt = "";
			if (cnt < 4) {
				 activeCnt = "<span class=\"cd_num active\">" + cnt  + "</span>";
			} else {
				 activeCnt = "<span class=\"cd_num\">" + cnt  + "</span>";
			}
			buff.append("<li><a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/" + temp + "?artid=" + item.nsid + "\">"+ activeCnt + item.title.replace("'","") + "</a></li>");
			cnt++;
		}
		
		buff.append("');");
		makeFile(buff,PathClass.getNewsAll());
		
	}

	/*카드뉴스리스트*/
	private void deployNewsList(List<ArticleVO> newsList, String press) {
		
		StringBuffer buff = new StringBuffer();	
		buff.append("document.write('");
	
		for (ArticleVO item : newsList) {
	

			buff.append("<li>");
			buff.append("<a href=\"http://" +  Constants.HOST_DOMAIN + ":8080/lifeinfo/newsDetail?artid=" + item.nsid + "\" class=\"artist_contents\">");
			buff.append("<div class=\"content_img\">");
			buff.append("<img src=\""+ item.imgurl +"\" alt=\"\">");
			buff.append("</div>");
			buff.append("<p class=\"subject\">");
			buff.append(item.title.replace("'",""));
			buff.append("</p>");
			buff.append("</a></li>");
			
		}
		buff.append("');");
		makeFile(buff,PathClass.getNewsList(press));
	}

	/*주요뉴스리스트*/
	private void deployImpNewsList(List<ArticleVO> impNewsList) {
		StringBuffer buff = new StringBuffer();	
		buff.append("document.write('");
		buff.append("<div class=\"owl-carousel\">");
		for (ArticleVO item : impNewsList) {
			//buff.append("<a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/newsDetail?artid=" + item.nsid +"\">");
			buff.append("<div class=\"carousel_wrap\">");
			buff.append("<a style=\"display:block;\" href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/newsDetail?artid=" + item.nsid +"\">");
			buff.append("<div class=\"owl_imgwrap\">");
			buff.append("<img src=\"" + item.imgurl +"\" alt=\""+ item.title.replace("'","") + "\"/>");
			buff.append("</div>");
			buff.append("<div class=\"sub\">");
			buff.append(item.getTitle().replace("'",""));
			buff.append("</div>");
			buff.append("</a>");
			buff.append("</div>");
			//buff.append("</a>");
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
		buff.append("<iframe id=\"ytplayer\" type=\"text/html\" width=\"100%\" height=\"200\" src=\"https://www.youtube.com/embed/" + youtubeID + "?autoplay=1&controls=1&playsinline=1\" frameborder=\"0\" allowfullscreen></iframe>");
		buff.append("');");
		makeFile(buff,PathClass.getYoutubeID());
	}
	
	
	
}
