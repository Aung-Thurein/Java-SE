package com.jdc.basic.streams.terminal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Sale;

public class PartitioningStreamElement {

	@Test
	void test_partition()
	{
		try(Stream<String> stream = Files.lines(Path.of("data","sales.txt")))
		{ 
			System.out.println("""
					-----------------------
					Partitioning
					-----------------------
						""");
			
			var result = stream
			.map(line -> line.split("\t"))
			.map(Sale::From)
			.collect(Collectors.partitioningBy(sale -> sale.getTotal() < 10000));
			
		System.out.println(result);
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test
	void test_partition_downstream()
	{
		try(Stream<String> stream = Files.lines(Path.of("data","sales.txt")))
		{ 
			System.out.println("""
					-----------------------
					Partitioning DownStream
					-----------------------
						""");
			
			var result = stream
					.map(line -> line.split("\t"))
					.map(Sale::From)
					.collect(Collectors.partitioningBy(
							sale -> sale.getTotal() < 10000,
							
							Collectors.groupingBy(
							Sale::category,
							Collectors.reducing(0, sale -> sale.getTotal(), (a,b) -> a + b))
					
					));
			
		System.out.println(result);
			
		}
		catch(Exception e)
		{
			
		}
	}
}
