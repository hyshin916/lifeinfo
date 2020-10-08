package kr.co.mseshop.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

public class RentalSvcException extends RuntimeException {

	public RentalSvcException(String msg) {
		//super(msg);
		System.out.println("#############################################");
		System.out.println("[RentalSvc Exception]" + msg);
		System.out.println("#############################################");
		
	}
}
