package com.jdc.basic.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CreateFromCollections {

	@Test
	void test_from_array() 
	{	
		int [] arr = new int[] {1,2,3,4,5};
		
		IntStream stream = Arrays.stream(arr);

		System.out.println(stream.sum());
	}
	
	@Test
	void test_from_list() 
	{
		List<Integer> list = List.of(1,2,3,4,5);
		
		Stream<Integer> stream = list.stream();
		
		System.out.println(stream.mapToInt(a -> a).sum());
	}
}
