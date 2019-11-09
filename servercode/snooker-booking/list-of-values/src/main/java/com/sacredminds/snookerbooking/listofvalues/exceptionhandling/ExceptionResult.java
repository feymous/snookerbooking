/**
 * 
 */
package com.sacredminds.snookerbooking.listofvalues.exceptionhandling;

public class ExceptionResult {

	private int errorCode;
	private String errorMessage;

	public ExceptionResult() {
	}

	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public ExceptionResult(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
