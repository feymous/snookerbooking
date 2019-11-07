package com.sacredminds.snookerbooking.datamodel;

public enum Error {
	DATABASE(0, "A database error has occured."), 
	DUPLICATE_USER(1, "This user already exists."),
	SERVICE_ERROR(2,"System error or runtime exception occurred in service layer"),
	NO_RECORDS(204,"No records found !!!"),
	CONTROLLER_ERROR(4,"System error or runtime exception occurred in controller layer"),
	PARSE_EXCEPTION(5,"Parse Exception Occured"),
	DUPLICATE_INTERVIEW(208,"This record already exists."),
	UNAUTHORISED(403,"Unauthorized request. You don't have permission to access this.");
	
	private final int code;
	private final String description;

	private Error(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}
}