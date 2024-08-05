package com.jdc.legacy.io.file;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.FileCopier;

public class FileCopierTest {
	private FileCopier copier;
	
	@BeforeEach
	public void init()
	{
		copier = new FileCopier();
	}
	
	@Test
	public void test_copy_file()
	{
		var input = new File("original","OODesign.pdf");
		assertTrue(input.exists());
		
		var copy = new File("copy","OODesign.pdf");
		copy.delete();
		assertFalse(copy.exists());
		
		var result = copier.copy(input, copy);
		assertTrue(result);
		
		assertTrue(copy.exists());
	}
}
