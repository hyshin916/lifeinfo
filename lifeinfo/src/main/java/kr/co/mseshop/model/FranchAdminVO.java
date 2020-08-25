package kr.co.mseshop.model;

public class FranchAdminVO {

	private int no;
	private String name;
	private String sellerCd;
	private int useCnt;
	private String passwd;
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSellerCd() {
		return sellerCd;
	}
	public void setSellerCd(String sellerCd) {
		this.sellerCd = sellerCd;
	}
	public int getUseCnt() {
		return useCnt;
	}
	public void setUseCnt(int useCnt) {
		this.useCnt = useCnt;
	}
	@Override
	public String toString() {
		return "FranchAdminVO [no=" + no + ", name=" + name + ", sellerCd=" + sellerCd + ", useCnt=" + useCnt
				+ ", passwd=" + passwd + "]";
	}
	
	
	
}
