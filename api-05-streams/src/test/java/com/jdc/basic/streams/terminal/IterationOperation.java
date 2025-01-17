package com.jdc.basic.streams.terminal;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class IterationOperation {
	@Test
	void test_for_each()
	{
		System.out.println("For Each Sequential Stream");
		IntStream.rangeClosed(1, 10)
		.forEach(System.out::println);
		
		System.out.println("For EachParallel Stream");
		IntStream.rangeClosed(1, 10).parallel()
		.forEach(System.out::println);
		
	}	
	@Test
	void test_for_each_order()
	{
		System.out.println("For Each Order Parallel");
		IntStream.rangeClosed(1, 10).parallel()
		.forEachOrdered(System.out::println);
	}
}
