package com.jdc.online.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.online.validator.Student;
import com.jdc.online.validator.Validator;

public class StringValidationTest {

	private Validator validator = Validator.getInstance();
	
	@ParameterizedTest
	@CsvSource({
		"maung,123456,maung@.com"
	})
	public void test_success(String name, String phone, String email) {
		
		Student input = new Student(name, phone, email);
		
		var result = validator.validate(input);
		
		assertFalse(result.hasError());
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"maun,12345623123131, "
	})
	public void test_fail(String name, String phone, String email) {
		
		Student input = new Student(name, phone, email);
		
		var result = validator.validate(input);
		
		assertTrue(result.hasError());
		
		
		assertEquals(3, result.getErrors().length);
	}
	
	
	
}
