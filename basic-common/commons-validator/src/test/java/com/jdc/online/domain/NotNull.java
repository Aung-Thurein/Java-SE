package com.jdc.online.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.online.validator.Teacher;
import com.jdc.online.validator.Validator;

public class NotNull {

	private Validator validator = Validator.getInstance();
			
	@ParameterizedTest
	@CsvSource({
		"Mya Mya , Myanmar"
	})
	public void test_notnull_success(String name, String course) {
		Teacher input = new Teacher(name, course);
		
		var result = validator.validate(input);
		
		assertFalse(result.hasError());
	}
	
	@ParameterizedTest
	@CsvSource({
		", "
	})
	public void test_notnull_fail(String name, String course) {
		Teacher input = new Teacher(name, course);
		
		var result = validator.validate(input);
		
		assertTrue(result.hasError());
		
		assertEquals(2, result.getErrors().length);
	}

}
