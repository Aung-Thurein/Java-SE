package com.jdc.basic.streams;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class CreateFromGenerater {

	@Test
	void test_generate()
	{
		ThreadLocalRandom random = ThreadLocalRandom.current();
		IntStream stream = IntStream.generate(() -> random.nextInt(1,9999));
		
		stream.mapToObj(a -> "%04d".formatted(a)).limit(10).forEach(System.out::println);
	}
}
