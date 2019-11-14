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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.co.mseshop.model.CategoryCodeVO;

public class ContRuleReader {

	String url;
	String user;
	String password;

	Connection con = null;
	PreparedStatement psmt = null;

	String query = "insert into category_tbl(code,level1,level2,level3,level4) values(?,?,?,?,?)";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC Driver loading SUCCESS...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ContRuleReader() throws SQLException {

		this.url = "jdbc:mysql://localhost:3306/crawldb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
		this.user = "root";
		this.password = "1234";
		con = DriverManager.getConnection(url, user, password);
	}

	

	public void dbConnectionSave(CategoryCodeVO vo) {

		try {

			psmt = con.prepareStatement(query);
			psmt.setString(1, vo.getCode());
			psmt.setString(2, vo.getLevel1());
			psmt.setString(3, vo.getLevel2());
			psmt.setString(4, vo.getLevel3());
			psmt.setString(5, vo.getLevel4());

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

	/**
	 * XLSX ������ �м��Ͽ� List<CustomerVo> ��ü�� ��ȯ
	 * 
	 * @param filePath
	 * @return
	 */
	public List<CategoryCodeVO> xlsxToCustomerVoList(String filePath) {
		// ��ȯ�� ��ü�� ����
		List<CategoryCodeVO> list = new ArrayList<CategoryCodeVO>();

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
									}
								}
							}
							// cell Ž�� ���� vo �߰�
							list.add(vo);
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
		List<CategoryCodeVO> lists = new ContRuleReader().xlsToCustomerVoList("D:/category_20181226_154633.xls");
		for (CategoryCodeVO list : lists) {
			System.out.println(list);
		}
	}

}
