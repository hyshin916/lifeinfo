package kr.co.mseshop.model;

public class RefindDataVO {

	 String strLength;
	 String productStatus; // 상품상태 - 신상품
	 String categoryID;
	 String productName; // 상품명 (제목)
	 String sellingPrice; // 판매가
	 String inventoryQuantity; //재고수량 - 3000
	 String asInfo; // as내용 - 해외 구매대행 상품은 국내에서 A/S불가능 합니다.
	 String asTel; //as전화 - 010-9427-5467
	 String thumbImg; // 대표이지미
	 String detailInfo; // 상품상세정보
	 String sellingCode; //판매자상품코드
	 String surTax; // 부가세 - 과세상품
	 String minorsPurchase; //미성년자구매 -Y
	 String purchaseStatus; // 구매평 - Y
	 String originCode; //원산지코드 - 0200037
	 String importedCompany; //수입사- 중국,홍콩
	 String redundantOrigin; // 복수원산지여부 - Y
	 String deliveryMethod; // 배송방법 -택배,소포,등기
	 String deliveryType; // 배송비유형 - 무료
	 String deliveryPayMethod; //배송비결제방식 - 착불
	 String returnShippCost; // 반품배송비 - 25000
	 String exchangeCost; // 교환배송비 - 50000
	 String installCost; // 별도설치비 - N
	 String sellerItems; // 판매자특이사항 - 없음
	 String optionalType; // 옵션형태 - 단독형
	 String optionName; // 옵션명
	 String optionValue; //옵션값
	 String memberStatus; //스토어펌 회원전용여부 - N
	 String exportStatus;
	
	
	
	
	
	public String getStrLength() {
		return strLength;
	}
	public void setStrLength(String strLength) {
		this.strLength = strLength;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getExportStatus() {
		return exportStatus;
	}
	public void setExportStatus(String exportStatus) {
		this.exportStatus = exportStatus;
	}
	
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getInventoryQuantity() {
		return inventoryQuantity;
	}
	public void setInventoryQuantity(String inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}
	public String getAsInfo() {
		return asInfo;
	}
	public void setAsInfo(String asInfo) {
		this.asInfo = asInfo;
	}
	public String getAsTel() {
		return asTel;
	}
	public void setAsTel(String asTel) {
		this.asTel = asTel;
	}
	public String getThumbImg() {
		return thumbImg;
	}
	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}
	public String getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}
	public String getSellingCode() {
		return sellingCode;
	}
	public void setSellingCode(String sellingCode) {
		this.sellingCode = sellingCode;
	}
	public String getSurTax() {
		return surTax;
	}
	public void setSurTax(String surTax) {
		this.surTax = surTax;
	}
	public String getMinorsPurchase() {
		return minorsPurchase;
	}
	public void setMinorsPurchase(String minorsPurchase) {
		this.minorsPurchase = minorsPurchase;
	}
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	public String getOriginCode() {
		return originCode;
	}
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}
	public String getImportedCompany() {
		return importedCompany;
	}
	public void setImportedCompany(String importedCompany) {
		this.importedCompany = importedCompany;
	}
	public String getRedundantOrigin() {
		return redundantOrigin;
	}
	public void setRedundantOrigin(String redundantOrigin) {
		this.redundantOrigin = redundantOrigin;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getDeliveryPayMethod() {
		return deliveryPayMethod;
	}
	public void setDeliveryPayMethod(String deliveryPayMethod) {
		this.deliveryPayMethod = deliveryPayMethod;
	}
	public String getReturnShippCost() {
		return returnShippCost;
	}
	public void setReturnShippCost(String returnShippCost) {
		this.returnShippCost = returnShippCost;
	}
	public String getExchangeCost() {
		return exchangeCost;
	}
	public void setExchangeCost(String exchangeCost) {
		this.exchangeCost = exchangeCost;
	}
	public String getInstallCost() {
		return installCost;
	}
	public void setInstallCost(String installCost) {
		this.installCost = installCost;
	}
	public String getSellerItems() {
		return sellerItems;
	}
	public void setSellerItems(String sellerItems) {
		this.sellerItems = sellerItems;
	}
	public String getOptionalType() {
		return optionalType;
	}
	public void setOptionalType(String optionalType) {
		this.optionalType = optionalType;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	@Override
	public String toString() {
		return "RefindDataVO [strLength=" + strLength + ", productStatus=" + productStatus + ", categoryID="
				+ categoryID + ", productName=" + productName + ", sellingPrice=" + sellingPrice
				+ ", inventoryQuantity=" + inventoryQuantity + ", asInfo=" + asInfo + ", asTel=" + asTel + ", thumbImg="
				+ thumbImg + ", detailInfo=" + detailInfo + ", sellingCode=" + sellingCode + ", surTax=" + surTax
				+ ", minorsPurchase=" + minorsPurchase + ", purchaseStatus=" + purchaseStatus + ", originCode="
				+ originCode + ", importedCompany=" + importedCompany + ", redundantOrigin=" + redundantOrigin
				+ ", deliveryMethod=" + deliveryMethod + ", deliveryType=" + deliveryType + ", deliveryPayMethod="
				+ deliveryPayMethod + ", returnShippCost=" + returnShippCost + ", exchangeCost=" + exchangeCost
				+ ", installCost=" + installCost + ", sellerItems=" + sellerItems + ", optionalType=" + optionalType
				+ ", optionName=" + optionName + ", optionValue=" + optionValue + ", memberStatus=" + memberStatus
				+ ", exportStatus=" + exportStatus + "]";
	}
	
}
