package com.jdc.demo.compose;

public class ComposeTest {
		
		@org.junit.jupiter.api.Test
		void Test()
		{
		var adder = new AdderApplication(new Calculator("Adding"));
		adder.showAddResult(110, 5);
			
		}
}
