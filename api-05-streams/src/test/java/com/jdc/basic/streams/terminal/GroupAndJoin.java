package com.jdc.basic.streams.terminal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Sale;

public class GroupAndJoin {

	
	@Test
	void test_joining_product()
	{
		try(Stream<String> stream = Files.lines(Path.of("data","sales.txt")))
		{
			var result = stream.map(line -> line.split("\t"))
					.map(Sale::From)
					.map(Sale::product)
					.distinct()
					.sorted()
					.collect(Collectors.joining(","));
			
			System.out.println(result);
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test
	void test_group_and_join()
	{
		try(Stream<String> stream = Files.lines(Path.of("data","sales.txt")))
		{
			var result = stream.map(line -> line.split("\t"))
					.map(Sale::From)
					.collect(
							Collectors.groupingBy(
									Sale::category, 
									Collectors.mapping(Sale::product, Collectors.joining(","))));
					
			System.out.println(result);
		}
		catch(Exception e)
		{
			
		}	
	}
}
