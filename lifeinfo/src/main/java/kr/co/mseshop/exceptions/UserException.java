package kr.co.mseshop.exceptions;

@SuppressWarnings("serial")
public class UserException extends RuntimeException {

	public UserException(Exception e,String msg) {
		System.out.println("########################################################");
		e.printStackTrace();
		System.out.println("[Exception] : " + msg);
		System.out.println("########################################################");
	}
	
}
