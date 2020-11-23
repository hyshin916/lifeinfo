package kr.co.mseshop.controller;


import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import kr.co.mseshop.common.Constants;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.SearchVO;
import kr.co.mseshop.service.LifeInfoService;
import kr.co.mseshop.util.Base64Util;
import kr.co.mseshop.util.NewsMLParser;

@Controller
public class LifeInfoController {

	@Inject
	NewsMLParser newsMLParser;

	@Inject
	LifeInfoService lifeInfoService;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 작성자 : 신현영 내용 : 지역축제정보 가져오기
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/festival")
	public String getFestival(Model model) {
		

		lifeInfoService.getFestival(model);

		
		return "festival";
	}

	/**
	 * 작성자 : 신현영 내용 : 날씨정보 OpenweatherAPI 사용
	 * 
	 * @param model
	 * @param newsVO
	 * @return
	 */
	@RequestMapping(value = "/msmart")
	public String getWeather(Model model, ArticleVO articleVO,@RequestParam(value="appChk",required=false) String appChk,@RequestParam(value="mslife",required=false) String mslife) {
		System.out.println("appChk:" + appChk);
		if (mslife!=null) {
			System.out.println("mslife:" + Base64Util.getInstance().deCoder(mslife));
		}
		logger.info("[logger info]");
		model.addAttribute("appChk",appChk);
		model.addAttribute("moreNewsURL",Constants.HOST_DOMAIN);
		return "weather";
	}

	/**
	 * 작성자 : 신현영 내용 : 위치기반 내주변 관광명소 API
	 * 
	 * @param model
	 * @param x
	 * @param y
	 * @return
	 */
	@RequestMapping(value = "/positionInfra")
	public String getPostionInfra(Model model, @RequestParam String x, @RequestParam String y) {

		lifeInfoService.getPositionInfra(model, x, y);
		return "positionInfra";
	}

	/**
	 * 작성자 : 신현영 내용 : 메모리상에 뉴스상세정보 가져오기
	 * 
	 * @param model
	 * @param newsID
	 * @return
	 */
	@RequestMapping(value = "/msnews")
	public String innerDetail(Model model, @RequestParam String newsID) {

		lifeInfoService.getMemNews(model, newsID);

		return "msnews";
	}

	/**
	 * 작성자 : 신현영 내용 : 메모리상에 위치기반 상세정보 가져오기
	 * 
	 * @param model
	 * @param contentid
	 * @return
	 */
	@RequestMapping(value = "/positionDetail")
	public String positionDetail(Model model, @RequestParam String contentid) {

		lifeInfoService.getPositionDetail(model, contentid);
		return "positionDetail";
	}
	
	@RequestMapping(value = "/msNewsDetail", method = RequestMethod.GET)
	public String msNewsDetail(Model model,HttpServletRequest request,HttpServletResponse response,@RequestParam String artid,@RequestParam(value="section",required=false) String section) {
		
	/*	CookieUtils cookieUtils = CookieUtils.getInstance();
		int result = cookieUtils.chkCookies(request, response, artid);*/
/*		
		if (result == 0) {
			lifeInfoService.updateMsDetailViewCnt(artid);
		}*/
		
		lifeInfoService.updateMsDetailViewCnt(artid); // 19.12.20 PV로 전환
		
		ArticleVO articleView = lifeInfoService.getMsDetailView(artid);
		model.addAttribute("moreNewsURL",Constants.HOST_DOMAIN);
		model.addAttribute("detailView",articleView);
		return "msNewsDetail";
	}
	
	
	@RequestMapping(value="/newsDetail",method=RequestMethod.GET)
	public String detail(Model model,HttpServletRequest request,HttpServletResponse response,@RequestParam String artid,@RequestParam(value="section",required=false) String section) {
		
		ArticleVO articleView = null;
		if (section!=null && section.equals("morenewslist")) {
			model.addAttribute("section","morenewslist");
		}
		
/*		CookieUtils cookieUtils = CookieUtils.getInstance();
		int result = cookieUtils.chkCookies(request, response, artid);*/
		
		lifeInfoService.updateDetailViewCnt(artid); // 19.12.20 PV로 전환
	/*	if (result == 0) { // 쿠키체크
			lifeInfoService.updateDetailViewCnt(artid);
		}*/
		
		articleView = lifeInfoService.getDetailView(artid);
		chkCntURL(articleView.getPc_url());
		model.addAttribute("moreNewsURL",Constants.HOST_DOMAIN);
		model.addAttribute("detailView",articleView);
		return "newsDetail";
	}
	
	/*언론사조희수증가*/
	public void chkCntURL(String path) {
		URL url;
		try {
			url = new URL(path);
			  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			System.out.println("[refPath]:" + path +"["+ conn.getResponseCode()+"]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(value="/moreNewsList") // 강원일보
	public String moreNewsList(SearchVO param,Model model) {
		 int totalCnt = lifeInfoService.getMoreNewsToCnt(param);
		 int cnt = (int) Math.ceil((double)totalCnt/20);
		 model.addAttribute("totalCnt",cnt);
		  model.addAttribute("moreNewsURL",Constants.HOST_DOMAIN);
		  return "moreNewsList";
	}
	
	@RequestMapping(value="/morekadoNewsList") //도민일보
	public String morekadoNewsList(SearchVO param,Model model) {
		 int totalCnt = lifeInfoService.getMorekadoNewsToCnt(param);
		 int cnt = (int) Math.ceil((double)totalCnt/20);
		 model.addAttribute("totalCnt",cnt);
		  model.addAttribute("moreNewsURL",Constants.HOST_DOMAIN);
		  return "morekadoNewsList";
	}
	
	@RequestMapping(value="/oilInfoList")
	public String oilInfoList(Model model) {
		  model.addAttribute("moreNewsURL",Constants.HOST_DOMAIN);
		  return "oilInfoList";
	}

}
