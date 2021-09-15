package com.rest.util;

public class AlreadyExistingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Record Already Existing";
	}
	
	public String toString() {
		return getMessage();

  }
}
