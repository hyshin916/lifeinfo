package kr.co.mseshop.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import kr.co.mseshop.common.Constants;
import kr.co.mseshop.dao.LifeInfoDao;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.FestivalVO;
import kr.co.mseshop.model.NewsVO;
import kr.co.mseshop.model.PasswdResetVO;
import kr.co.mseshop.model.PositionInfraVO;
import kr.co.mseshop.model.SearchVO;
import kr.co.mseshop.service.LifeInfoService;
import kr.co.mseshop.util.NewsUtil;

@Configuration
@EnableAsync
@Service("lifeInfoService")
public class LifeInfoServiceImpl implements LifeInfoService {

	@Inject 
	LifeInfoDao lifeInfoDao;
	
	@SuppressWarnings("finally")
	@Override
	public String getResultParser() {

		String path = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?sidoName="
				+ Constants.WEATHER_SERVICE_LOCATION + "&pageNo=1&numOfRows=500&ServiceKey="
				+ Constants.WEATHER_SERVICE_KEY + "&ver=1.3";
		String miseValue = "";
		try {
			URL url = new URL(path);
			URLConnection uc;
			uc = url.openConnection();

			uc.setConnectTimeout(5000);
			uc.setReadTimeout(5000);

			/*
			 * uc.setDoOutput(true); //uc.setRequestProperty("shinid", "wow");
			 * 
			 * /*OutputStreamWriter osw = new OutputStreamWriter(uc.getOutputStream());
			 * osw.write(param); osw.flush();
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String value = null;
			StringBuffer buffer = new StringBuffer();
			while ((value = br.readLine()) != null) {
				buffer.append(value);
			}
			// System.out.println("buffer:" + buffer.toString());

			InputSource is = new InputSource(new StringReader(buffer.toString()));

			Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

			doc.getDocumentElement().normalize();
			NodeList descNode = doc.getElementsByTagName("item");

			Date date = new Date();
			SimpleDateFormat hour = new SimpleDateFormat("hh");
			String tempHour = hour.format(date);
			System.out.println("[HOUR] : " + hour.format(date));

		
			for (int i = 0; i < descNode.getLength(); i++) {

				for (Node node = descNode.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {

					if (i == 0) {
						if (node.getNodeName().equals("pm10Grade")) {
							System.out.println("pm10Grade : " + node.getTextContent());
							miseValue = node.getTextContent();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return miseValue;
		}

	}

	HashMap<String, Object> innerMap = new HashMap<String, Object>();

	@Override
	public void getMemNews(Model model, String newsID) {
		NewsUtil.getMemNews(innerMap, model, newsID);
	}

	@Override
	public void getFestival(Model model) {
		System.out.println("festival...");
		FestivalVO festivalVO = new FestivalVO();
		// String path =
		// "http://apis.data.go.kr/6420000/FstvlEventInfoProvdService/getFstvl?sigun=평창군&ServiceKey=57EN%2B%2BQ%2FuTy2tspztsoB6bsnxO%2FgkqpddOf4OSFZwROwjSFnaB94zTRV86WVxY%2B%2F81%2BgnarAMOivvOfD3ul7NQ%3D%3D";

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/6420000/FstvlEventInfoProvdService/getFstvl"); /* URL */
		try {
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
					+ "=57EN%2B%2BQ%2FuTy2tspztsoB6bsnxO%2FgkqpddOf4OSFZwROwjSFnaB94zTRV86WVxY%2B%2F81%2BgnarAMOivvOfD3ul7NQ%3D%3D");
			urlBuilder.append("&" + URLEncoder.encode("sigun", "UTF-8") + "=" + URLEncoder.encode("춘천시", "UTF-8")); /**/
			// urlBuilder.append("&" + URLEncoder.encode("cntntsId","UTF-8") + "=" +
			// URLEncoder.encode("1758", "UTF-8")); /**/
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} /* Service Key */

		try {
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection uc;
			uc = (HttpURLConnection) url.openConnection();
			uc.setRequestMethod("GET");
			uc.setConnectTimeout(30000);
			uc.setReadTimeout(30000);
			/*
			 * uc.setDoOutput(true); //uc.setRequestProperty("shinid", "wow");
			 * 
			 * /*OutputStreamWriter osw = new OutputStreamWriter(uc.getOutputStream());
			 * osw.write(param); osw.flush();
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String value = null;
			StringBuffer buffer = new StringBuffer();
			while ((value = br.readLine()) != null) {
				buffer.append(value);
			}
			System.out.println("buffer:" + buffer.toString());

			InputSource is = new InputSource(new StringReader(buffer.toString()));

			Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

			doc.getDocumentElement().normalize();
			NodeList descNode = doc.getElementsByTagName("item");
			List<FestivalVO> festivalList = new ArrayList<FestivalVO>();
			;
			for (int i = 0; i < descNode.getLength(); i++) {

				for (Node node = descNode.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
					if (node.getNodeName().equals("title")) {
						System.out.println("title: " + node.getTextContent());
						festivalVO.setTitle(node.getTextContent());
					} else if (node.getNodeName().equals("sigun")) {
						System.out.println("sigun: " + node.getTextContent());
						festivalVO.setSigun(node.getTextContent());
					} else if (node.getNodeName().equals("hmpg")) {
						System.out.println("hmpg: " + node.getTextContent());
						festivalVO.setHmpg(node.getTextContent());
					}
				}
				festivalList.add(festivalVO);
				System.out.println(festivalVO);
				festivalVO = new FestivalVO();
			}
			model.addAttribute("festivalList", festivalList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	HashMap<String, Object> positionMap = new HashMap<String, Object>();

	@Override
	public void getPositionInfra(Model model, String x, String y) {
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		/*
		 * System.out.println("X::" + newsVO.getValueX()); String x =
		 * newsVO.getValueX();
		 * 
		 * System.out.println("Y::" + newsVO.getValueY()); String y =
		 * newsVO.getValueY();
		 */

		PositionInfraVO positionInfraVO = new PositionInfraVO();

		String path = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList?ServiceKey=57EN%2B%2BQ%2FuTy2tspztsoB6bsnxO%2FgkqpddOf4OSFZwROwjSFnaB94zTRV86WVxY%2B%2F81%2BgnarAMOivvOfD3ul7NQ%3D%3D&mapX="
				+ x + "&mapY=" + y + "&radius=20000&listYN=Y&arrange=A&MobileOS=ETC&MobileApp=AppTest";

		try {
			URL url = new URL(path);
			URLConnection uc;
			uc = url.openConnection();

			uc.setConnectTimeout(30000);
			uc.setReadTimeout(30000);
			/*
			 * uc.setDoOutput(true); //uc.setRequestProperty("shinid", "wow");
			 * 
			 * /*OutputStreamWriter osw = new OutputStreamWriter(uc.getOutputStream());
			 * osw.write(param); osw.flush();
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String value = null;
			StringBuffer buffer = new StringBuffer();
			while ((value = br.readLine()) != null) {
				buffer.append(value);
			}
			// System.out.println("buffer:" + buffer.toString());

			InputSource is = new InputSource(new StringReader(buffer.toString()));

			Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

			doc.getDocumentElement().normalize();
			NodeList descNode = doc.getElementsByTagName("item");
			List<PositionInfraVO> positionList = new ArrayList<PositionInfraVO>();
			;
			for (int i = 0; i < descNode.getLength(); i++) {

				for (Node node = descNode.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
					if (node.getNodeName().equals("title")) {
						System.out.println("title: " + node.getTextContent());
						positionInfraVO.setTitle(node.getTextContent());
					} else if (node.getNodeName().equals("firstimage")) {
						System.out.println("firstimage: " + node.getTextContent());
						positionInfraVO.setDetailImg(node.getTextContent());
					} else if (node.getNodeName().equals("firstimage2")) {
						System.out.println("firstimage2: " + node.getTextContent());
						positionInfraVO.setThumbURL(node.getTextContent());
					} else if (node.getNodeName().equals("addr1")) {
						System.out.println("addr1: " + node.getTextContent());
						positionInfraVO.setAddress(node.getTextContent());
					} else if (node.getNodeName().equals("contentid")) {
						System.out.println("contentid: " + node.getTextContent());
						positionInfraVO.setContentid(node.getTextContent());
					}
				}
				positionList.add(positionInfraVO);
				System.out.println("positionInfraVO : " + positionInfraVO);
				positionMap.put(positionInfraVO.getContentid(), positionInfraVO);
				positionInfraVO = new PositionInfraVO();
			}
			model.addAttribute("positionList", positionList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getPositionDetail(Model model, String contentid) {
		System.out.println("##################");
		System.out.println("[contentid] : " + contentid);
		PositionInfraVO positionInfraVO = (PositionInfraVO) positionMap.get(contentid);
		System.out.println(positionInfraVO);
		System.out.println("##########################");
		model.addAttribute("PositionInfo", positionInfraVO);
	}


	@Override
	public ArticleVO getDetailView(String artid) {
		return lifeInfoDao.getDetailView(artid);
	}

	@Override
	public List<ArticleVO> getMoreNewsList(SearchVO param) {
		return lifeInfoDao.getMoreNewsList(param);
	}

	@Override
	public int getMoreNewsToCnt(SearchVO param) {
		return lifeInfoDao.getMoreNewsToCnt(param);
	}

	@Override
	public void updateDetailViewCnt(String artid) {
		lifeInfoDao.updateDetailViewCnt(artid);
	}

	@Override
	public int getArticleNO() {
		return lifeInfoDao.getArticleNO();
	}


	@Override
	public ArticleVO getMsDetailView(String artid) {
		return lifeInfoDao.getMsDetailView(artid);
	}


	@Override
	public void updateMsDetailViewCnt(String artid) {
		lifeInfoDao.updateMsDetailViewCnt(artid);
	}

	@Override
	public List<ArticleVO> getGetmallImpNewsList() {
		return lifeInfoDao.getImpNewsList(); // 주요뉴스;
	}

	@Override
	public List<ArticleVO> getNewsALL() {
		return lifeInfoDao.getNewsAllList();
	}

	@Override
	public List<ArticleVO> getImpNewsList() {
		return lifeInfoDao.getImpNewsList();
	}

	@Override
	public List<ArticleVO> getNewsList() {
		return lifeInfoDao.getNewsList();
	}

	@Override
	public List<ArticleVO> getMslifeList() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(format.format(date));
		String dateStr = format.format(date);
		return lifeInfoDao.getMSnewsList(dateStr);
	}

	@Override
	public String getMainYoutubeID() {
		return lifeInfoDao.getYoutubeID();
	}

	@Override
	public PasswdResetVO getUserInfo(String id) {
		return lifeInfoDao.getUserInfo(id);
	}


	@Override
	public void passwdUpdate(String id, String passwordHashed) {
		HashMap<String,String> updateMap = new HashMap<String,String>();
	
		System.out.println("ID:" + id + " :: passwd:  " + passwordHashed);
		updateMap.put("id", id);
		updateMap.put("passwd",passwordHashed);
		
		lifeInfoDao.passwdUpdate(updateMap);
	}

	@Override
	public List<ArticleVO> getLineNews() {
		return lifeInfoDao.getLineNews();
	}

	@Override
	public List<ArticleVO> getKadoNewsList() {
		return lifeInfoDao.getKadoNewsList();
	}

	@Override
	public int getMorekadoNewsToCnt(SearchVO param) {
		return lifeInfoDao.getMorekadoNewsToCnt(param);
	}

	@Override
	public List<ArticleVO> getMorekadoNewsList(SearchVO param) {
		return lifeInfoDao.getMorekadoNewsList(param);
	}




}
