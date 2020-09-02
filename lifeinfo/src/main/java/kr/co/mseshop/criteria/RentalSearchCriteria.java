package kr.co.mseshop.criteria;

import org.apache.ibatis.session.RowBounds;

public class RentalSearchCriteria extends Pageable {
	
	private String rentalStatus;
	private String startDate;
	private String endDate;

	public String getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

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
	public RowBounds getRowBounds() {
    	return new RowBounds(skipCount(), listSize);
    }
}
