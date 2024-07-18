package com.jdc.demo;

import org.junit.jupiter.api.Test;

public class CustomExceptionTest {

	@Test
	public void test() {
		try {
			var instance = new ReadFileAndShowLines();
			instance.readAndShow("test.txt");
	
		} catch (Exception e) {
				e.printStackTrace();
		}	
	}
}
