package kr.co.mseshop.model;

public class FestivalVO {

	private String sigun;
	private String hmpg;
	private String title;
	public String getSigun() {
		return sigun;
	}
	public void setSigun(String sigun) {
		this.sigun = sigun;
	}
	public String getHmpg() {
		return hmpg;
	}
	public void setHmpg(String hmpg) {
		this.hmpg = hmpg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "FestivalVO [sigun=" + sigun + ", hmpg=" + hmpg + ", title=" + title + "]";
	}
	
	
}
