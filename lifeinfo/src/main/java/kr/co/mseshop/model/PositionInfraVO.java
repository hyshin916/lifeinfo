package kr.co.mseshop.model;

public class PositionInfraVO {

	private String thumbURL;
	private String title;
	private String detailImg;
	private String address;
	private String tel;
	private String contentid;
	public String getThumbURL() {
		return thumbURL;
	}
	public void setThumbURL(String thumbURL) {
		this.thumbURL = thumbURL;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetailImg() {
		return detailImg;
	}
	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	@Override
	public String toString() {
		return "PositionInfraVO [thumbURL=" + thumbURL + ", title=" + title + ", detailImg=" + detailImg + ", address="
				+ address + ", tel=" + tel + ", contentid=" + contentid + "]";
	}
	
	
	
}
