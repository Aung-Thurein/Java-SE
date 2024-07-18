package com.jdc.online.validator;

import com.jdc.online.validator.annotation.NotBlank;
import com.jdc.online.validator.annotation.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class NotBlankTestObject {

	@NotBlank
	private String name;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String email;
	
}
