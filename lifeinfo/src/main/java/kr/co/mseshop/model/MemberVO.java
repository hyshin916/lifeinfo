package kr.co.mseshop.model;

public class MemberVO {

	private String mem_id;
	private String mem_name;
	private String mem_passwd;
	private String mem_authority;
	private String mem_regDate;
	private String mem_status;
	private String group_id;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_passwd() {
		return mem_passwd;
	}

	public void setMem_passwd(String mem_passwd) {
		this.mem_passwd = mem_passwd;
	}

	public String getMem_authority() {
		return mem_authority;
	}

	public void setMem_authority(String mem_authority) {
		this.mem_authority = mem_authority;
	}

	public String getMem_regDate() {
		return mem_regDate;
	}

	public void setMem_regDate(String mem_regDate) {
		this.mem_regDate = mem_regDate;
	}

	public String getMem_status() {
		return mem_status;
	}

	public void setMem_status(String mem_status) {
		this.mem_status = mem_status;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

}
