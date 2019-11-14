package kr.co.mseshop.model;

import java.util.List;

public class DataSet {

	private List<ArticleVO> rows;
	private int toCnt;
	private int startNum;
	private int resultCode;

	public List<ArticleVO> getRows() {
		return rows;
	}

	public void setRows(List<ArticleVO> list) {
		this.rows = list;
	}

	public int getToCnt() {
		return toCnt;
	}

	public void setToCnt(int totalCnt) {
		this.toCnt = totalCnt;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int num) {
		this.startNum = num;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int i) {
		this.resultCode = i;
	}

	@Override
	public String toString() {
		return "SearchVO [rows=" + rows + ", toCnt=" + toCnt + ", startNum=" + startNum + ", resultCode=" + resultCode
				+ "]";
	}

}
