package com.jdc.online.validator;

import com.jdc.online.validator.annotation.MaxLength;
import com.jdc.online.validator.annotation.MinLength;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Student {

	@MinLength(5)
	@MaxLength(10)
	private String name;
	
	
	@MinLength(5)
	@MaxLength(10)
	private String phone;
	
	@MinLength(5)
	@MaxLength(10)
	private String email;
	
}
