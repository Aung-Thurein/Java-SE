package com.jdc.basic.streams.intermidiate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Product;

public class MappingElements {

	@Test
	void test_map()
		{
			try (Stream<String> stream = Files.lines(Path.of("data","product","product1.txt")))
			{						
				List<Product> list = stream.map(line -> line.split("\t"))
						.map(Product::From)
						.toList();
						
			System.out.println(list);
			
			}
			catch (Exception e) 
			{
				
			}
		}
	
	
	
	@Test
	void test_flat_map()
		{
			try (Stream<String> stream1 = Files.lines(Path.of("data","product","product1.txt"));
					Stream<String> stream2 = Files.lines(Path.of("data","product","product2.txt"))
					)
			{						
				List<Product> list = Stream.of(stream1,stream2)
						.flatMap(stream -> stream)
						.map(line -> line.split("\t"))
						.map(Product::From)
						.toList();
						
			System.out.println(list);
			
			}
			catch (Exception e) 
			{
				
			}
		}
	
		@Test
		void test_map_multi()
		{
			try (Stream<String> stream = Files.lines(Path.of("data","product","product1.txt")))
			{						
				List<String> list = stream.map(line -> line.split("\t"))
						.map(Product::From)
						.mapMulti( (Product p, Consumer<String> consumer) ->
						{
							if(p.price()> 10)
							{
								consumer.accept(p.name());
							}
						})
						
						.toList();
						
			System.out.println(list);
			
			}
			catch (Exception e) 
			{
				
			}
		}
	
	
	}


