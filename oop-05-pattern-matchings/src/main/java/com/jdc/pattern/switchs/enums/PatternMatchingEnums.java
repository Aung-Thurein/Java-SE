package com.jdc.pattern.switchs.enums;

public class PatternMatchingEnums {

	
	public int getValue(Card card) {
		return switch(card) {
		case GameCard.Spade, TarotCard.Aingle -> 1;
		case GameCard.Heart, TarotCard.Saint -> 2;
		case GameCard.Diamond, TarotCard.People -> 3;
		case GameCard.Clover, TarotCard.Demon -> 4;
		default -> throw new IllegalArgumentException();
		};
	}
}
