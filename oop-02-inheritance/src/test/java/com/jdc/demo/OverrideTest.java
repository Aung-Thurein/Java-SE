package com.jdc.demo;

import org.junit.jupiter.api.Test;

public class OverrideTest {
	
	@Test
	void test() {
		Car car1 = new Car();
		Car car2 = new RaceCar();
		
		test(car1);
		System.out.println("=================");
		test(car2);
		
		
	}

	void test (Car car) {
	
		car.drive();
		
	}
}
