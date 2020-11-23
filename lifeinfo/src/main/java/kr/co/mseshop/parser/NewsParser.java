package kr.co.mseshop.parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import kr.co.mseshop.agent.PressCode;
import kr.co.mseshop.common.AbstractCommon;
import kr.co.mseshop.common.Constants;
import kr.co.mseshop.model.ArticleVO;

@SuppressWarnings("rawtypes")
public class NewsParser extends AbstractCommon {

	static String url = "jdbc:log4jdbc:mysql://183.111.169.187:3306/msmartlife?autoReconnect=true&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
	static String user = "msmartlife";
	static String password = "!msmartlife987!";

	
	
	static {
		try {
			Class.forName("net.sf.log4jdbc.DriverSpy");
			System.out.println("JDBC Driver loading SUCCESS...");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void standAloneDBConnection(ArticleVO articleVO) {
	
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			 con = DriverManager.getConnection(url, user, password);
			 
				if (articleVO.getPress().trim().equals("강원일보")) {
					articleVO.setPcode(PressCode.NEWS_CODE_KWNEWS);
				} else if (articleVO.getPress().trim().equals("강원도민일보")) {
					articleVO.setPcode(PressCode.NEWS_CODE_DOMIN);
				}
				
				if (articleVO.getAction().trim().equals("U")) {
					System.out.println("[Update Article]");
					String query = "UPDATE msmartlife.article_tbl SET action = ?,title = ?,content = ?,author = ?,date = ? WHERE nsid = ?;"; 
					
						psmt = con.prepareStatement(query);
						psmt.setString(1, articleVO.getAction());
						psmt.setString(2, articleVO.getTitle());
						psmt.setString(3, articleVO.getContent());
						psmt.setString(4, articleVO.getAuthor());
						psmt.setString(5, articleVO.getDate());
						psmt.setString(6, articleVO.getNsid());
						psmt.execute();
						
				} else  if (articleVO.getAction().trim().equals("I")) {
					String query = "INSERT INTO msmartlife.article_tbl(nsid,pcode,action,title,content,author,catecode,citycode,imgurl,caption_content,caption_title,pc_url,m_url,app_url,date,viewYN)"
							+ "	VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'Y')";
			
						psmt = con.prepareStatement(query);
						psmt.setString(1, articleVO.getNsid());
						psmt.setString(2, articleVO.getPcode());
						psmt.setString(3, articleVO.getAction());
						psmt.setString(4, articleVO.getTitle());
						
						
						psmt.setString(5, articleVO.getContent());
						psmt.setString(6, articleVO.getAuthor());
						psmt.setString(7, articleVO.getCatecode());
						psmt.setString(8, articleVO.getCitycode());
						psmt.setString(9, articleVO.getImgurl());
						psmt.setString(10, articleVO.getCaption_content());
						psmt.setString(11, articleVO.getCaption_title());
						psmt.setString(12, articleVO.getPc_url());
						psmt.setString(13, articleVO.getM_url());
						psmt.setString(14, articleVO.getApp_url());
						psmt.setString(15, articleVO.getDate());
						psmt.execute();
				
				} else if (articleVO.getAction().trim().equals("D")) {
					System.out.println("[Disable Article]");
					String query = "UPDATE msmartlife.article_tbl SET viewYN = 'N' WHERE nsid = ?;"; 
					
						psmt = con.prepareStatement(query);
						psmt.setString(1, articleVO.getNsid());
						psmt.execute();
					
				} 
			 
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try { if(psmt!=null) {psmt.close();}} catch(Exception e) {};
			try { if(con!=null) {con.close();}} catch(Exception e) {};
		}
	
	}

	public static NewsParser instance;

	boolean dbParsing = false;

	public void setDBParseMode(boolean flag) {
		this.dbParsing = flag;
	}

	public static NewsParser getInstance(Model model, ArticleVO articleVO) {

		instance = new NewsParser(model, "NEWS PARSER", articleVO, Constants.NEWS_METHOD);

		return instance;
	}

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	public NewsParser(Model model, String viewName, Object obj, String newsMethod) {
		super(model, viewName, obj, newsMethod);
	}

	public NewsParser(String mode, ArticleVO articleVO) {
		super(mode, articleVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void createXML() {
		logger.info("[News XML make ... ]");

		NodeList descNode = doc.getElementsByTagName("item");
		for (int i = 0; i < descNode.getLength(); i++) {

			for (Node node = descNode.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
				if (node.getNodeName().equals("title")) {
					System.out.println("title: " + node.getTextContent());
					((ArticleVO) obj).setTitle(node.getTextContent().replace("&quot;", ""));
				} else if (node.getNodeName().equals("press")) {
					System.out.println("press: " + node.getTextContent());
					((ArticleVO) obj).setPress(node.getTextContent());
				} else if (node.getNodeName().equals("nsid")) {
					System.out.println("nsid: " + node.getTextContent());
					((ArticleVO) obj).setNsid(node.getTextContent());
				} else if (node.getNodeName().equals("action")) {
					System.out.println("action: " + node.getTextContent());
					((ArticleVO) obj).setAction(node.getTextContent());
				} else if (node.getNodeName().equals("date")) {
					System.out.println("date: " + node.getTextContent());
					((ArticleVO) obj).setDate(node.getTextContent());
				} else if (node.getNodeName().equals("author")) {
					System.out.println("author: " + node.getTextContent());
					((ArticleVO) obj).setAuthor(node.getTextContent());
				} else if (node.getNodeName().equals("content")) {
					System.out.println("content: " + node.getTextContent());
					((ArticleVO) obj).setContent(convertStr(node.getTextContent()));
				} else if (node.getNodeName().equals("category")) {
					System.out.println("category code: " + node.getAttributes().getNamedItem("code").getTextContent());
					((ArticleVO) obj).setCatecode(node.getAttributes().getNamedItem("code").getTextContent());
				} else if (node.getNodeName().equals("city")) {
					System.out.println("city code: " + node.getAttributes().getNamedItem("code").getTextContent());
					((ArticleVO) obj).setCitycode(node.getAttributes().getNamedItem("code").getTextContent());
				} else if (node.getNodeName().equals("murl")) {
					System.out.println("M URL: " + node.getAttributes().getNamedItem("href").getTextContent());
					((ArticleVO) obj).setM_url(node.getAttributes().getNamedItem("href").getTextContent());
				} else if (node.getNodeName().equals("image")) {
					System.out.println("DetailImageURL: " + node.getAttributes().getNamedItem("href").getTextContent());
					((ArticleVO) obj).setImgurl(node.getAttributes().getNamedItem("href").getTextContent());
					
					if (((ArticleVO) obj).getPress().trim().equals("강원일보")) {
						((ArticleVO) obj)
						.setCaption_title(node.getAttributes().getNamedItem("caption_title").getTextContent());
				((ArticleVO) obj)
						.setCaption_content(node.getAttributes().getNamedItem("caption_content").getTextContent());
					} else if (((ArticleVO) obj).getPress().trim().equals("강원도민일보"))	{
						((ArticleVO) obj)
						.setCaption_title(node.getAttributes().getNamedItem("caption").getTextContent());
					}
					
				} else if (node.getNodeName().equals("url")) {
					System.out.println("PC URL: " + node.getAttributes().getNamedItem("href").getTextContent());
					((ArticleVO) obj).setPc_url(node.getAttributes().getNamedItem("href").getTextContent());
				} else if (node.getNodeName().equals("appurl")) {
					System.out.println("app URL: " + node.getAttributes().getNamedItem("href").getTextContent());
					((ArticleVO) obj).setApp_url(node.getAttributes().getNamedItem("href").getTextContent());
				}
			}
		}

		ArticleVO articleVO = (ArticleVO) obj;
		
		if (dbParsing) {
			standAloneDBConnection(articleVO);
			obj = new ArticleVO();
		} else {
			objList.add((ArticleVO) obj);
			obj = new ArticleVO();
			modelAdd();
		}

	}
	public boolean chkStr(String a) {
		
		boolean result = false;
		try {
			
			Double d = Double.parseDouble(a);
			result = true;
			
		} catch (Exception e) {
			
			result = false;
		
		}
		
		return result;
	
	}	

	private String convertStr(String str) {

		if (!(str == null || str.equals("")) && str.length()>20) {
			StringBuffer sb = new StringBuffer();
			String cvtStr = str.replace("<br><br>", ".");

			for (int i = 0; i < cvtStr.length() - 20; i++) {

				if ('.' == cvtStr.charAt(i)) {
					if (chkStr(String.valueOf(cvtStr.charAt(i - 1))) == true
							&& chkStr(String.valueOf(cvtStr.charAt(i + 1))) == true) {
						sb.append(cvtStr.charAt(i));
					} else {
						if (cvtStr.charAt(i + 1) == '\"' || cvtStr.charAt(i + 1) == '”') {
							sb.append(cvtStr.charAt(i));
						} else {
							sb.append(".<br><br>");
						}
					}
				} else {
					sb.append(cvtStr.charAt(i));
				}
			}
			return sb.toString() + cvtStr.substring(cvtStr.length() - 20, cvtStr.length());
		} else {
			return "";
		}
	}


	private void modelAdd() {
		model.addAttribute("newsList", objList);
	}

}
