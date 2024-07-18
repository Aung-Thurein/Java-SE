package com.jdc.console.app.exceptions;

public class InvalidComponentDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String component;
	public InvalidComponentDataException(String componet,String message) {
		super(message);
		this.component = component;
	}
	
	public String getComponet() {
		return component;
	}

	
}
