package com.jdc.basic.streams;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CreateFromBuilder {

	@Test
	void test_builder()
	{
		Stream<Object> stream = Stream.builder()
				.add("Java")
				.add("Lambda Expression")
				.add("Stream API")
				.build();
	
		stream.forEach(System.out::println);
	}
	
}
