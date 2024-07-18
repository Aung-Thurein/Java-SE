package com.jdc.pattern.switchs.expression;

import com.jdc.pattern.switchs.statement.Rectangle;
import com.jdc.pattern.switchs.statement.Shape;
import com.jdc.pattern.switchs.statement.Square;
import com.jdc.pattern.switchs.statement.Traingle;

public class SwitchExpressionDemo {

	
	public static double getAreaTypePattern(Shape shape) {
		return switch(shape) {
		case Rectangle r -> r.base() * r.height();
		case Square r -> r.base() * r.base();
		case Traingle r -> r.base() * r.height() / 2;
		
		default -> throw new IllegalArgumentException();
		};
	}
	
	public static double getAreaRecordPattern(Shape shape) {
		return switch(shape) {
		case Rectangle (var b, var h) -> b * h;
		case Square (var b) -> b * b;
		case Traingle(var b, var h) -> b * h / 2;
		default -> throw new IllegalArgumentException();
		};
	}
}
