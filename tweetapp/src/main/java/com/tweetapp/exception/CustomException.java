package com.tweetapp.exception;

public class CustomException extends Exception {
	
	String msg;

	public CustomException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}

}
