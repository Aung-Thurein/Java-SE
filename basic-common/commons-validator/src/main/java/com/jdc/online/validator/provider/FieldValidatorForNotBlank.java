package com.jdc.online.validator.provider;

import java.lang.reflect.Field;

import com.jdc.online.validator.FieldError;
import com.jdc.online.validator.annotation.NotBlank;

public class FieldValidatorForNotBlank extends AbstractFieldValidator {

	@Override
	public FieldError validate(Field field, Object object) {
		NotBlank annotation = field.getDeclaredAnnotation(NotBlank.class);
		
		try {
			
			if(null != annotation && isStringType(field)) {
				field.setAccessible(true);
				
				Object value = field.get(object);
				
				if(value == null || isViolate(object, annotation)) {
					return new FieldError(field.getName(), annotation.message());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean isViolate(Object value, NotBlank annotation) {
		return value.toString().isBlank();
	}

}
