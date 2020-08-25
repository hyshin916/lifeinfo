package kr.co.mseshop.agent;

public abstract class AbstractNewsCommon {

	public String location;
	public String filePath;

	public AbstractNewsCommon(String location, String filePath) {
		this.location = location;
		this.filePath = filePath;
	}

	public void start() {
		threadStart();
	}
	abstract  void threadStart();
	
}
