package kr.co.mseshop.exceptions;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class UserException extends RuntimeException {

	Logger logger = Logger.getLogger(this.getClass());
	
	public UserException(String msg) {
		super(msg);
	}
	
	public UserException(String msg,Exception e) {
		System.out.println("########################################################");
		System.out.println(msg);
		e.printStackTrace();
		logger.error(msg);
		logger.error(e);
		System.out.println("########################################################");
	}
	
}
