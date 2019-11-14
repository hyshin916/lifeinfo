package kr.co.mseshop.model;

public class UserInfo {

	private String name;
	private String id;
	private String passwd;
	private String phone;
	private String address;

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", id=" + id + ", passwd=" + passwd + ", phone=" + phone + ", address="
				+ address + "]";
	}

}
