package kr.co.mseshop.model;

/**
 * @author 사용자
 *
 */
/**
 * @author 사용자
 *
 */
public class ArticleVO {

	public String no;
	public String nsid;
	public String pcode;
	public String action;
	public String title;
	public String sub_title;
	public String content;
	public String author;
	public String catecode;
	public String citycode;
	public String imgurl;
	public String caption_content;
	public String caption_title;
	public String pc_url;
	public String m_url;
	public String app_url;
	public String date;
	public String press;
	public String keyword;
	public int orderbyno;
	public int orderbyNOLine;
	
	public int uv;
	public String viewYN;
	public String important;
	public String start_date;
	public String expire_date;
	public String update_date;
	public String start_time;
	public String expire_time;
	
	public String fileOriName;
	public String fno;
	public String fileName;
	public String fileUrl;
	public String youtubeID;
	public String lineYN;
	public boolean youtubeYN;
	
	
	
	
	public boolean isYoutubeYN() {
		return youtubeYN;
	}

	public void setYoutubeYN(boolean youtubeYN) {
		this.youtubeYN = youtubeYN;
	}

	public int getOrderbyNOLine() {
		return orderbyNOLine;
	}

	public void setOrderbyNOLine(int orderbyNOLine) {
		this.orderbyNOLine = orderbyNOLine;
	}

	public String getLineYN() {
		return lineYN;
	}

	public void setLineYN(String lineYN) {
		this.lineYN = lineYN;
	}

	public String getYoutubeID() {
		return youtubeID;
	}

	public void setYoutubeID(String youtubeID) {
		this.youtubeID = youtubeID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public String getFileOriName() {
		return fileOriName;
	}

	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}

	public String getImportant() {
		return important;
	}

	public void setImportant(String important) {
		this.important = important;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(String expire_time) {
		this.expire_time = expire_time;
	}

	public int getOrderbyno() {
		return orderbyno;
	}

	public void setOrderbyno(int orderbyno) {
		this.orderbyno = orderbyno;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getSub_title() {
		return sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}

	public String getViewYN() {
		return viewYN;
	}

	public void setViewYN(String viewYN) {
		this.viewYN = viewYN;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getNsid() {
		return nsid;
	}

	public void setNsid(String nsid) {
		this.nsid = nsid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCatecode() {
		return catecode;
	}

	public void setCatecode(String catecode) {
		this.catecode = catecode;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getCaption_content() {
		return caption_content;
	}

	public void setCaption_content(String caption_content) {
		this.caption_content = caption_content;
	}

	public String getCaption_title() {
		return caption_title;
	}

	public void setCaption_title(String caption_title) {
		this.caption_title = caption_title;
	}

	public String getPc_url() {
		return pc_url;
	}

	public void setPc_url(String pc_url) {
		this.pc_url = pc_url;
	}

	public String getM_url() {
		return m_url;
	}

	public void setM_url(String m_url) {
		this.m_url = m_url;
	}

	public String getApp_url() {
		return app_url;
	}

	public void setApp_url(String app_url) {
		this.app_url = app_url;
	}

	public int getUv() {
		return uv;
	}

	public void setUv(int uv) {
		this.uv = uv;
	}

	@Override
	public String toString() {
		return "ArticleVO [no=" + no + ", nsid=" + nsid + ", pcode=" + pcode + ", action=" + action + ", title=" + title
				+ ", sub_title=" + sub_title + ", content=" + content + ", author=" + author + ", catecode=" + catecode
				+ ", citycode=" + citycode + ", imgurl=" + imgurl + ", caption_content=" + caption_content
				+ ", caption_title=" + caption_title + ", pc_url=" + pc_url + ", m_url=" + m_url + ", app_url="
				+ app_url + ", date=" + date + ", press=" + press + ", keyword=" + keyword + ", orderbyno=" + orderbyno
				+ ", uv=" + uv + ", viewYN=" + viewYN + ", important=" + important + ", start_date=" + start_date
				+ ", expire_date=" + expire_date + ", update_date=" + update_date + ", start_time=" + start_time
				+ ", expire_time=" + expire_time + ", fileOriName=" + fileOriName + ", fno=" + fno + ", fileName="
				+ fileName + ", fileUrl=" + fileUrl + ", youtubeID=" + youtubeID + ", lineYN=" + lineYN + "]";
	}


	
}
