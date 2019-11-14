package kr.co.mseshop.controller;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.mseshop.api.OilInfoAPI;
import kr.co.mseshop.common.Constants;
import kr.co.mseshop.common.PathClass;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.DataSet;
import kr.co.mseshop.model.OilInfoVO;
import kr.co.mseshop.model.PasswdResetVO;
import kr.co.mseshop.model.SearchVO;
import kr.co.mseshop.service.LifeInfoService;

@Controller
public class LifeInfoJSONController {
	
	@Inject
	LifeInfoService lifeInfoService;
	
	@Inject
	OilInfoAPI oilInfoAPI;
	
	
	@RequestMapping(value="/passwdReset.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getPasswdReset(@RequestParam(value="id",required=false) String id,@RequestParam(value="result",required=false) String result) {
		
		Gson gson = new Gson();
		  System.out.println("RESET ID:" + id);
		  System.out.println("RESULT FLAG:" + result);
		
		  HashMap<String,String> userMap = new HashMap<String,String>();
		
		  if (result!=null && result.equals("Y")) {
			  System.out.println("initalized...");
			  userMap = new HashMap<String,String>();
			  String passwordHashed = BCrypt.hashpw("1234", BCrypt.gensalt());
			  lifeInfoService.passwdUpdate(id,passwordHashed);
			  userMap.put("init", "initalized");
			  return gson.toJson(userMap); 
		  } else {
			  PasswdResetVO userInfo = lifeInfoService.getUserInfo(id);
			  userMap.put("id", userInfo.getNo_htel());
			  userMap.put("address", userInfo.getNm_addr());
			  userMap.put("name", userInfo.getNm_byr());
		  	  return gson.toJson(userMap);
		  }
		
	}
	
	
	@RequestMapping(value="/mise.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getMeseInfoJSON() {
		Gson gson = new Gson();
		String miseInfo = lifeInfoService.getResultParser();
		HashMap<String,String> miseMap = new HashMap<String,String>();
		miseMap.put("mise", miseInfo);
		return gson.toJson(miseMap);
	}
	

	
	
	
	@RequestMapping(value="/newsAll.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getnewsAll() {
		Gson gson = new Gson();
		List<ArticleVO>  articleList = lifeInfoService.getNewsALL();
		return gson.toJson(articleList);
	}
	
	
	@RequestMapping(value="/impNews.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getimpNews() {
		Gson gson = new Gson();
		List<ArticleVO>  articleList = lifeInfoService.getImpNewsList();
		
		String output = "";
		int cnt = 1;
		HashMap<String,String> articleMap = new HashMap<String,String>();
		for (ArticleVO item : articleList) {
			output = "<a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/newsDetail?artid=" + item.nsid +"\"><img src=\"" + item.imgurl +"\" alt=\""+ item.caption_title + "\" /></a>";
			articleMap.put("article"+cnt, output);
			cnt++;
		}
		
		return gson.toJson(articleMap);
	}
	
	@RequestMapping(value="/newsList.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getnewsList() {
		Gson gson = new Gson();
		List<ArticleVO>  newsList = lifeInfoService.getNewsList();
		String output = "";
		for (ArticleVO item : newsList) {
			output += "<li style=\"display: block;\"><a href=\"http://" +  Constants.HOST_DOMAIN + ":8080/lifeinfo/newsDetail?artid=" + item.nsid + "\"><span class=\"thumb\"><img class=\"img_thum\" src=\"" + item.imgurl + "\" onerror=\"\"/></span></a>";
			output += "<div class=\"alt_1_detail\" style=\"height:50px;\">";
			output += "<a href=\"http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/newsDetail?artid=" + item.nsid + "\" class=\"alt_1_detail_link\"><B>";
			if (item.pcode == "0001") {
				output += "[강원일보]";
			} else if (item.pcode == "0002") {
				output += "[도민일보]";
			}
			output += "</B>" + item.title + "</a>";
			output += "</div><div class=\"viewCntPrt\"><p class=\"viewCnt\"><img src=\"./resources/images/eye_1.png\"/>" + item.uv + "</p></div></li>";
		}
		HashMap<String,String> articleMap = new HashMap<String,String>();
		articleMap.put("article", output);
		
		return gson.toJson(articleMap);
	}
	
	@RequestMapping(value="/mslifeList.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getMslifeList() {
		Gson gson = new Gson();
		List<ArticleVO>  msNewsList = lifeInfoService.getMslifeList();
		return gson.toJson(msNewsList);
	}
	
	@RequestMapping(value="/mainYoutube.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getMainYoutubeID() {
		Gson gson = new Gson();
		String youtubeID = lifeInfoService.getMainYoutubeID();
		return gson.toJson(youtubeID);
	}
	
	
	@RequestMapping(value="/getArticleNO.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getArticleNOJSON() {
		Gson gson = new Gson();
		int articleNO = lifeInfoService.getArticleNO();
		HashMap<String,Integer> articleNOMap = new HashMap<String,Integer>();
		articleNOMap.put("articleNO", articleNO);
		return gson.toJson(articleNOMap);
	}
	
	
	@RequestMapping(value="/moreNewsList.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getMoreNewsListJSON(SearchVO param, HttpServletRequest request, HttpServletResponse response, Model model) {
		Gson gson = new Gson();
		DataSet set = new DataSet();
		try {
	        int totalCnt = lifeInfoService.getMoreNewsToCnt(param);  //데이터의 전체 갯수를 가져온다.
	        
	        System.out.println("totalRow:" + totalCnt);
	        
	        int page = param.getPage();  //파라메터 page값을 받는다.
	        System.out.println("pageNO: " + page);
	        if (page==1){
	            param.setStartNum(0);
	            param.setEndNum(20);  //데이터를 20개씩 가져오겠다.
	        }else{
	            param.setStartNum(page+(19*(page-1)));  //10개씩 가져오고싶다면 19->9로 
	            param.setEndNum(20);   //20, 40, 60
	            
	        }
	        //위에서 구한, 데이터를 가져올 시작 rownum과 끝 rownum을 값을 같이 보낸다. 이 사이의 데이터를 조회
	        List<ArticleVO> list = lifeInfoService.getMoreNewsList(param);  //조회한 데이터를 가져온다.
	        System.out.println("listSize:" + list.size());
	       /* for (ArticleVO article : list) {
	        	System.out.println("article: " +article);
	        }*/
	        set.setRows(list);
	        set.setToCnt(totalCnt);
	        set.setStartNum(param.getStartNum());
	        set.setResultCode(200);
	      
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return gson.toJson(set);
	}
	
	@RequestMapping(value="/morekadoNewsList.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getMorekadoNewsListJSON(SearchVO param, HttpServletRequest request, HttpServletResponse response, Model model) {
		Gson gson = new Gson();
		DataSet set = new DataSet();
		try {
	        int totalCnt = lifeInfoService.getMorekadoNewsToCnt(param);  //데이터의 전체 갯수를 가져온다.
	        
	        System.out.println("totalRow:" + totalCnt);
	        
	        int page = param.getPage();  //파라메터 page값을 받는다.
	        System.out.println("pageNO: " + page);
	        if (page==1){
	            param.setStartNum(0);
	            param.setEndNum(20);  //데이터를 20개씩 가져오겠다.
	        }else{
	            param.setStartNum(page+(19*(page-1)));  //10개씩 가져오고싶다면 19->9로 
	            param.setEndNum(20);   //20, 40, 60
	            
	        }
	        //위에서 구한, 데이터를 가져올 시작 rownum과 끝 rownum을 값을 같이 보낸다. 이 사이의 데이터를 조회
	        List<ArticleVO> list = lifeInfoService.getMorekadoNewsList(param);  //조회한 데이터를 가져온다.
	        System.out.println("listSize:" + list.size());
	       /* for (ArticleVO article : list) {
	        	System.out.println("article: " +article);
	        }*/
	        set.setRows(list);
	        set.setToCnt(totalCnt);
	        set.setStartNum(param.getStartNum());
	        set.setResultCode(200);
	      
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return gson.toJson(set);
	}
	
	
	
	@RequestMapping(value="/oilInfo.json", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getOillINfo(Model model,@RequestParam String oilKind) {
		
		Gson gson = new Gson();
		Dset dataSet = new Dset();
		List<OilInfoVO> oilInfoList = oilInfoAPI.getOilInfoList(oilKind);

		dataSet.setList(oilInfoList);
		return gson.toJson(dataSet);
	}
	
	class Dset {
		
		private List<OilInfoVO> list;

		public List<OilInfoVO> getList() {
			return list;
		}

		public void setList(List<OilInfoVO> list) {
			this.list = list;
		}
		
	}
	
	
}
