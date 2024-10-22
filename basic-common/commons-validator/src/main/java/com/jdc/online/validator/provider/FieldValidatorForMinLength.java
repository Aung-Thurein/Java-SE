package com.jdc.online.validator.provider;

import java.lang.reflect.Field;

import com.jdc.online.validator.FieldError;
import com.jdc.online.validator.annotation.MinLength;

public class FieldValidatorForMinLength extends AbstractFieldValidator {

	@Override
	public FieldError validate(Field field, Object object) {
		
		try {
			MinLength annotation = field.getDeclaredAnnotation(MinLength.class);

			if( null != annotation && isStringType(field)) {
				field.setAccessible(true);
				
				Object value = field.get(object);
				
				if(null == value || isViolate(value, annotation)) {
					return new FieldError(field.getName(), annotation.message());
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private boolean isViolate(Object value, MinLength annotation) {

		return value.toString().length() < annotation.value();
	}

}
