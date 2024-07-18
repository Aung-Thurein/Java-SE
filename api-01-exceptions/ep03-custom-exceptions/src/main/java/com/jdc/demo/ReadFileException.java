package com.jdc.demo;

public class ReadFileException extends RuntimeException{

	private Level level;
	public ReadFileException(Level level, String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
		this.level = level; 
	}

	public ReadFileException(Level level, String message) {
		super(message);
		// TODO Auto-generated constructor stub
		this.level = level;
	}
	
	
	public ReadFileException(String message) {
		super(message);
		this.level = level.Error;	
	}

	public Level getLevel() {
		return level;
	}
	
	public enum Level{
		Info,Warning, Error
	}

	
}
