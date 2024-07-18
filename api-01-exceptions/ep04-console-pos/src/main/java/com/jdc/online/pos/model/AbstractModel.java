package com.jdc.online.pos.model;

import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.online.validator.ValidationResult;
import com.jdc.online.validator.Validator;

public abstract class AbstractModel {
	
	private static Validator validator;
	
	static {
		validator = Validator.getInstance();
	}

	protected void validate(Object data) {
		ValidationResult result = validator.validate(data);
	
		if(result.hasError()) {
		
			String [] messages = new String[result.getErrors().length];
			
			for(int i = 0; i < messages.length ; i++) {
				messages[i] = result.getErrors()[i].getMessage();
				
			}
			throw new ValidationException(messages);
		}
	}
	
}
