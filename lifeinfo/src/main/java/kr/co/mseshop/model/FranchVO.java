package kr.co.mseshop.model;

public class FranchVO {

	private String id;
	private String sellerCd;
	private String point;
	private String date;
	private String name;

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

	public String getSellerCd() {
		return sellerCd;
	}

	public void setSellerCd(String sellerCd) {
		this.sellerCd = sellerCd;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FranchVO [id=" + id + ", sellerCd=" + sellerCd + ", point=" + point + ", date=" + date + ", name="
				+ name + "]";
	}

}
