package com.jdc.online.pos.model.input;

import com.jdc.online.validator.annotation.MinValue;
import com.jdc.online.validator.annotation.NotBlank;


public record ProductForm(
		
		@NotBlank( message = "Please enter product name")
		String name,
		
		@MinValue(value = 100 , message = "Please enter price with min 100")
		int price
		) {

}
