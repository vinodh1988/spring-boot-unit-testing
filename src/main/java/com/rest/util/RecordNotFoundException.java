package com.rest.util;

public class RecordNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Record Not Found Exception";
	}
	
	public String toString() {
		return getMessage();

  }
}
