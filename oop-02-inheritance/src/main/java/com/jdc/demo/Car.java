package com.jdc.demo;

public class Car {
	
private String type;
	
	{
		System.out.println("Init Block of Car");
	}
	
	
	public Car(String type) {
		super();
		this.type = type;
		System.out.println("Default constructor of Car");
		
		
	}
	
	public Car() {
		super();
		this.type = "Car";
		System.out.println("One Argument Constructor of Car");
		
	}
	
	
	public void drive() {
		System.out.printf("%s is driving%n",type);
		
	}
	
	public void park() {
		System.out.printf("%s is parking%n",type);
	}
	

}
