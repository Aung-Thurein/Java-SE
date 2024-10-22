package com.jdc.basic.streams.intermidiate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Product;

public class SortingStreamElement {
	@Test
	void test_sort_integer()
	{
		ThreadLocalRandom random = ThreadLocalRandom.current();
	List<Integer> list = Stream.generate(() -> random.nextInt(1,100))
		.limit(10)
		.peek(data -> System.out.printf("Before -> %d%n",data))
		.sorted()
		.peek(data -> System.out.printf("After -> %d%n",data))
		.toList();
	
	System.out.println(list);
	}
	
	@Test
	void test_custom_object()
	{
		
		try (Stream<String> stream = Files.lines(Path.of("data","product","product1.txt")))
		{						
			List<Product> list = stream.map(line -> line.split("\t"))
					.map(Product::From)
					.sorted((a,b) -> a.name().compareTo(b.name()))
					.toList();
					
		System.out.println(list);
		
		}
		catch (Exception e) 
		{
			
		}
	}
	}

