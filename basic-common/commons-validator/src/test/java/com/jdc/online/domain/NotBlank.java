package com.jdc.online.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.online.validator.NotBlankTestObject;
import com.jdc.online.validator.Validator;

public class NotBlank {

	private Validator validator = Validator.getInstance();

	@ParameterizedTest
	@CsvSource({
		"Hla hla, 5454234234,hlahla@gmail.com"
	})
	public void test_notBlank_success(String name, String phone, String email) {
		
		NotBlankTestObject input = new NotBlankTestObject(name, phone, email);
		
		var result = validator.validate(input);
		
		assertFalse(result.hasError());
	}
	
	@ParameterizedTest
	@CsvSource({
		"Hla hla, 5454234234"
	})
	public void test_notBlank_fail1(String name, String phone) {
		
		NotBlankTestObject input = new NotBlankTestObject(name, phone, null);
		
		var result = validator.validate(input);
		
		assertTrue(result.hasError());
		
		assertEquals(1, result.getErrors().length);
	}
	
	@ParameterizedTest
	@CsvSource({
		" , , "
	})
	public void test_notBlank_fail2(String name, String phone,String email) {
		
		NotBlankTestObject input = new NotBlankTestObject(name, phone, email);
		
		var result = validator.validate(input);
		
		assertTrue(result.hasError());
		
		assertEquals(3, result.getErrors().length);
	}

}


