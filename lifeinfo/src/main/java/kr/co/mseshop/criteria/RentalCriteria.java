package kr.co.mseshop.criteria;

public class RentalCriteria {

	private String userID;
	private String carKind;
	private String tire1;
	private String tire2;
	private String tire3;
	private String rentalLocal;
	private String code;
	private String startDate;
	private String endDate;
	
	
	
	
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCarKind() {
		return carKind;
	}
	public void setCarKind(String carKind) {
		this.carKind = carKind;
	}
	public String getTire1() {
		return tire1;
	}
	public void setTire1(String tire1) {
		this.tire1 = tire1;
	}
	public String getTire2() {
		return tire2;
	}
	public void setTire2(String tire2) {
		this.tire2 = tire2;
	}
	public String getTire3() {
		return tire3;
	}
	public void setTire3(String tire3) {
		this.tire3 = tire3;
	}
	public String getRentalLocal() {
		return rentalLocal;
	}
	public void setRentalLocal(String rentalLocal) {
		this.rentalLocal = rentalLocal;
	}
	
	@Override
	public String toString() {
		return "RentalCriteria [userID=" + userID + ", carKind=" + carKind + ", tire1=" + tire1 + ", tire2=" + tire2
				+ ", tire3=" + tire3 + ", rentalLocal=" + rentalLocal + ", code=" + code + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
	
}
