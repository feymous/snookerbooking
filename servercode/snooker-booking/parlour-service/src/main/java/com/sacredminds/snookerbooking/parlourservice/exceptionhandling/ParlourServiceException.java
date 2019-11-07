package com.sacredminds.snookerbooking.parlourservice.exceptionhandling;

public class ParlourServiceException extends Exception {

	private static final long serialVersionUID = -1315519600481257190L;

	private final int code;
	private final String message;

	public ParlourServiceException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
