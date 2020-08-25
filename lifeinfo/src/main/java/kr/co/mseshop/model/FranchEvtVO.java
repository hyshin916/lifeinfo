package kr.co.mseshop.model;

public class FranchEvtVO {

	private String name;
	private String userID;
	private String date;
	private String cnt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "FranchEvtVO [name=" + name + ", userID=" + userID + ", date=" + date + ", cnt=" + cnt + "]";
	}

}
