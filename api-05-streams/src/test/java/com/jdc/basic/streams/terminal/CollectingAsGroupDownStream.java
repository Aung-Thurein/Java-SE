package com.jdc.basic.streams.terminal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Sale;

public class CollectingAsGroupDownStream {

	
	@Test
	void test_group_and_collect_product()
	{
		try(Stream<String> stream = Files.lines(Path.of("data","sales.txt"))){
			
			System.out.println("""
					--------------------------------------
					Group By Category and Collect product
					--------------------------------------
					""");
			
			var result = stream.map(line -> line.split("\t"))
					.map(Sale::From)
					.collect(Collectors.groupingBy(
							Sale::category, 
							Collectors.mapping(Sale::product, Collectors.toCollection(() -> new TreeSet<>()))  //downStream Collector
							));
			
			System.out.println(result);
		}
		catch(Exception e)
		{
			
		}

	}
	
	@Test
	void test_group_and_collect_sum()
	{
		try(Stream<String> stream = Files.lines(Path.of("data","sales.txt")))
		{
			System.out.println("""
					-----------------------------------
					Group by sale Date and collect sum
					-----------------------------------
					""");
			
			var result = stream.map(line -> line.split("\t"))
					.map(Sale::From)
					.collect(Collectors.groupingBy(
							sale -> sale.SateAt().toLocalDate(), 
							Collectors.mapping(
									sale -> sale.Quantity() * sale.UnitPrice(), 
									Collectors.reducing((a,b) -> a + b))		//downStream Collector
							));
			
			System.out.println(result);
		}
		
		catch(Exception e)
		{
			
		}
	}
}
