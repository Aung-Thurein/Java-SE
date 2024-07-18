package com.jdc.online.validator.provider;

import java.lang.reflect.Field;

import com.jdc.online.validator.FieldValidator;

public abstract class AbstractFieldValidator implements FieldValidator {
	
	protected boolean isStringType(Field field) {
		return field.getType() == String.class;
	}
	
	protected boolean isIntegerType(Field field) {
		return field.getType() == byte.class
				|| field.getType() == short.class
				|| field.getType() == Integer.class
				|| field.getType() == Long.class
				;
	}

}
