package com.jdc.online.calculator;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.ConsoleApplication;
import com.jdc.online.calculator.feature.*;

public class CalculatorApplication {
	
	public static void main(String[] args) {
		ConsoleApplication application = new ConsoleApplication("Calculator", 
				new FeatureForAdding(1),
				new FeatureForSubstraction(2),
				new FeatureForMultilplication(3),
				new FeatureForDivision(4)
);
		application.launch();
	}

}
