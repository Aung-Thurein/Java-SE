package com.jdc.online.validator.provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.jdc.online.validator.FieldError;
import com.jdc.online.validator.annotation.MaxLength;

public class FieldValidatorForMaxLength extends AbstractFieldValidator{

	@Override
	public FieldError validate(Field field, Object object) {
		
		
		try {
			MaxLength annotation = field.getDeclaredAnnotation(MaxLength.class);
					
			if(null != annotation && isStringType(field)) {

				field.setAccessible(true);
				Object value = field.get(object);
				
			if(null != value && isViolate(value, annotation) ) {
				return new FieldError(field.getName(), annotation.message() );
			}
				
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private boolean isViolate(Object value, MaxLength annotation) {
		
	return value.toString().length() > annotation.value();
		
		
	}

	
	
}
