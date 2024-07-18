package com.jdc.online.validator.provider;

import java.lang.reflect.Field;

import com.jdc.online.validator.FieldError;
import com.jdc.online.validator.annotation.NotNull;

public class FieldValidatorForNotNull extends AbstractFieldValidator {

	@Override
	public FieldError validate(Field field, Object object) {
		
		NotNull annotation = field.getDeclaredAnnotation(NotNull.class);
		
		try {
			if(null != annotation) {
				field.setAccessible(true);
				
				Object value = field.get(object);
				
				if(null == value) {
					
					return new FieldError(field.getName(), annotation.message());
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
