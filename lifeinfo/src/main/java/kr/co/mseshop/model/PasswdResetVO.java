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
	
	
	private String id;
	private String no_coad;
	private String no_card_sc;
	private String name;
	private String nickname;
	private String home_addr;
	private String passwd;
	
	
	

	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNo_coad() {
		return no_coad;
	}
	public void setNo_coad(String no_coad) {
		this.no_coad = no_coad;
	}
	public String getNo_card_sc() {
		return no_card_sc;
	}
	public void setNo_card_sc(String no_card_sc) {
		this.no_card_sc = no_card_sc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHome_addr() {
		return home_addr;
	}
	public void setHome_addr(String home_addr) {
		this.home_addr = home_addr;
	}

	
	
	
}
