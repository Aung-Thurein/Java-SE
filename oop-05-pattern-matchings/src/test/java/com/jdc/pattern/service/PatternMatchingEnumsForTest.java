package com.jdc.pattern.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jdc.pattern.switchs.enums.GameCard;
import com.jdc.pattern.switchs.enums.PatternMatchingEnums;

public class PatternMatchingEnumsForTest {

	public void test() {
		
		PatternMatchingEnums cardTest = new PatternMatchingEnums();
		
		assertEquals(3, cardTest.getValue(GameCard.Diamond));

}
	}
