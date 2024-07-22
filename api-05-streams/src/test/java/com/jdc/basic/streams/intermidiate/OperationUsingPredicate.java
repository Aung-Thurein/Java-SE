package com.jdc.basic.streams.intermidiate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class OperationUsingPredicate {
	@Test
	void test_take_while()
	{
		System.out.println("Take While");
		String result = IntStream.iterate(1, a -> a + 1) //Stream Creation
				.takeWhile(a -> a <= 10)				//Intermediate Operation
				.mapToObj(a -> String.valueOf(a))		//Intermediate Operation
				.collect(Collectors.joining(","));		//Terminal Operation
		
		System.out.println(result);
	}
	
	@Test
	void test_drop_while()
	{
		System.out.println("Drop While");
		String result = IntStream.iterate(1, a -> a + 1) //Stream Creation
				.dropWhile(a -> a <= 10)				//Intermediate Operation
				.limit(10)                               //Intermediate Operation
				.mapToObj(a -> String.valueOf(a))		//Intermediate Operation
				.collect(Collectors.joining(","));		//Terminal Operation
		
		System.out.println(result);
		
	}
	
	@Test
	void test_filter()
	{
		System.out.println("Filter");
		String result = IntStream.iterate(1, a -> a + 1)		//Stream Creation
				.filter(a -> a % 2 != 0)						//Intermediate Operation
				.skip(5)
				.limit(10)										//Intermediate Operation
				.mapToObj(a -> String.valueOf(a))				//Intermediate Operation
				.collect(Collectors.joining(","));				//Terminal Operation
		
		System.out.println(result);
		
	}
}
