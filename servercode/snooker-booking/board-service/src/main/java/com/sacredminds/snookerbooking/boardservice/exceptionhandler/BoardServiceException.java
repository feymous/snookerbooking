package com.sacredminds.snookerbooking.boardservice.exceptionhandler;

public class BoardServiceException extends Exception {

	private static final long serialVersionUID = -1315519600481257190L;

	private final int code;
	private final String message;

	public BoardServiceException(int code, String message) {
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
