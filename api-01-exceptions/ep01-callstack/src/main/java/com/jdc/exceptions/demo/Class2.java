package com.jdc.exceptions.demo;

public class Class2 {

	private Class3 instance;
	
	public Class2() {
	instance = new Class3();	
	}
	
	public int divide(int a, int b) {
		System.out.println("Class 2 Work");
		
		int value = instance.divide(a, b);
		
		System.out.println("Class2 end");
		
		return value;
	}
}
