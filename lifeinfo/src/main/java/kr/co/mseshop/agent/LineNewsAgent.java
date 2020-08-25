package kr.co.mseshop.agent;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import kr.co.mseshop.common.Constants;
import kr.co.mseshop.common.PathClass;


public class LineNewsAgent implements Runnable {

	boolean execute;
	int interval;

	public void setExecute(boolean execute, String interval) {
		this.execute = execute;
		if (interval != null) {
			this.interval = Integer.parseInt(interval);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		URLConnection uc = null;
		URL url = null;

		while (execute) {
			try {
				StringBuffer buff = new StringBuffer();
				Thread.sleep(this.interval);

				String path = "http://www.mstoday.co.kr/rss/autobox_data_46.xml";
				// String path = "http://192.168.0.13:8080/lifeinfo/resources/data.xml";
				url = new URL(path);
				uc = url.openConnection();

				uc.setConnectTimeout(30000);
				uc.setReadTimeout(30000);

				InputStreamReader isr = new InputStreamReader(uc.getInputStream());
				BufferedReader br = new BufferedReader(isr);

				String result = "";
				while ((result = br.readLine()) != null) {
					buff.append(result);
				}

				InputSource is = new InputSource(new StringReader(buff.toString()));
				Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
				doc.getDocumentElement().normalize();

				ArrayList<EndiArticleVO> lineNewsList = new ArrayList<EndiArticleVO>();
				EndiArticleVO articleVO = new EndiArticleVO();
				NodeList descNode = doc.getElementsByTagName("item");
				for (int i = 0; i < descNode.getLength(); i++) {
					for (Node node = descNode.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
						if (node.getNodeName().equals("title")) {
							System.out.println("[title]:"  +node.getTextContent());
							articleVO.setTitle(node.getTextContent());
						} else if (node.getNodeName().equals("link")) {
							articleVO.setLink(node.getTextContent());
						} else if (node.getNodeName().equals("description")) {
							articleVO.setDescription(node.getTextContent());
						} else if (node.getNodeName().equals("author")) {
							articleVO.setAuthor(node.getTextContent());
						} else if (node.getNodeName().equals("pubDate")) {
							articleVO.setPubDate(node.getTextContent());
						} else if (node.getNodeName().equals("image")) {
							articleVO.setImage(node.getTextContent());
						}
					}
					lineNewsList.add(articleVO);
					articleVO = new EndiArticleVO();
				}
				// 최상단 라인뉴스 START (js파일생성)
				StringBuffer localBuff = new StringBuffer();
				localBuff.append("document.write('");
				localBuff.append("<div><ul id=\"scroller\">");
				for (EndiArticleVO article : lineNewsList) {
					String title = article.getTitle().replace("'", "");

					localBuff.append("<li>");

					if (title.indexOf("[긴급]") != -1 || title.indexOf("[단독]") != -1) {
						title = "<span style=\"color:#FF0000;\"><B>" + title + "</B></span>";
					}
					localBuff.append(
							"<a href=\"http://www.mstoday.co.kr/" + article.getLink() + "\">" + title + "</a></li>");
				}
				localBuff.append("</ul></div>");
				//20.06.12(겟몰요청건) 
				localBuff.append("');");
				makeFile(localBuff, PathClass.getLine_news("js"));
				// 최상단 라인뉴스 END (js파일생성)
				
				// 최상단 라인뉴스 START (html파일생성)
				localBuff = new StringBuffer();
				localBuff.append("<div><ul id=\"scroller\">");
				for (EndiArticleVO article : lineNewsList) {
					String title = article.getTitle().replace("'", "");

					localBuff.append("<li>");

					if (title.indexOf("[긴급]") != -1 || title.indexOf("[단독]") != -1) {
						title = "<span style=\"color:#FF0000;\"><B>" + title + "</B></span>";
					}
					localBuff.append(
							"<a href=\"http://www.mstoday.co.kr/" + article.getLink() + "\">" + title + "</a></li>");
				}
				localBuff.append("</ul></div>");
				makeFile(localBuff, PathClass.getLine_news("html"));
				// 최상단 라인뉴스 END (html파일생성)
				
				// 최하단 생생정보 뉴스 (라인뉴스 중 4~8까지의 기사를 노출함) START (JS파일생성)
				StringBuffer localBuff1 = new StringBuffer();
				localBuff1.append("document.write('<link rel=\"stylesheet\" href=\"http://"+ Constants.HOST_DOMAIN +":8080/lifeinfo/resources/front/css/life_news.css\">");
				localBuff1.append("<div class=\"ms_nContent\">");
				localBuff1.append("<ul class=\"msitem-nlists\">");
				for (int i=4; i<8; i++) {
					localBuff1.append("<li class=\"nitem\">");
					localBuff1.append("<a href=\"http://www.mstoday.co.kr/" + lineNewsList.get(i).getLink() + "\">");
					localBuff1.append("<span class=\"img-nbox\">");
					localBuff1.append("<span class=\"img-nthumb\">");
					localBuff1.append("<span class=\"img-ncenter\">");
					localBuff1.append("<img src=\"" + lineNewsList.get(i).getImage() + "\">");
					localBuff1.append("</span>");
					localBuff1.append("</span>");
					localBuff1.append("</span>");
					localBuff1.append("<span class=\"item-ntxt\">");
					localBuff1.append("<span class=\"item-ndes\">");
					localBuff1.append(lineNewsList.get(i).getTitle().replace("'", ""));
					localBuff1.append("</span>");
					localBuff1.append("</span>");
					localBuff1.append("</a>");
					localBuff1.append("</li>");
				}
				localBuff1.append("</ul>");
				localBuff1.append("</div>");
				localBuff1.append("');");
				makeFile(localBuff1, PathClass.getMsNews("js"));
				// 최하단 생생정보 뉴스 (라인뉴스 중 4~8까지의 기사를 노출함) END (JS파일생성)
				
				// 최하단 생생정보 뉴스 (라인뉴스 중 4~8까지의 기사를 노출함) START (html파일생성)
				localBuff1 = new StringBuffer();
				localBuff1.append("<div class=\"ms_nContent\">");
				localBuff1.append("<ul class=\"msitem-nlists\">");
				for (int i=4; i<8; i++) {
					localBuff1.append("<li class=\"nitem\">");
					localBuff1.append("<a href=\"http://www.mstoday.co.kr/" + lineNewsList.get(i).getLink() + "\">");
					localBuff1.append("<span class=\"img-nbox\">");
					localBuff1.append("<span class=\"img-nthumb\">");
					localBuff1.append("<span class=\"img-ncenter\">");
					localBuff1.append("<img src=\"" + lineNewsList.get(i).getImage() + "\">");
					localBuff1.append("</span>");
					localBuff1.append("</span>");
					localBuff1.append("</span>");
					localBuff1.append("<span class=\"item-ntxt\">");
					localBuff1.append("<span class=\"item-ndes\">");
					localBuff1.append(lineNewsList.get(i).getTitle().replace("'", ""));
					localBuff1.append("</span>");
					localBuff1.append("</span>");
					localBuff1.append("</a>");
					localBuff1.append("</li>");
				}
				localBuff1.append("</ul>");
				localBuff1.append("</div>");
				makeFile(localBuff1, PathClass.getMsNews("html"));
				// 최하단 생생정보 뉴스 (라인뉴스 중 4~8까지의 기사를 노출함) END (html파일생성)
				
				// 메인 슬라이드 배너 안 뉴스 추가  (라인뉴스 중 1~4까지의 기사를 노출함) START (js파일생성)
				StringBuffer localBuff2 = new StringBuffer();
				localBuff2.append("document.write('");
				localBuff2.append("<ul class=\"article_box\" style=\"top:0px;\">");
				
				for (int i=0; i<4; i++) {
					localBuff2.append("<li>");
					localBuff2.append("<a href=\"http://www.mstoday.co.kr/" + lineNewsList.get(i).getLink() + "\">");
					localBuff2.append("<div class=\"box_img\">");
					localBuff2.append("<img src=\"" + lineNewsList.get(i).getImage() + "\">");
					localBuff2.append("</div>");
					localBuff2.append("<div class=\"box_text\">");
					localBuff2.append("<div class=\"txt_position\">");
					localBuff2.append("<h3>MS투데이</h3>");
					localBuff2.append("<div class=\"text_num\">" +lineNewsList.get(i).getTitle().replace("'", "") + "</div>");
					localBuff2.append("</div>");
					localBuff2.append("</div>");
					localBuff2.append("</a>");
					localBuff2.append("</li>");
				}
				localBuff2.append("</ul>");
				localBuff2.append("');");
				makeFile(localBuff2, PathClass.getMsNewsMainBanner("js"));
				// 메인 슬라이드 배너 안 뉴스 추가  (라인뉴스 중 1~4까지의 기사를 노출함) END (js파일생성)
				
				// 메인 슬라이드 배너 안 뉴스 추가  (라인뉴스 중 1~4까지의 기사를 노출함) START (html파일생성)
				localBuff2 = new StringBuffer();
				localBuff2.append("<ul class=\"article_box\" style=\"top:0px;\">");
				for (int i=0; i<4; i++) {
					localBuff2.append("<li>");
					localBuff2.append("<a href=\"http://www.mstoday.co.kr/" + lineNewsList.get(i).getLink() + "\">");
					localBuff2.append("<div class=\"box_img\">");
					localBuff2.append("<img src=\"" + lineNewsList.get(i).getImage() + "\">");
					localBuff2.append("</div>");
					localBuff2.append("<div class=\"box_text\">");
					localBuff2.append("<div class=\"txt_position\">");
					localBuff2.append("<h3>MS투데이</h3>");
					localBuff2.append("<div class=\"text_num\">" +lineNewsList.get(i).getTitle().replace("'", "") + "</div>");
					localBuff2.append("</div>");
					localBuff2.append("</div>");
					localBuff2.append("</a>");
					localBuff2.append("</li>");
				}
				localBuff2.append("</ul>");
				makeFile(localBuff2, PathClass.getMsNewsMainBanner("html"));
				// 메인 슬라이드 배너 안 뉴스 추가  (라인뉴스 중 1~4까지의 기사를 노출함) END (html파일생성)				
				
				br.close();
				isr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	/*		
			// 비욘드라이프
			try {
				StringBuffer buff = new StringBuffer();
				Thread.sleep(this.interval);

				String path = "http://www.mstoday.co.kr/rss/beyond.xml";
				// String path = "http://192.168.0.13:8080/lifeinfo/resources/data.xml";
				url = new URL(path);
				uc = url.openConnection();

				uc.setConnectTimeout(30000);
				uc.setReadTimeout(30000);

				InputStreamReader isr = new InputStreamReader(uc.getInputStream());
				BufferedReader br = new BufferedReader(isr);

				String result = "";
				while ((result = br.readLine()) != null) {
					buff.append(result);
				}

				InputSource is = new InputSource(new StringReader(buff.toString()));
				Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
				doc.getDocumentElement().normalize();

				ArrayList<EndiArticleVO> lineNewsList = new ArrayList<EndiArticleVO>();
				EndiArticleVO articleVO = new EndiArticleVO();
				NodeList descNode = doc.getElementsByTagName("item");
				for (int i = 0; i < descNode.getLength(); i++) {
					for (Node node = descNode.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
						if (node.getNodeName().equals("title")) {
							System.out.println("[title]:"  +node.getTextContent());
							articleVO.setTitle(node.getTextContent());
						} else if (node.getNodeName().equals("link")) {
							articleVO.setLink(node.getTextContent());
						} else if (node.getNodeName().equals("description")) {
							articleVO.setDescription(node.getTextContent());
						} else if (node.getNodeName().equals("author")) {
							articleVO.setAuthor(node.getTextContent());
						} else if (node.getNodeName().equals("pubDate")) {
							articleVO.setPubDate(node.getTextContent());
						} else if (node.getNodeName().equals("image")) {
							articleVO.setImage(node.getTextContent());
						}
					}
					lineNewsList.add(articleVO);
					articleVO = new EndiArticleVO();
				}
				StringBuffer localBuff = new StringBuffer();
				
				localBuff.append("document.write('<link rel=\"stylesheet\" href=\"http://"+ Constants.HOST_DOMAIN +":8080/lifeinfo/resources/middle/css/linenews_style.css\">");
				localBuff.append("<link href=\"https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap\" rel=\"stylesheet\">");
				//localBuff.append("<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>");
				localBuff.append("<script src=\"http://"+ Constants.HOST_DOMAIN +":8080/lifeinfo/resources/middle/js/linenews_script.js\"></script>");

				localBuff.append("<div class=\"linenews_wrap\">");
				localBuff.append("<div id=\"edd2\" style=\"visibility:hidden;opacity:0\">");
				localBuff.append("<ul class=\"box-flow2\">");
				for (EndiArticleVO article : lineNewsList) {
					String title = article.getTitle().replace("'", "");

					localBuff.append("<li>");
					localBuff.append("<a href=\"" + article.getLink() + "\">");
				    localBuff.append("<img src=\""+ article.getImage() + "\">");
				    
					localBuff.append(
							"<p>" + title + "</p></a></li>");
				}
				localBuff.append("</ul></div></div></div></div>');");
				makeFile(localBuff, PathClass.getBeyond_news());
				br.close();
				isr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 비욘드라이프
			
			// 뉴스 
			try {
				StringBuffer buff = new StringBuffer();
				Thread.sleep(this.interval);

				String path = "http://www.mstoday.co.kr/rss/multy.xml";
				// String path = "http://192.168.0.13:8080/lifeinfo/resources/data.xml";
				url = new URL(path);
				uc = url.openConnection();

				uc.setConnectTimeout(30000);
				uc.setReadTimeout(30000);

				InputStreamReader isr = new InputStreamReader(uc.getInputStream());
				BufferedReader br = new BufferedReader(isr);

				String result = "";
				while ((result = br.readLine()) != null) {
					buff.append(result);
				}

				InputSource is = new InputSource(new StringReader(buff.toString()));
				Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
				doc.getDocumentElement().normalize();

				ArrayList<EndiArticleVO> lineNewsList = new ArrayList<EndiArticleVO>();
				EndiArticleVO articleVO = new EndiArticleVO();
				NodeList descNode = doc.getElementsByTagName("item");
				for (int i = 0; i < descNode.getLength(); i++) {
					for (Node node = descNode.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
						if (node.getNodeName().equals("title")) {
							System.out.println("[title]:"  +node.getTextContent());
							articleVO.setTitle(node.getTextContent());
						} else if (node.getNodeName().equals("link")) {
							articleVO.setLink(node.getTextContent());
						} else if (node.getNodeName().equals("description")) {
							articleVO.setDescription(node.getTextContent());
						} else if (node.getNodeName().equals("author")) {
							articleVO.setAuthor(node.getTextContent());
						} else if (node.getNodeName().equals("pubDate")) {
							articleVO.setPubDate(node.getTextContent());
						} else if (node.getNodeName().equals("image")) {
							articleVO.setImage(node.getTextContent());
						}
					}
					lineNewsList.add(articleVO);
					articleVO = new EndiArticleVO();
				}
				StringBuffer localBuff = new StringBuffer();
				

				localBuff.append("document.write('<div class=\"linenews_wrap\">");
				localBuff.append("<div id=\"edd3\" style=\"visibility:hidden;opacity:0\">");
				localBuff.append("<ul class=\"box-flow3\">");
				for (EndiArticleVO article : lineNewsList) {
					String title = article.getTitle().replace("'", "");

					localBuff.append("<li>");
					localBuff.append("<a href=\"" + article.getLink() + "\">");
				    localBuff.append("<img src=\""+ article.getImage() + "\">");
				    
					localBuff.append(
							"<p>" + title + "</p></a></li>");
				}
				localBuff.append("</ul></div></div></div></div>');");
				makeFile(localBuff, PathClass.getMulty_news());
				br.close();
				isr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
				// 뉴스 
			// 생생정보
						try {
							StringBuffer buff = new StringBuffer();
							Thread.sleep(this.interval);

							String path = "http://www.mstoday.co.kr/rss/economy_tip.xml";
							// String path = "http://192.168.0.13:8080/lifeinfo/resources/data.xml";
							url = new URL(path);
							uc = url.openConnection();

							uc.setConnectTimeout(30000);
							uc.setReadTimeout(30000);

							InputStreamReader isr = new InputStreamReader(uc.getInputStream());
							BufferedReader br = new BufferedReader(isr);

							String result = "";
							while ((result = br.readLine()) != null) {
								buff.append(result);
							}

							InputSource is = new InputSource(new StringReader(buff.toString()));
							Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
							doc.getDocumentElement().normalize();

							ArrayList<EndiArticleVO> lineNewsList = new ArrayList<EndiArticleVO>();
							EndiArticleVO articleVO = new EndiArticleVO();
							NodeList descNode = doc.getElementsByTagName("item");
							for (int i = 0; i < descNode.getLength(); i++) {
								for (Node node = descNode.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
									if (node.getNodeName().equals("title")) {
										System.out.println("[title]:"  +node.getTextContent());
										articleVO.setTitle(node.getTextContent());
									} else if (node.getNodeName().equals("link")) {
										articleVO.setLink(node.getTextContent());
									} else if (node.getNodeName().equals("description")) {
										articleVO.setDescription(node.getTextContent());
									} else if (node.getNodeName().equals("author")) {
										articleVO.setAuthor(node.getTextContent());
									} else if (node.getNodeName().equals("pubDate")) {
										articleVO.setPubDate(node.getTextContent());
									} else if (node.getNodeName().equals("image")) {
										articleVO.setImage(node.getTextContent());
									}
								}
								lineNewsList.add(articleVO);
								articleVO = new EndiArticleVO();
							}
							StringBuffer localBuff = new StringBuffer();
							

							localBuff.append("document.write('<div class=\"linenews_wrap\">");
							localBuff.append("<div id=\"edd4\" style=\"visibility:hidden;opacity:0\">");
							localBuff.append("<ul class=\"box-flow4\">");
							for (EndiArticleVO article : lineNewsList) {
								String title = article.getTitle().replace("'", "");

								localBuff.append("<li>");
								localBuff.append("<a href=\"" + article.getLink() + "\">");
							    localBuff.append("<img src=\""+ article.getImage() + "\">");
							    
								localBuff.append(
										"<p>" + title + "</p></a></li>");
							}
							localBuff.append("</ul></div></div></div></div>');");
							makeFile(localBuff, PathClass.getReal_news());
							br.close();
							isr.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// 생생정보
						*/
		} //while
	}

	private void makeFile(StringBuffer buff, String path) {
		try {
			FileOutputStream out = new FileOutputStream(path);
			out.write(buff.toString().getBytes());
			out.flush();
			out.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		

	}

	private class EndiArticleVO {
		private String title;
		private String link;
		private String description;
		private String author;
		private String pubDate;
		private String image;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPubDate() {
			return pubDate;
		}

		public void setPubDate(String pubDate) {
			this.pubDate = pubDate;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

	}

}
