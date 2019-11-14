package kr.co.mseshop.model;

public class CrawlInfoVO {

	String no;
	String category;
	String viewURL;
	String thumbURL;
	String title;
	String price;
	String proPrice;
	String size;
	String color;
	String bodyImgURL;
	String thumbfileName;
	String made;
	String reg_date;
	String optionName;
	String increOptionValue;

	


	public String getIncreOptionValue() {
		return increOptionValue;
	}

	public void setIncreOptionValue(String increOptionValue) {
		this.increOptionValue = increOptionValue;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getMade() {
		return made;
	}

	public void setMade(String made) {
		this.made = made;
	}

	public String getThumbfileName() {
		return thumbfileName;
	}

	public void setThumbfileName(String thumbfileName) {
		this.thumbfileName = thumbfileName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getViewURL() {
		return viewURL;
	}

	public void setViewURL(String viewURL) {
		this.viewURL = viewURL;
	}

	public String getThumbURL() {
		return thumbURL;
	}

	public void setThumbURL(String thumbURL) {
		this.thumbURL = thumbURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProPrice() {
		return proPrice;
	}

	public void setProPrice(String proPrice) {
		this.proPrice = proPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBodyImgURL() {
		return bodyImgURL;
	}

	public void setBodyImgURL(String bodyImgURL) {
		this.bodyImgURL = bodyImgURL;
	}

	@Override
	public String toString() {
		return "CrawlInfoVO [no=" + no + ", category=" + category + ", viewURL=" + viewURL + ", thumbURL=" + thumbURL
				+ ", title=" + title + ", price=" + price + ", proPrice=" + proPrice + ", size=" + size + ", color="
				+ color + ", bodyImgURL=" + bodyImgURL + ", thumbfileName=" + thumbfileName + ", made=" + made
				+ ", reg_date=" + reg_date + ", optionName=" + optionName + ", increOptionValue=" + increOptionValue
				+ "]";
	}


	
	
}
