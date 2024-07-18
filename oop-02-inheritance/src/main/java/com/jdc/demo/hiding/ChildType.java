package com.jdc.demo.hiding;

public class ChildType extends SuperType {
	public void showFromChild() {
		System.out.printf("Instance Variable %s %n",instanceVariable);
		System.out.printf("Static Variable %s %n ",staticVariable);
		
		doStaticMethod();
	
	}
	protected String instanceVariable = "Variable From Child";
	protected static String staticVariable = "Static Variable From Child";
	
	
		public static void doStaticMethod() {
		System.out.println("Static Method From Child");
		
	}
	
	public void chilFromHidingMembers() {
		System.out.printf("Instance Variable %s %n",super.instanceVariable);
		System.out.printf("Static Variable %s %n ",SuperType.staticVariable);
		
		SuperType.doStaticMethod();
		
	}
}
