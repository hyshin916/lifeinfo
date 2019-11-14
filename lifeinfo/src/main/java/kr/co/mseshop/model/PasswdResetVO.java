package kr.co.mseshop.model;

public class PasswdResetVO {
	
	private String no_htel; // 전화번호
	private String nm_byr;   // 이름
	private String nm_addr; // 주소
	public String getNo_htel() {
		return no_htel;
	}
	public void setNo_htel(String no_htel) {
		this.no_htel = no_htel;
	}
	public String getNm_byr() {
		return nm_byr;
	}
	public void setNm_byr(String nm_byr) {
		this.nm_byr = nm_byr;
	}
	public String getNm_addr() {
		return nm_addr;
	}
	public void setNm_addr(String nm_addr) {
		this.nm_addr = nm_addr;
	}
	@Override
	public String toString() {
		return "PasswdResetVO [no_htel=" + no_htel + ", nm_byr=" + nm_byr + ", nm_addr=" + nm_addr + "]";
	}
	
	
	
	
	
}
