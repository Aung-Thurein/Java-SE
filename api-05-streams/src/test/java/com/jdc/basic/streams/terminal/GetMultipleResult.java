package com.jdc.basic.streams.terminal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Product;

public class GetMultipleResult {

	@Test
	void test_to_array()
	{
		try (Stream<String> stream = Files.lines(Path.of("data","product","product1.txt")))
		{						
			Object[] array = stream.map(line -> line.split("\t"))
					.map(Product::From)
					.toArray();
					
			assertNotNull(array);
		
		}
		catch (Exception e) 
		{
			
		}
	}
	
	@Test
	void test_to_generic_array()
	{
		try (Stream<String> stream = Files.lines(Path.of("data","product","product1.txt")))
		{						
			Product[] array = stream.map(line -> line.split("\t"))
					.map(Product::From)
					.toArray(size -> new Product[size]);
					
			assertNotNull(array);
		
		}
		catch (Exception e) 
		{
			
		}
	}

}
