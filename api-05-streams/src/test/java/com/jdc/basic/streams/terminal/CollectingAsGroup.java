package com.jdc.basic.streams.terminal;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Sale;

public class CollectingAsGroup {

	@Test
	void test_group_by_category()
	{
		
		try (Stream<String> stream = Files.lines(Path.of("data","sales.txt"))){
			System.out.println("""
					---------------------
					Group by Category
					---------------------
					""");
			
			Map<String, List<Sale>> result = stream.map(line -> line.split("\t"))
				.map(Sale::From)
				.collect(Collectors.groupingBy(Sale::category));
			
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void test_group_by_product()
	{
		try (Stream<String> stream = Files.lines(Path.of("data","sales.txt"))){
			
			System.out.println("""
					---------------------
					Group by Product
					---------------------
					""");
		Map<String, List<Sale>> result = stream.map(line -> line.split("\t"))
			.map(Sale::From)
			.collect(Collectors.groupingBy(Sale::product));
		
		System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void group_by_sale_date()
	{
		try (Stream<String> stream = Files.lines(Path.of("data","sales.txt"))){
			
			System.out.println("""
					---------------------
					Group by Sale Date
					---------------------
					""");
			Map<LocalDate, List<Sale>> result = stream
					.map(line -> line.split("\t"))
					.map(Sale::From)
					.collect(Collectors.groupingBy(sale -> sale.SateAt().toLocalDate()));
			
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
