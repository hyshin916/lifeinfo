package kr.co.mseshop.model;

public class RentalVO2 {

	private String id;
	private String name;
	private String code;
	private String description;
	private String date;
	
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RentalVO2 [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description + ", date="
				+ date + "]";
	}

	
	
}
