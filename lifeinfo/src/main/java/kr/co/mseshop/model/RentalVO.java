package kr.co.mseshop.model;

public class RentalVO {

	private String no;
	private String name;
	private String id;
	private String kind;
	private String size;
	private String local;
	private String code;
	private String date;
	private String rtquestion;
	private String rental_yn;
	
	
	
	

	public String getRtquestion() {
		return rtquestion;
	}

	public void setRtquestion(String rtquestion) {
		this.rtquestion = rtquestion;
	}

	public String getRental_yn() {
		return rental_yn;
	}

	public void setRental_yn(String rental_yn) {
		this.rental_yn = rental_yn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "RentalVO [no=" + no + ", name=" + name + ", id=" + id + ", kind=" + kind + ", size=" + size + ", local="
				+ local + ", code=" + code + ", date=" + date + "]";
	}

	
	
}
