package com.jdc.demo.compose;

public class AdderApplication  {
	
	private Calculator calc;
	
	public AdderApplication(Calculator clac) {
	
		super();
		this.calc = clac;
		
	}
	
	public void showAddResult(int a, int b) {
		
		var result = calc.add(a, b);
		System.out.printf("%s + %s = %s%n" , a ,b,result);
	}
	
	

}
