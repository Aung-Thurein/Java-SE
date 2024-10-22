package com.jdc.online.problem;

import java.util.Stack;

public class BalanceChecker {

	Stack<Character> stack = new Stack<>();
	private Character scannedChar;

	public boolean isBalance(String value) {
	
		if(value.length() == 0) {
			throw new IllegalArgumentException();

		}
		for (int i = 0; i < value.length(); i++) {
			scannedChar = value.charAt(i);
		
			
			
			if (isOpening(scannedChar)) {
				stack.push(scannedChar);
			}

			if (isClosing(scannedChar)) {

				if (!stack.isEmpty()) {

					char pop = stack.pop();
					if (isOpenBracket(pop, scannedChar) || isCurlyBracket(pop, scannedChar)
							|| isDBracket(pop, scannedChar)) {

						if (i < value.length() - 1) {
							continue;
						} else {
							if (stack.isEmpty()) {
								return true;
							} else {
								return false;
							}
						}
					}
				} else {
					return false;
				}
			}

			if (isOperand(scannedChar)) {
				throw new IllegalArgumentException();

			}
			if (isSpace(scannedChar)) {
				throw new IllegalArgumentException();
			}
			
		}
	
		return false;

		
	}
	
	public boolean isBlank(Character value) {
	    return value == null || Character.isWhitespace(value);
	}

	public boolean isOperand(char value) {
		return Character.isDigit(value);
	}

	public boolean isSpace(char value) {
		return value == ' ';
	}

	public boolean isOpening(char value) {
		return value == '(' || value == '[' || value == '{';
	}

	public boolean isClosing(char value) {
		return value == ')' || value == ']' || value == '}';
	}

	public boolean isOpenBracket(char value1, char value2) {
		return value1 == '(' && value2 == ')';
	}

	public boolean isCurlyBracket(char value1, char value2) {
		return value1 == '{' && value2 == '}';
	}

	public boolean isDBracket(char value1, char value2) {
		return value1 == '[' && value2 == ']';
	}
}
