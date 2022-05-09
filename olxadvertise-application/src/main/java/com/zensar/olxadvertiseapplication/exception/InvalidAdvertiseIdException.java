package com.zensar.olxadvertiseapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class InvalidAdvertiseIdException extends Exception {
	
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidAdvertiseIdException(String message) {
		super(message);
		//this.message = message;

}
}