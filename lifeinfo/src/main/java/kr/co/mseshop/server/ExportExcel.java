package kr.co.mseshop.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import kr.co.mseshop.model.RefindDataVO;

public class ExportExcel {

	public void start(List<RefindDataVO> lists) {
		// Workbook 생성
		Workbook xlsWb = new HSSFWorkbook(); // Excel 2007 이전 버전
	//	Workbook xlsxWb = new XSSFWorkbook(); // Excel 2007 이상

		// *** Sheet-------------------------------------------------
		// Sheet 생성
		Sheet sheet1 = xlsWb.createSheet("naver_farm");

		// 컬럼 너비 설정
		sheet1.setColumnWidth(0, 10000);
		sheet1.setColumnWidth(9, 10000);
		// ----------------------------------------------------------

		// *** Style--------------------------------------------------
		// Cell 스타일 생성
		CellStyle cellStyle = xlsWb.createCellStyle();

		// 줄 바꿈
		cellStyle.setWrapText(true);

		// Cell 색깔, 무늬 채우기
		cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

		Row row = null;
		Cell cell = null;
		// ----------------------------------------------------------

		// 첫 번째 줄
		row = sheet1.createRow(0);

		// 첫 번째 줄에 Cell 설정하기-------------
		cell = row.createCell(0);
		cell.setCellValue("상품상태");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용

		cell = row.createCell(1);
		cell.setCellValue("카테고리ID");
		cell.setCellStyle(cellStyle);

		cell = row.createCell(2);
		cell.setCellValue("상품명");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용

		cell = row.createCell(3);
		cell.setCellValue("판매가");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(4);
		cell.setCellValue("재고수량");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(5);
		cell.setCellValue("AS안내내용");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(6);
		cell.setCellValue("AS전화번호");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(7);
		cell.setCellValue("대표이미지파일명");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(8);
		cell.setCellValue("추가이미지파일명");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(9);
		cell.setCellValue("상품상세정보");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(10);
		cell.setCellValue("판매자상품코드");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(11);
		cell.setCellValue("판매자바코드");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(12);
		cell.setCellValue("제조사");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(13);
		cell.setCellValue("브랜드");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(14);
		cell.setCellValue("제조일자");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(15);
		cell.setCellValue("유효일자");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(16);
		cell.setCellValue("부가세");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(17);
		cell.setCellValue("미성년자구매");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(18);
		cell.setCellValue("구매평노출여부");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(19);
		cell.setCellValue("원산지코드");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(20);
		cell.setCellValue("수입사");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(21);
		cell.setCellValue("복수원산지여부");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(22);
		cell.setCellValue("원산지직접입력");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(23);
		cell.setCellValue("배송방법");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(24);
		cell.setCellValue("배송비유형");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(25);
		cell.setCellValue("기본배송비");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(26);
		cell.setCellValue("배송비결제방식");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(27);
		cell.setCellValue("조건부 무료 - 상품 판매가 합계");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용

		cell = row.createCell(28);
		cell.setCellValue("수량별 부과 수량");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(29);
		cell.setCellValue("반품배송비");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(30);
		cell.setCellValue("교환배송비");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(31);
		cell.setCellValue("지역별차등배송비정보");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(32);
		cell.setCellValue("별도설치비");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(33);
		cell.setCellValue("판매자특이사항");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(34);
		cell.setCellValue("즉시할인값");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(35);
		cell.setCellValue("즉시할인단위");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(36);
		cell.setCellValue("복수구매할인조건값");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(37);
		cell.setCellValue("복수구매할인조건단위");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(38);
		cell.setCellValue("복수구매할인값");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(39);
		cell.setCellValue("복수구매할인단위");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(40);
		cell.setCellValue("상품구매시포인트지급값");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(41);
		cell.setCellValue("상품구매시포인트지급단위");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(42);
		cell.setCellValue("텍스트리뷰작성시지급포인트");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(43);
		cell.setCellValue("포토/동영상 리뷰 작성시 지급 포인트");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(44);
		cell.setCellValue("한달사용\r\n" + " 텍스트리뷰 작성시 지급 포인트");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용

		cell = row.createCell(45);
		cell.setCellValue("한달사용\r\n" + " 포토/동영상리뷰 작성시 지급 포인트");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용

		cell = row.createCell(46);
		cell.setCellValue("톡톡친구/스토어찜고객\r\n" + " 리뷰 작성시 지급 포인트");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용

		cell = row.createCell(47);
		cell.setCellValue("무이자할부개월");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(48);
		cell.setCellValue("사은품");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(49);
		cell.setCellValue("옵션형태");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(50);
		cell.setCellValue("옵션명");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(51);
		cell.setCellValue("옵션값");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용

		cell = row.createCell(52);
		cell.setCellValue("옵션가");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(53);
		cell.setCellValue("옵션 재고수량");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(54);
		cell.setCellValue("추가 상품명");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용

		cell = row.createCell(55);
		cell.setCellValue("추가 상품값");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(56);
		cell.setCellValue("추가 상품가");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(57);
		cell.setCellValue("추가 상품 재고 수량");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(58);
		cell.setCellValue("상품정보 제공고시 품명");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(59);
		cell.setCellValue("상품정보 제공공시 모델명");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용

		cell = row.createCell(60);
		cell.setCellValue("추가 상품정보 제공고시 인증허가사항");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(61);
		cell.setCellValue("추가 상품정보 제공고시 제조사");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(62);
		cell.setCellValue("스토어펌 회원 전용여부");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(63);
		cell.setCellValue("문화비 소득공제");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(64);
		cell.setCellValue("ISBN");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		cell = row.createCell(65);
		cell.setCellValue("독립출판");
		cell.setCellStyle(cellStyle); // 셀 스타일 적용
		// ---------------------------------

		// 두 번째 줄

		Map<String, Object> map = null;
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ArrayList<String> columnList = new ArrayList<String>();

		
		for (int i = 0; i < lists.size(); i++) {
			map = new LinkedHashMap<String, Object>();
			map.put("productStatus", lists.get(i).getProductStatus());
			System.out.println(lists.get(i).getProductStatus());
			map.put("categoryID", lists.get(i).getCategoryID());
			map.put("productName", lists.get(i).getProductName());
			map.put("sellingPrice", lists.get(i).getSellingPrice());
			map.put("inventory", Integer.parseInt(lists.get(i).getInventoryQuantity()));
			map.put("asinfo", lists.get(i).getAsInfo());
			map.put("astel", lists.get(i).getAsTel());
			map.put("thumbimg", lists.get(i).getThumbImg().replaceAll("!!",""));
			map.put("increthumbimg", "");
			map.put("viewProduct", lists.get(i).getDetailInfo());
			map.put("sellingcode", lists.get(i).getSellingCode());
			System.out.println("sellingcode:" +lists.get(i).getSellingCode() );
			map.put("barcode", "");
			map.put("madeCompany", "");
			map.put("brand", "");
			map.put("madeDate","");
			map.put("youhoDate", "");
			map.put("surtax", lists.get(i).getSurTax());
			map.put("minorsPurchase", lists.get(i).getMinorsPurchase());
			map.put("purchaseStatus", lists.get(i).getPurchaseStatus());
			map.put("originCode", lists.get(i).getOriginCode());
			map.put("originCode; ", lists.get(i).getImportedCompany());
			map.put("redundantOrigin", lists.get(i).getRedundantOrigin());
			map.put("duplicate", "");
			map.put("deliveryMethod", lists.get(i).getDeliveryMethod());
			map.put("deliveryType", lists.get(i).getDeliveryType());
			map.put("defalut", "");
			map.put("deliveryPayMethod", lists.get(i).getDeliveryPayMethod());
			map.put("jo", "");
			map.put("jo1", "");
			map.put("returnShippCost",lists.get(i).getReturnShippCost());
			System.out.println("return:" + lists.get(i).getReturnShippCost());
			map.put("exchangeCost", lists.get(i).getExchangeCost());
			map.put("jo2", "");
			map.put("installCost", lists.get(i).getInstallCost());
			map.put("sellerItems", lists.get(i).getSellerItems());
			map.put("jo3", "");
			map.put("jo4", "");
			map.put("jo5", "");
			map.put("jo6", "");
			map.put("jo7", "");
			map.put("jo8", "");
			map.put("jo9", "");
			map.put("jo10", "");
			map.put("jo11", "");
			map.put("jo12", "");
			map.put("jo13", "");
			map.put("jo14", "");
			map.put("jo15", "");
			map.put("jo16","");
			map.put("jo17", "");
			map.put("optionalType", lists.get(i).getOptionalType());
			map.put("optionName", lists.get(i).getOptionName());
			map.put("optionValue", lists.get(i).getOptionValue());
			map.put("jo18", "");
			map.put("jo19", "");
			map.put("jo20", "");
			map.put("jo21", "");
			map.put("jo22", "");
			map.put("jo23", "");
			map.put("jo24", "");
			map.put("jo25", "");
			map.put("jo26", "");
			map.put("jo27", "");
			map.put("memberStatus", lists.get(i).getMemberStatus());
			map.put("jo28", "");
			map.put("jo29", "");
			map.put("jo30", "");
			list.add(map);
		}

		if (list != null && list.size() > 0) {
			Map<String, Object> m = list.get(0);
			for (String k : m.keySet()) {
				System.out.println("key:" + k);
				columnList.add(k);
			}
		}


	
		
		if (list != null && list.size() > 0) {

			int k = 1;
			for (Map<String, Object> obj : list) {
				
				try {
					row = sheet1.createRow((short) k);
					k++;
					if (columnList != null && columnList.size() > 0) {
						for (int j = 0; j < columnList.size(); j++) {
							System.out.println(j);
							if (columnList.get(j).equals("madeDate") || columnList.get(j).equals("youhoDate")) {
								DataFormat df = xlsWb.createDataFormat();
								CellStyle cs = xlsWb.createCellStyle();
								cs.setDataFormat(df.getFormat("yyyy-mm-dd"));
								Cell cell1 = row.createCell(j);
								cell1.setCellStyle(cs);
								//cell1.setCellValue(String.valueOf(obj.get(columnList.get(j))));
							} else if (columnList.get(j).equals("returnShippCost") || columnList.get(j).equals("exchangeCost") || columnList.get(j).equals("inventory")){
								CellStyle cs = xlsWb.createCellStyle();
							    Cell cell1 = row.createCell(j);
								cell1.setCellStyle(cs);
								cell1.setCellValue(Integer.parseInt(String.valueOf(obj.get(columnList.get(j)))));
								
							} else if (columnList.get(j).equals("jo16") || columnList.get(j).equals("jo1")) {
								CellStyle cs = xlsWb.createCellStyle();
							    Cell cell1 = row.createCell(j);
								cell1.setCellStyle(cs);
							} else {
							
								cell = row.createCell(j);
								cell.setCellValue(String.valueOf(obj.get(columnList.get(j))));
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				} 
			} // for
		} // if

		Date today = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
		// ---------------------------------

		// excel 파일 저장
		try {
			File xlsFile = new File(Constants.EXCEL_EXPORT_PATH + format1.format(today) + ".xls");
			FileOutputStream fileOut = new FileOutputStream(xlsFile);
			xlsWb.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
