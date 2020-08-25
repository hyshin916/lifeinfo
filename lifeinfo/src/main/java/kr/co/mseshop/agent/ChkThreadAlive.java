package kr.co.mseshop.agent;

import java.io.FileOutputStream;
import java.util.Properties;


import kr.co.mseshop.common.PathClass;

public class ChkThreadAlive implements Runnable {

	boolean execute;

	public void setChkThread(boolean execute) {
		this.execute = execute;
	}

	Thread lineThread;

	public ChkThreadAlive(Thread lineThread) {
		this.lineThread = lineThread;
	}

	@Override
	public void run() {
		while (execute) {
			try {
				Thread.sleep(3000);
				boolean chkResult = this.lineThread.isAlive();
				if (chkResult == false) {
					Properties prop = new Properties();
					prop.setProperty("chkDaemon", "false");
					prop.store(new FileOutputStream(PathClass.getDeamon_status()), "daemonStatus");
					setChkThread(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
