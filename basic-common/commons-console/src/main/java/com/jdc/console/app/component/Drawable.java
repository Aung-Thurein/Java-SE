package com.jdc.console.app.component;

public interface Drawable {
	void draw();
	default void drawLine(int size) {
		for (int i = 0; i < size; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
