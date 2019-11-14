package kr.co.mseshop.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.co.mseshop.model.BusinessVO;
import kr.co.mseshop.model.CategoryCodeVO;

public class ContRuleReader2 {

	String url;
	String user;
	String password;

	Connection con = null;
	PreparedStatement psmt = null;

	String query = "insert into account_tbl(no,business_no,business_name,center) values(?,?,?,?)";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC Driver loading SUCCESS...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ContRuleReader2() throws SQLException {

		this.url = "jdbc:mysql://localhost:3306/crawldb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
		this.user = "root";
		this.password = "1234";
		con = DriverManager.getConnection(url, user, password);
	}

	

	public void dbConnectionSave(BusinessVO vo) {

		try {

			psmt = con.prepareStatement(query);
			psmt.setString(1, vo.getNo());
			psmt.setString(2, vo.getBusiness_no());
			psmt.setString(3, vo.getBusiness_name());
			psmt.setString(4, "retail");

			psmt.execute();
			System.out.println("DB insert SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "resource", "deprecation" })
	public List<CategoryCodeVO> xlsToCustomerVoList(String filePath) throws InterruptedException {

		// ��ȯ�� ��ü�� ����
		List<CategoryCodeVO> list = new ArrayList<CategoryCodeVO>();

		FileInputStream fis = null;
		HSSFWorkbook workbook = null;

		try {

			fis = new FileInputStream(filePath);
			// HSSFWorkbook�� �������� ��ü ������ ��� �ִ� ��ü
			workbook = new HSSFWorkbook(fis);

			// Ž���� ����� Sheet, Row, Cell ��ü
			HSSFSheet curSheet;
			HSSFRow curRow;
			HSSFCell curCell;
			CategoryCodeVO vo;

			// Sheet Ž�� for��
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// ���� Sheet ��ȯ
				curSheet = workbook.getSheetAt(sheetIndex);
				// row Ž�� for��
				for (int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0�� ��������̱� ������ ����
					if (rowIndex != 0) {
						// ���� row ��ȯ
						curRow = curSheet.getRow(rowIndex);
						vo = new CategoryCodeVO();
						String value;

						// row�� ù��° cell���� ������� ���� ��� �� cellŽ��
						if (!"".equals(curRow.getCell(0).getStringCellValue())) {

							// cell Ž�� for ��
							for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
								curCell = curRow.getCell(cellIndex);

								if (true) {
									value = "";
									// cell ��Ÿ���� �ٸ����� String���� ��ȯ ����
									switch (curCell.getCellType()) {
									case HSSFCell.CELL_TYPE_FORMULA:
										value = curCell.getCellFormula();
										break;
									case HSSFCell.CELL_TYPE_NUMERIC:
										value = curCell.getNumericCellValue() + "";
										break;
									case HSSFCell.CELL_TYPE_STRING:
										value = curCell.getStringCellValue() + "";
										break;
									case HSSFCell.CELL_TYPE_BLANK:
										value = curCell.getBooleanCellValue() + "";
										break;
									case HSSFCell.CELL_TYPE_ERROR:
										value = curCell.getErrorCellValue() + "";
										break;
									default:
										value = new String();
										break;
									}

									// ���� column index�� ���� vo�� �Է�
									switch (cellIndex) {
									case 0:
										vo.setCode(value);
										break;

									case 1:
										vo.setLevel1(value);
										break;

									case 2:
										vo.setLevel2(value);
										break;

									case 3:
										vo.setLevel3(value);
										break;

									case 4:
										vo.setLevel4(value);
										break;

									default:
										break;
									}
								}
							}
							// cell Ž�� ���� vo �߰�
							list.add(vo);
						//	dbConnectionSave(vo);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				// ����� �ڿ��� finally���� ����
				if (workbook != null)
					workbook.close();
				if (fis != null)
					fis.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * XLSX ������ �м��Ͽ� List<CustomerVo> ��ü�� ��ȯ
	 * 
	 * @param filePath
	 * @return
	 */
	public List<BusinessVO> xlsxToCustomerVoList(String filePath) {
		// ��ȯ�� ��ü�� ����
		List<BusinessVO> list = new ArrayList<BusinessVO>();

		FileInputStream fis = null;
		XSSFWorkbook workbook = null;

		try {
			System.out.println("path: " + filePath);

			fis = new FileInputStream(filePath);
			// HSSFWorkbook�� �������� ��ü ������ ��� �ִ� ��ü
			workbook = new XSSFWorkbook(fis);

			// Ž���� ����� Sheet, Row, Cell ��ü
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			BusinessVO vo;

			// Sheet Ž�� for��
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// ���� Sheet ��ȯ
				curSheet = workbook.getSheetAt(sheetIndex);
				// row Ž�� for��
				for (int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0�� ��������̱� ������ ����
					if (rowIndex != 0) {
						// ���� row ��ȯ
						curRow = curSheet.getRow(rowIndex);
						vo = new BusinessVO();
						String value;
						curCell = curSheet.getRow(rowIndex).getCell(0);
						curCell.setCellType(Cell.CELL_TYPE_STRING);
						
						
						// row�� ù��° cell���� ������� ���� ��� �� cellŽ��
						if (!"".equals(curRow.getCell(0).getStringCellValue())) {

							// cell Ž�� for ��
							for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
								curCell = curRow.getCell(cellIndex);

								if (true) {
									value = "";
									// cell ��Ÿ���� �ٸ����� String���� ��ȯ ����
									switch (curCell.getCellType()) {
									case HSSFCell.CELL_TYPE_FORMULA:
										value = curCell.getCellFormula();
										break;
									case HSSFCell.CELL_TYPE_NUMERIC:
										value = curCell.getNumericCellValue() + "";
										break;
									case HSSFCell.CELL_TYPE_STRING:
										value = curCell.getStringCellValue() + "";
										break;
									case HSSFCell.CELL_TYPE_BLANK:
										value = curCell.getBooleanCellValue() + "";
										break;
									case HSSFCell.CELL_TYPE_ERROR:
										value = curCell.getErrorCellValue() + "";
										break;
									default:
										value = new String();
										break;
									}

									// ���� column index�� ���� vo�� �Է�
									switch (cellIndex) {
									case 0:
										vo.setNo(value);
										break;

									case 1:
										vo.setBusiness_no(value);
										break;

									case 2:
										vo.setBusiness_name(value);
										break;

									/*case 3:
										vo.setCenter("retail");
										break;*/
									}
								}
							}
							// cell Ž�� ���� vo �߰�
							list.add(vo);
							dbConnectionSave(vo);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				// ����� �ڿ��� finally���� ����
				if (workbook != null)
					workbook.close();
				if (fis != null)
					fis.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public static void main(String args[]) throws InterruptedException, SQLException {
		List<BusinessVO> lists = new ContRuleReader2().xlsxToCustomerVoList("D:/center.xlsx");
		for (BusinessVO list : lists) {
			System.out.println(list);
		}
	}

}
