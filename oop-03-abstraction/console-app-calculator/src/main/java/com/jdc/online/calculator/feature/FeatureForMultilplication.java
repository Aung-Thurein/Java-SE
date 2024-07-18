package com.jdc.online.calculator.feature;

public class FeatureForMultilplication extends AbstractCalculation{

	public FeatureForMultilplication(int id) {
		super(id, "Multiplication Calculation");
		
	}

	@Override
	protected void calculateAndShowResult(int digit1, int digit2) {
		System.out.printf("%d * %d = %d",digit1, digit2, digit1 * digit2);
		
	}

	
	

}
