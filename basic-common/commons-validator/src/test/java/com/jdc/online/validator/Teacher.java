package com.jdc.online.validator;

import com.jdc.online.validator.annotation.MinLength;
import com.jdc.online.validator.annotation.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

	@MinLength(5)
	private String name;
	
	@NotNull
	private String course;
}
