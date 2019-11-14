package kr.co.mseshop.model;

public class SearchVO {

	private int startNum;
	private int endNum;
	private int page;
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "SearchVO [startNum=" + startNum + ", endNum=" + endNum + ", page=" + page + "]";
	}
	
	

}
