package com.rest.util;

public class UnluckyException extends Exception {
	
	public String getMessage() {
		return "Unlucky Exception";
	}
	
	public String toString() {
		return getMessage();
	}

}
