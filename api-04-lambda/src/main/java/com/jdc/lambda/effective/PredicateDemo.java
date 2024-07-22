package com.jdc.lambda.effective;

import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
		
		Predicate<Integer> greaterThanFour = data -> data > 4;
		Predicate<Integer> isEvenNumber = data -> data % 2 == 0;
		
		printIfTrue(list, greaterThanFour);
		System.out.println("------------------------");
		printIfTrue(list, isEvenNumber);
		System.out.println("------------------------");
		printIfTrue(list, greaterThanFour.and(isEvenNumber));
		System.out.println("------------------------");
		printIfTrue(list, greaterThanFour.and(isEvenNumber.negate()));
	}
	
	
	static void printIfTrue(List<Integer> list, Predicate<Integer> predicate) 
	{
		
		list.forEach(data -> {
			if(predicate.test(data))
			{
				System.out.println(data);
			}
		}
		
			);
	}
}
