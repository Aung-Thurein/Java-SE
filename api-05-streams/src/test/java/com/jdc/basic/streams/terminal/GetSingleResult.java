package com.jdc.basic.streams.terminal;

import java.lang.foreign.Linker.Option;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Product;

public class GetSingleResult {

	@Test
	void test_max()
	{
		try (Stream<String> stream = Files.lines(Path.of("data","product","product1.txt")))
		{						
			Optional<Product> max = stream.map(line -> line.split("\t"))
					.map(Product::From)
					.max((a,b) -> a.price() - b.price());
		
			max.ifPresent(product -> System.out.println(product));
					
		
		
		}
		catch (Exception e) 
		{
			
		}
	}
	
	@Test
	void test_min()
	{
		try (Stream<String> stream = Files.lines(Path.of("data","product","product1.txt")))
		{						
			Optional<Product> min = stream.map(line -> line.split("\t"))
					.map(Product::From)
					.min((a,b) -> a.price() - b.price());
		
			min.ifPresent(product -> System.out.println(product));
					
		
		
		}
		catch (Exception e) 
		{
			
		}
	}
	
	@Test
	void test_find_first()
	{
		try (Stream<String> stream = Files.lines(Path.of("data","product","product1.txt")))
		{						
			Optional<Product> findFirst = stream.map(line -> line.split("\t"))
					.map(Product::From)
					.findFirst();
		
			findFirst.ifPresent(product -> System.out.println(product));
					
		
		
		}
		catch (Exception e) 
		{
			
		}
	}
}

