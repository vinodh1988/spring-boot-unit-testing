package com.rest.util;

public class UnluckyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Unlucky Exception";
	}
	
	public String toString() {
		return getMessage();
	}

}
