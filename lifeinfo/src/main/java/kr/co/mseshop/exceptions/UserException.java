package kr.co.mseshop.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class UserException extends RuntimeException {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public UserException(String msg) {
		super(msg);
	}
	
	public UserException(String msg,Exception e) {
		System.out.println("########################################################");
		System.out.println(msg);
		e.printStackTrace();
		logger.error(msg,e);
		System.out.println("########################################################");
	}
	
}
