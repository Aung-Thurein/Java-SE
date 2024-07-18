package com.jdc.pattern.generics;

import java.sql.Date;

public class UsingPair {

	//record pattern
	public static void use(PairInf<String, Date> pair) {
		if(pair instanceof Pair(var key, var value)) {
			
		}
	}
	
	public static void use(Container<Container<String>> data) {
		if(data instanceof Container(Container(var value))) {
			System.out.println(value);
		
		}
	}
}
