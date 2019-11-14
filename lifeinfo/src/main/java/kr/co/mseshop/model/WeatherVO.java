package kr.co.mseshop.model;

public class WeatherVO {

	private String temp;
	private String tmx;
	private String tmn;
	private String sky;
	private String pty;
	
	
	
	
	public String getTmn() {
		return tmn;
	}
	public void setTmn(String tmn) {
		this.tmn = tmn;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getTmx() {
		return tmx;
	}
	public void setTmx(String tmx) {
		this.tmx = tmx;
	}
	public String getSky() {
		return sky;
	}
	public void setSky(String sky) {
		this.sky = sky;
	}
	public String getPty() {
		return pty;
	}
	public void setPty(String pty) {
		this.pty = pty;
	}
	@Override
	public String toString() {
		return "WeatherVO [temp=" + temp + ", tmx=" + tmx + ", tmn=" + tmn + ", sky=" + sky + ", pty=" + pty + "]";
	}
	
	
	
}
