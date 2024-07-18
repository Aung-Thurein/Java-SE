package com.jdc.pattern.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.pattern.switchs.enums.CardValue;
import com.jdc.pattern.switchs.enums.GameCard;
import com.jdc.pattern.switchs.enums.GuardedPatternMatching;

public record GuardedPatternTest() {
	@ParameterizedTest
	@CsvSource({
		"Heart,10",
		"Heart,1",
		"Spade,10",
		"Spade,1"
	})
	public void test(GameCard card, int value) {
		CardValue<GameCard> gcard = new CardValue<GameCard>(card, value);
		
		String result = GuardedPatternMatching.getLabel(gcard);
		System.out.println(result);
		
	}
}
