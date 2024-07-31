package com.jdc.legacy.io.file;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.TextFileReader;

public class TextFileReaderTest {

	@Test
	void test()
	{
		TextFileReader service = new TextFileReader();
		
		List<String> list = service.read("worksapce/data.txt");
		
		System.out.println(list);
	}
}
