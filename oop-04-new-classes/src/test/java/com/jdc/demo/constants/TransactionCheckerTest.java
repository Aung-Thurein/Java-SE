package com.jdc.demo.constants;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(value = OrderAnnotation.class)
public class TransactionCheckerTest {

	@Order(1)
	@Test
	public void test() {
		StatusChecker.check(TransactionStatus.APPROVED);
		System.out.println();
		StatusChecker.check(100);
	}
	@Order(2)
	@Test
	void test_enum() {
		StatusChecker.checkEnum(TransactionState.APPLIED);		
	}
	
	@Order(3)
	@Test
	void test_method_enum() {
		var status = TransactionState.APPLIED;
		var name = status.name();
		var ordinal = status.ordinal();
		
		System.out.println(name);
		System.out.println(ordinal);
		
		TransactionState[] states = TransactionState.values();
		for (var state : states) {
			System.out.printf("%d %s %n",state.ordinal(),state.name() );
		}
		
	}
	@Order(4)
	@Test
	public void test_Enum_Day() {
		StatusChecker.checkEnumwithDays(days.MON);
	}
}
