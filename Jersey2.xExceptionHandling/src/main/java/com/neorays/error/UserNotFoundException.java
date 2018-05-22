package com.neorays.error;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super();
	}//constructor
	
	public UserNotFoundException(String msg) {
		super(msg);
	}//constructor
}//class
