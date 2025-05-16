package com.cognizant.hotel.exception;

@SuppressWarnings("serial")
public class UserException extends Exception {

	@SuppressWarnings("unused")
	private String message;
	
	public UserException(String msg) {
		super(msg);
		this.message = msg;
	}
	
}
