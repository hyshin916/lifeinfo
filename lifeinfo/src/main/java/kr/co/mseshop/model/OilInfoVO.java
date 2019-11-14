package kr.co.mseshop.model;

public class OilInfoVO {

	private String price;
	private String os_nm;
	private String van_adr;
	private String new_adr;
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOs_nm() {
		return os_nm;
	}
	public void setOs_nm(String os_nm) {
		this.os_nm = os_nm;
	}
	public String getVan_adr() {
		return van_adr;
	}
	public void setVan_adr(String van_adr) {
		this.van_adr = van_adr;
	}
	public String getNew_adr() {
		return new_adr;
	}
	public void setNew_adr(String new_adr) {
		this.new_adr = new_adr;
	}
	@Override
	public String toString() {
		return "OilInfoVO [price=" + price + ", os_nm=" + os_nm + ", van_adr=" + van_adr + ", new_adr=" + new_adr + "]";
	}

	
	
}
