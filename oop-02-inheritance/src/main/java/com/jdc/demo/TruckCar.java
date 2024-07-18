package com.jdc.demo;

public class TruckCar extends Car{
	
	{
		System.out.println("Init Block of Truck Car");
	}
	
	public TruckCar() {
		super("Truck Car");
		System.out.println("Default constructor of Truck Car");
		
	}
	
	public void loading() {
		System.out.println("Truck Car is loading");
	}

}
