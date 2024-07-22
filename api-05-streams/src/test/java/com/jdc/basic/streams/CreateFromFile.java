package com.jdc.basic.streams;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class CreateFromFile {
	@Test
	void test_form_file() 
	{
		try(Stream<String> stream = Files.lines(Path.of("data","poem.txt"))) {
			
			stream.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
