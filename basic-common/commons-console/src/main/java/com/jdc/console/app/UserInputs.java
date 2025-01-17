package com.jdc.console.app;

import java.util.Scanner;

import com.jdc.console.app.exceptions.ConsoleAppException;

public class UserInputs {
	
	public static final Scanner scanner = new Scanner(System.in);
	
	public static int readInt(String string) {
		try {
			var result = readString(string);
			return Integer.parseInt(result);
			
		} catch (Exception e) {
			throw new ConsoleAppException("Please enter %s with digit".formatted(string), e);
		}
	}

	public static String readString(String string) {
		System.out.printf("%s : ", string);
		return scanner.nextLine();
	}

	public static int readInt(int size, String string) {
	try {
		var result = readString(size, string);
		return Integer.parseInt(result);
		
	} catch (Exception e) {
		throw new ConsoleAppException("Please enter %s with digit".formatted(string), e);
	}
	
}
	
	public static String readString(int size, String string) {
	
		var message = "%%-%ds ".formatted(size).formatted(string);
		return readString(message);
	}
	
	
}
