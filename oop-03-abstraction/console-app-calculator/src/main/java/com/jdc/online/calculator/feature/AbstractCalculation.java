package com.jdc.online.calculator.feature;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;

public abstract class AbstractCalculation extends AbstractFeature{

	public AbstractCalculation(int id, String name) {
		super(id, name);
		
	}
	@Override
	public void doBusiness() {
		int digit1 = getDigitOne();
		
		int digit2 = getDigitTwo();
		
		calculateAndShowResult(digit1, digit2);
	}
	
	protected abstract void calculateAndShowResult(int digit1, int digit2);
	
	
	private int getDigitOne() {
		return UserInputs.readInt("Digit 1 : ");
	}
	private int getDigitTwo() {
		return UserInputs.readInt("Digit 2 : ");
	}
	
	
}
