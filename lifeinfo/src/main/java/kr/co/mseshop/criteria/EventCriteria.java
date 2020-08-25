package kr.co.mseshop.criteria;

import org.apache.ibatis.session.RowBounds;

public class EventCriteria extends Pageable {

	private String startDate_1;
	private String endDate_1;
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

	public String getStartDate_1() {
		return startDate_1;
	}

	public void setStartDate_1(String startDate_1) {
		this.startDate_1 = startDate_1;
	}

	public String getEndDate_1() {
		return endDate_1;
	}

	public void setEndDate_1(String endDate_1) {
		this.endDate_1 = endDate_1;
	}
	public RowBounds getRowBounds() {
    	return new RowBounds(skipCount(), listSize);
    }
}
