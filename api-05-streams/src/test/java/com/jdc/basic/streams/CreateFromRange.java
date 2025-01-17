package com.jdc.basic.streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CreateFromRange {
	@Test
	void test_range()
	{
		System.out.println("Range");
		IntStream stream = IntStream.range(1, 5);
		
		String result = stream.mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(","));
		System.out.println(result);
		
	}
	
	@Test
	void test_range_closed()
	{
		System.out.println("Range closed");
		
		IntStream stream = IntStream.rangeClosed(1, 5);
		
		String result = stream.mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(","));
		
		System.out.println(result);
	}
}
