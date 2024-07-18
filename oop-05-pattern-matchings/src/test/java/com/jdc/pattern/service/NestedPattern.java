package com.jdc.pattern.service;

import org.junit.jupiter.api.Test;

import com.jdc.pattern.generics.Container;
import com.jdc.pattern.generics.UsingPair;

public class NestedPattern {

	@Test
	public void test() {
		Container<Container<String>> nested = new Container<>(new Container<>("Aung Aung"));
		
		
		UsingPair.use(new Container<>(new Container<>("Aung Aung")));
	}
}
