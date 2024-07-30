package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Sale;

public class CollectionAsCollection {

	@Test
	void test_to_list()
	{

		
		Stream<Integer> stream = Stream.iterate(1, a -> a + 1)
				.limit(10);
		
//		stream.toList();
		
		List<Integer> result = stream.collect(() -> new ArrayList<Integer>(),   // supplier
							(list,element) -> list.add(element),			// accumulator
							(first, second) -> first.addAll(second));		//combiner
		
	 System.out.println(result);
		
	}
	@Test
	void test_to_list_with_collectors()
	{

		
		Stream<Integer> stream = Stream.iterate(1, a -> a + 1)
				.limit(10);
		
		List<Integer> result = stream.collect(Collectors.toList());
		
		System.out.println(result);
	}
	@Test
	void test_to_map()
	{
		try (Stream<String> stream = Files.lines(Path.of("data","sales.txt"))){
			
		
		Map<Integer,Sale> result = stream.map(line -> line.split("\t"))
			.map(Sale::From)
			.collect(Collectors.toMap(
					Sale::id, 
					UnaryOperator.identity() ));  // t - return t;
			
		System.out.println(result);
		} catch (IOException e) {

		}
	}
	
	
	@Test
	void test_to_collection()
	{
		try (Stream<String> stream = Files.lines(Path.of("data","sales.txt"))){
			
			
		var result = stream.map(line -> line.split("\t"))
				.map(Sale::From)
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
		
		
		System.out.println(result);
		} catch (IOException e) {

		}
		
	}
	
}
