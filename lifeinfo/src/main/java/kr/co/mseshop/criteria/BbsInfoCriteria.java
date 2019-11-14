package kr.co.mseshop.criteria;

import org.apache.ibatis.session.RowBounds;

public class BbsInfoCriteria extends Pageable {
    private String title;
    private String pcode;
    private String lineYN;
    private String important;
    private String viewYN;
    
    
    
    

    public String getLineYN() {
		return lineYN;
	}


	public void setLineYN(String lineYN) {
		this.lineYN = lineYN;
	}


	public String getImportant() {
		return important;
	}


	public void setImportant(String important) {
		this.important = important;
	}


	public String getViewYN() {
		return viewYN;
	}


	public void setViewYN(String viewYN) {
		this.viewYN = viewYN;
	}


	public String getPcode() {
		return pcode;
	}


	public void setPcode(String pcode) {
		this.pcode = pcode;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public RowBounds getRowBounds() {
    	return new RowBounds(skipCount(), listSize);
    }
}
