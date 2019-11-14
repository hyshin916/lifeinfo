package kr.co.mseshop.model;

public class FileVO {

	private String fno; 
	private String bno; 
	private String fileName; 
	private String fileOriName; 
	private String fileUrl; 
	private int fileSize; 
	private String pressCd;
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileOriName() {
		return fileOriName;
	}
	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getPressCd() {
		return pressCd;
	}
	public void setPressCd(String pressCd) {
		this.pressCd = pressCd;
	}
	@Override
	public String toString() {
		return "FileVO [fno=" + fno + ", bno=" + bno + ", fileName=" + fileName + ", fileOriName=" + fileOriName
				+ ", fileUrl=" + fileUrl + ", fileSize=" + fileSize + ", pressCd=" + pressCd + "]";
	}
	

}
