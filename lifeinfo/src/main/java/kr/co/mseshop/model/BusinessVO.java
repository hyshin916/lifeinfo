package kr.co.mseshop.model;

public class BusinessVO {

	private String no;
	private String business_no;
	private String business_name;
	private String center;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getBusiness_no() {
		return business_no;
	}
	public void setBusiness_no(String business_no) {
		this.business_no = business_no;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	@Override
	public String toString() {
		return "BusinessVO [no=" + no + ", business_no=" + business_no + ", business_name=" + business_name
				+ ", center=" + center + "]";
	}
	
	
	
}
