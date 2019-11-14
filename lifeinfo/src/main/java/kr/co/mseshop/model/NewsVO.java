package kr.co.mseshop.model;

public class NewsVO {

	private String title;
	private String link;
	private String detail;
	private String newsID;
	private String detailImgURL;
	
	private String valueX;
	private String valueY;
	
	
	
	
	public String getValueX() {
		return valueX;
	}
	public void setValueX(String valueX) {
		this.valueX = valueX;
	}
	public String getValueY() {
		return valueY;
	}
	public void setValueY(String valueY) {
		this.valueY = valueY;
	}
	public String getDetailImgURL() {
		return detailImgURL;
	}
	public void setDetailImgURL(String detailImgURL) {
		this.detailImgURL = detailImgURL;
	}
	public String getNewsID() {
		return newsID;
	}
	public void setNewsID(String newsID) {
		this.newsID = newsID;
	}
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "NewsVO [title=" + title + ", link=" + link + ", detail=" + detail + ", newsID=" + newsID
				+ ", detailImgURL=" + detailImgURL + "]";
	}
	
	
	
}
