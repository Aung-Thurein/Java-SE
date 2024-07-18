package com.jdc.exceptions.demo;

public class Class3 {

	public int divide (int a, int b) {
		try {
			System.out.println("Work3 start");
			
			int value = a / b;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Work 3 end");
		
		return 0;
	}
}
