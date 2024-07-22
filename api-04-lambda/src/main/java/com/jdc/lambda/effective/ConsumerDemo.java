package com.jdc.lambda.effective;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
	Consumer<String> printSmall = str -> System.out.println(str.toLowerCase());
	Consumer<String> printBig = str -> System.out.println(str.toUpperCase());
	
	Consumer<String> reverse = str -> System.out.println(
			new StringBuilder(str).reverse().toString()
			);
	
	Consumer<String> andThen = printSmall.andThen(printBig).andThen(reverse);
	
	List.of("Hello","Java","Spring","Angular","Microservices").forEach(andThen);
	
	
		
	}
}
