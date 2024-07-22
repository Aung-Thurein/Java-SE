package com.jdc.basic.streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CreateFromIteration {
	@Test
	void test_int_stream()
	{
		System.out.println("Iterate With limit");
		IntStream stream = IntStream.iterate(1, a -> a + 1);
		
		String result = stream.limit(10).mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(","));
		
		System.out.println(result);

		System.out.println("Iterate with predicate");

		stream = IntStream.iterate(1, a -> a <= 10, a -> a + 1);
			
		result = stream.mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(","));
		
		System.out.println(result);
	
	}
	
	@Test
	void test_generic_stream()
	{
		Stream<String> stream = Stream.iterate(".", a -> a.length() <= 10, a -> a + "." );
		
		stream.forEach(System.out::println);
		
	}
}
