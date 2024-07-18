package com.jdc.online.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.online.validator.Numbers;
import com.jdc.online.validator.Validator;

public class MinMaxValidationTest {
	
	private Validator validator = Validator.getInstance();
	
	@ParameterizedTest
	@CsvSource(value = {
			
		"10,10,10,10",
		"100,100,100,100"
	})
	public void test_success(byte v1, short v2, int v3, long v4) {
		
		Numbers input = new Numbers(v1, v2, v3, v4);
		
		var result = validator.validate(input);
		
		assertFalse(result.hasError());
		
	}
	@ParameterizedTest
	@CsvSource(value = {
			
		"9,9,9,9",
		"101,101,101,101"
	})
	public void test_fail(byte v1, short v2, int v3, long v4) {
		Numbers input = new Numbers(v1, v2, v3, v4);
		
		var result = validator.validate(input);
		
		assertTrue(result.hasError());
	}
}
