package com.jdc.pattern.switchs.statement;

public class SwitchStatementDemo {

	public static void showAreaInstanceofTypePattern(Shape shape) {
		if(shape instanceof Rectangle r) {
				System.out.println(r.base() * r.height());
		}else if(shape instanceof Square r) {
			System.out.println(r.base() * r.base());
		}else if(shape instanceof Traingle r) {
			System.out.println(r.base() * r.height() / 2);
		}
	}
	
	public static void showAreaInstancofRecordPattern(Shape shape) {
		if(shape instanceof Rectangle (var b, var h)) {
			System.out.println(b * h);
		}else if(shape instanceof Square (var b)) {
			System.out.println(b * b);
		}else if(shape instanceof Traingle (var b, var h)) {
			System.out.println(b * h /2);
		}
	}
	
	public static void showAreaSwitchTypePattern(Shape shape) {
		switch(shape) {
		case Rectangle r-> System.out.println(r.base() * r.height()); 
		case Square r -> System.out.println(r.base() * r.base());
		case Traingle r -> System.out.println(r.base() * r.height() / 2);
		default -> throw new IllegalArgumentException();
		}
	}
	
	public static void showAreaSwitchRecordPattern(Shape shape) {
		switch(shape) {
		case Rectangle (var b, var h) -> System.out.println(b * h);
		case Square (var b) -> System.out.println(b * b);
		case Traingle(var b, var h) -> System.out.println(b * h / 2);
		default -> throw new IllegalArgumentException();
		}
	}
}

