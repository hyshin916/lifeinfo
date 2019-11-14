package kr.co.mseshop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.mseshop.dao.CrawlDao;
import kr.co.mseshop.model.CrawlInfoVO;
import kr.co.mseshop.model.MadeCategoryCodeVO;
import kr.co.mseshop.model.RefindDataVO;
import kr.co.mseshop.model.SearchDataVO;
import kr.co.mseshop.server.Constants;
import kr.co.mseshop.server.GoogleTranslate;
import kr.co.mseshop.service.CrawlService;

@Service("crawlService")
public class CrawlServiceImpl implements CrawlService {

	@Resource(name = "crawlDao")
	private CrawlDao crawlDao;

	ArrayList<RefindDataVO> cashDBList = new ArrayList<RefindDataVO>();

	public class CashDBInsert implements Runnable {
		List<CrawlInfoVO> lists;

		GoogleTranslate googleTranslate;
		int sum;
		String detailInfo2;
	
		public CashDBInsert(List<CrawlInfoVO> lists) {
			this.lists = lists;
		}

		
		public String convertColor1(String str) {

			String temp = str.replace("##","");
			return "N01" + " " + temp ;
		}
		
		
		public void convertColor(CrawlInfoVO list, String flag) {
			
			String[] temp2 = null;
			
			if (flag.equals("GETColor")) {
				temp2 = list.getColor().split("##");
				System.out.println("tempSize:" + temp2.length);
			} else if (flag.equals("GETSize")) {
				temp2 = list.getSize().split("##");
			} else if (flag.equals("GETOption")) {
				temp2 = list.getIncreOptionValue().split("##");
			}
			String temp5 = "";
			int cntt = 1;
			
		    detailInfo2 = "<hr><p>Color View</p>";

			for (int i = 0; i < temp2.length; i++) {
				System.out.println("temp2실행여부:yes");
				String[] temp3 = temp2[i].split("::");
				String cutStr = "";
				 if (Constants.GTRANSLATEYN.equals("Y")) {
						cutStr = googleTranslate.getGoogleTranslate(temp3[0]);
				 } else {
					 cutStr = temp3[0];
				 }
			
				
				String translateStr = "";
				if (cutStr.length()>21) {
					translateStr = cutStr.substring(0,21);
				} else {
					translateStr = cutStr;
				}
				
				sum += temp3[0].length();
				String str = String.format("%02d", cntt);

				
				
				temp5 += "N" + str + " " +translateStr + ",";
				if (temp3.length != 1) {
					detailInfo2 += "<br/><center><b><div style='font-size:20px; color:black;'>" + "N" + str + " "
							+ translateStr + "</div></b></center><br/><img src=\"" + temp3[1] + "\"/><br/>";
				} else {
					if (!translateStr.equals("noContent")) {
						detailInfo2 += "<br/><center><b><div style='font-size:20px; color:black;'>" + "N" + str + " "
								+ translateStr + "</div></b></center><br/>";
					}
				}
				cntt++;
			} // for

			int d = temp5.lastIndexOf(",");
			if (d != -1) {
				String e = temp5.substring(0, d);
				System.out.println("E:" + e);
				list.setColor(e);
			}
			
		}
		public String convertOption(String value) {
			int a = value.lastIndexOf("::");
			String temp = value.substring(0, a);
			String convertSize = temp.replace("::", ",");
			String[] conArr = convertSize.split(",");
			String temp1 = "";
			int cnt = 1;

			for (String v : conArr) {
				sum += v.length();
				String cutStr = "";
				if (Constants.GTRANSLATEYN.equals("Y")) {
					cutStr = googleTranslate.getGoogleTranslate(v);
				} else {
					cutStr = v;
				}

				if (cutStr.equals("남")) {
					cutStr = "M";
				} else if (cutStr.indexOf("명") != -1) {
					int c = cutStr.indexOf("명");
					cutStr = cutStr.substring(0, c);
				} else if (cutStr.indexOf("세") != -1) {
					int c = cutStr.indexOf("세");
					cutStr = cutStr.substring(0, c);
				}
				String t = "";
				if (cutStr.length() > 21) {
					t = cutStr.substring(0, 21);
				} else {
					t = cutStr;
				}
				String str = String.format("%02d", cnt);
				if (cnt == conArr.length) {
					temp1 += "N" + str + " " + t;
				} else {
					temp1 += "N" + str + " " + t + ",";
				}
				cnt++;
			}
			return temp1;
		}
		
		public void run() {
			try {
				System.out.println("DB 정제 START");
				System.out.println("========================REFIND_TBL INSERT START========================");
				System.out.println("listSize::" + lists.size());
				for (CrawlInfoVO list : lists) {

					System.out.println("toString:" + list.toString());

					RefindDataVO refindVo = new RefindDataVO();
					refindVo.setProductStatus(Constants.PRODUCT_STATUS);

					refindVo.setProductName(list.getCategory() + "-S" + list.getNo());

					refindVo.setSellingPrice(list.getProPrice());
					refindVo.setInventoryQuantity(Constants.INVENTORY_QUANTITY);
					refindVo.setAsInfo(Constants.AS_INFO);
					refindVo.setAsTel(Constants.AS_TEL);
					refindVo.setThumbImg(list.getThumbfileName());
					// refindVo.setDetailInfo(list.getBodyImgURL()); // 변환저장 해야 함.

					String tempbodyImgURL = list.getBodyImgURL();

					String[] bodyImgURL = tempbodyImgURL.split(",");
					String detailInfo = "<img src=\"https://shop-phinf.pstatic.net/20190117_30/101388418_1547701852645AR9bX_JPEG/KakaoTalk_20190117_112524760.jpg\">";
					detailInfo += "<hr><p>Detail View</p>";
					for (String bodyImg : bodyImgURL) {
						if (!bodyImg.equals("")) {
							detailInfo += "<img align=\"absmiddle\" src=\"" + bodyImg + "\"" + "/><br/>" + "\n";
						}
					}

					refindVo.setSellingCode("S" + list.getNo());
					refindVo.setSurTax(Constants.SURTAX);
					refindVo.setMinorsPurchase(Constants.MINORS_PURCHASE);
					refindVo.setPurchaseStatus(Constants.PURCHASESTATUS);
					refindVo.setOriginCode(Constants.ORIGIN_CODE);
					refindVo.setImportedCompany(Constants.IMPORTED_COMPANY);
					refindVo.setRedundantOrigin(Constants.REDUNDANT_ORIGIN);
					refindVo.setDeliveryMethod(Constants.DELIVERY_METHOD);
					refindVo.setDeliveryType(Constants.DELIVERY_TYPE);
					refindVo.setDeliveryPayMethod(Constants.DELIVERY_PAY_METHOD);
					refindVo.setReturnShippCost(Constants.RETURN_SHIPP_COST);
					refindVo.setExchangeCost(Constants.EXCHANGE_COST);
					refindVo.setInstallCost(Constants.INSTALL_COST);
					refindVo.setSellerItems(Constants.SELLING_ITEMS);
					refindVo.setOptionalType(Constants.OPTIONAL_TYPE);

					googleTranslate = new GoogleTranslate();
					String optionName = "";
					sum += list.getOptionName().length();
					if (Constants.GTRANSLATEYN.equals("Y")) {
						optionName = googleTranslate.getGoogleTranslate(list.getOptionName());
						optionName = optionName.replace(",", "\n");
					} else {
						optionName = list.getOptionName().replace(",","\n");
					}
					refindVo.setOptionName(optionName);

					String flag = "GETColor";
					String conColor = "";
					if (list.getSize().indexOf("http://") != -1 && list.getColor().equals("noContent")
							&& list.getIncreOptionValue().equals("N")) {
						flag = "GETSize";
						convertColor(list, flag);
						list.setSize(list.getColor());
						// list.setColor("");
						conColor = "";
					} else if (list.getSize().indexOf("http://") != -1 && !list.getColor().equals("noContent")
							&& list.getIncreOptionValue().equals("N")) {
						// list.setColor(list.getColor()); // 원시데이터
						conColor = convertColor1(list.getColor());
						flag = "GETSize";
						convertColor(list, flag);
						list.setSize(list.getColor());

					} else if (!(list.getSize().indexOf("::") != -1) && !list.getColor().equals("noContent")
							&& list.getIncreOptionValue().equals("N")) {
						convertColor(list, flag);
						list.setSize(list.getColor());
						// list.setColor("");
						conColor = "";
					} else if (!list.getSize().equals("") && !list.getColor().equals("noContent")
							&& !list.getIncreOptionValue().equals("N")) {

						try {
							list.setSize(convertOption(list.getSize()));
							convertColor(list, "GETColor");
							conColor = list.getColor();
							convertColor(list, "GETOption");
							conColor += "\n" + list.getColor();
						} catch (Exception e) {
							continue;
						}

					}else {
						System.out.println("ElSE...");
						if (list.getSize().lastIndexOf("::") != -1) {
							int a = list.getSize().lastIndexOf("::");
							String temp = list.getSize().substring(0, a);
							String convertSize = temp.replace("::", ",");
							String[] conArr = convertSize.split(",");
							String temp1 = "";
							int cnt = 1;

							for (String v : conArr) {
								String compareSizeColor = list.getColor();
								if (v.indexOf(compareSizeColor)!=-1) {
									list.setSize("");
								}
								sum += v.length();
								String cutStr = "";
								if (Constants.GTRANSLATEYN.equals("Y")) {
									cutStr = googleTranslate.getGoogleTranslate(v);
								} else {
									cutStr = v;
								}

								if (cutStr.equals("남")) {
									cutStr = "M";
								} else if (cutStr.indexOf("명") != -1) {
									int c = cutStr.indexOf("명");
									cutStr = cutStr.substring(0, c);
								} else if (cutStr.indexOf("세") != -1) {
									int c = cutStr.indexOf("세");
									cutStr = cutStr.substring(0, c);
								}
								String t = "";
								if (cutStr.length() > 21) {
									t = cutStr.substring(0, 21);
								} else {
									t = cutStr;
								}
								String str = String.format("%02d", cnt);
								if (cnt == conArr.length) {
									temp1 += "N" + str + " " + t;
								} else {
									temp1 += "N" + str + " " + t + ",";
								}
								cnt++;
							}
							list.setSize(temp1);
							convertColor(list, flag);
							conColor = list.getColor();
						} else {
							continue;
						}
					}

					detailInfo2 += "<img src=\"https://shop-phinf.pstatic.net/20180601_130/showindowCommon_1527824349847o05fA_PNG/67643981763274193_-1493075776.png?type=w860\">";
					refindVo.setStrLength(Integer.toString(sum));
					refindVo.setDetailInfo(detailInfo + "\n" + detailInfo2); // 변환저장 해야 함.

					String tempColor = "";
					if (!list.getColor().equals("")) {
						if (!list.getSize().equals("") && !list.getColor().equals("N01 noContent")) {
							tempColor = "\n" + conColor + "\n";
						} else if (list.getSize().equals("") && !list.getColor().equals("N01 noContent")) {
							System.out.println("Test..test...");
							tempColor = conColor + "\n";
						}
					}

					refindVo.setOptionValue(list.getSize() + tempColor);
					refindVo.setMemberStatus(Constants.MEMBER_STATUS);

					// cashDBList.add(refindVo);
					crawlDao.insert(refindVo);
					sum = 0;
				} // for
		
				System.out.println("========================REFIND_TBL INSERT END========================");
				System.out.println("DB 정제 END");
				crawlDao.deleteRefind();
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		}
	}

	@Override
	public List<CrawlInfoVO> list() {

		List<CrawlInfoVO> lists = crawlDao.list();
		return lists;
	}

	@Override
	public List<String> getViewlist(String no) {
		return crawlDao.getViewlist(no);
	}

	/*
	 * public List<String> viewList(CrawlInfoVO lists) {
	 * 
	 * ArrayList<String> arr = new ArrayList<String>(); String tempbodyImgURL =
	 * lists.getBodyImgURL();
	 * 
	 * String[] bodyImgURL = tempbodyImgURL.split(",");
	 * 
	 * for (String bodyImg : bodyImgURL) { String temp =
	 * "<img align=\"absmiddle\" src=\"" + bodyImg + "\"" +"/><br/>"; arr.add(temp);
	 * }
	 * 
	 * return arr;
	 * 
	 * }
	 * 
	 * public List<ColorInfo> colorList(CrawlInfoVO lists) { String tempColor =
	 * lists.getColor(); String[] color = tempColor.split(","); List<ColorInfo>
	 * colorList = new ArrayList<ColorInfo>(); ColorInfo info = null; for (int i =
	 * 0; i < color.length; i++) { info = new ColorInfo(); String[] temp =
	 * color[i].split("::");
	 * info.setColorName("<br/><b><div style='font-size:25px; color:brown;'>"
	 * +temp[0] +"</div></b>"); info.setColorURL("<br/><img src=\"" +temp[1] +
	 * "\"/><br/>"); colorList.add(info); } return colorList; }
	 */
	@Override
	public List<String> codeList() {
		return crawlDao.codeList();
	}

	@Override
	public List<String> categoryList(String param) {
		List<String> lists = crawlDao.categoryList(param);
		ArrayList<String> arr = new ArrayList<String>();
		for (String list : lists) {
			arr.add(list + ",");
		}
		return arr;
	}

	@Override
	public List<String> categoryListSmall(String param) {
		List<String> lists = crawlDao.categoryListSmall(param);
		ArrayList<String> arr = new ArrayList<String>();
		for (String list : lists) {
			arr.add(list + ",");
		}
		return arr;
	}

	@Override
	public String getLastCode(MadeCategoryCodeVO codeVo) {
		return crawlDao.getLastCode(codeVo);
	}

	@Override
	public List<String> categoryListDetailView(String param) {
		List<String> lists = crawlDao.categoryListDetailView(param);
		ArrayList<String> arr = new ArrayList<String>();
		for (String list : lists) {
			arr.add(list + ",");
		}
		return arr;

	}

	@Override
	public void updateRefindInfo(RefindDataVO refindVO) {
		crawlDao.updateRefindInfo(refindVO);
	}

	@Override
	public List<RefindDataVO> getExportData() {
		return crawlDao.getExportData();
	}


	@Override
	public List<RefindDataVO> getRefindData() {
		return crawlDao.getRefindData();
	}

	@Override
	public void madeExcelData(Map<String, String> exportExcelParam) {
			System.out.println("excel...services....");
			crawlDao.insertExcelData(exportExcelParam);
	}

	@Override
	public List<CrawlInfoVO> searchList(SearchDataVO searchVO) {
		return crawlDao.searchList(searchVO);
	}

	@Override
	public void deleteExcelData() {
		crawlDao.deleteExcelData();
	}

	@Override
	public List<CrawlInfoVO> searchListCode(SearchDataVO searchVO) {
		return crawlDao.searchListCode(searchVO);
	}

	@Override
	public void refinddata() {
		List<CrawlInfoVO> lists = crawlDao.refindList();

		int refindDBchk = crawlDao.dbInsertChk(); // refind_tbl 정제 DB에 데이터 있는지 체크 확인
		if (refindDBchk == 0) {
			CashDBInsert cashDBInsert = new CashDBInsert(lists);
			Thread cashThread = new Thread(cashDBInsert, "cashDB-Thread");
			cashThread.start();
		}
	}

	@Override
	public List<Object> testpro(Map<String, Object> param) {
		return crawlDao.testpro(param);
	}

}
