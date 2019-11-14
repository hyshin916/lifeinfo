package kr.co.mseshop.model;

public class MadeCategoryCodeVO {

	private String daeParam;
	private String junParam;
	private String soParam;
	private String detailView;
	
	
	
	public String getDetailView() {
		return detailView;
	}
	public void setDetailView(String detailView) {
		this.detailView = detailView;
	}
	public String getDaeParam() {
		return daeParam;
	}
	public void setDaeParam(String daeParam) {
		this.daeParam = daeParam;
	}
	public String getJunParam() {
		return junParam;
	}
	public void setJunParam(String junParam) {
		this.junParam = junParam;
	}
	public String getSoParam() {
		return soParam;
	}
	public void setSoParam(String soParam) {
		this.soParam = soParam;
	}
	@Override
	public String toString() {
		return "MadeCategoryCodeVO [daeParam=" + daeParam + ", junParam=" + junParam + ", soParam=" + soParam
				+ ", detailView=" + detailView + "]";
	}
	
}
