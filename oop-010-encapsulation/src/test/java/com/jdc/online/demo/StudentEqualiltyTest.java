package com.jdc.online.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class StudentEqualiltyTest {
	 
	@Order(1)
	@ParameterizedTest
	@CsvFileSource(resources = "/students.txt")
	void test_add_student(int id, String name, String phone, String email) {
		var students1 = new Student(id, name, phone, email);
		var students2 = new Student(id, name ,phone, email);
		
		System.out.println(students1);
		System.out.println(students2);
		 assertTrue(students1.equals(students2));
	}
	

}
