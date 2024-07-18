package com.jdc.pattern.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.pattern.domain.AgentTransaction;
import com.jdc.pattern.domain.ConsumerTransaction;
import com.jdc.pattern.domain.Transaction;

public class TransactionServiceTest {
	
	private TransactionService service;
	
	
	@BeforeEach
	public void initEach() {
		service = new TransactionService();
	}
 	
	@ParameterizedTest
	@CsvSource({
		"1,Cash Out,196 store,10000"
	})
	public void test_agentTransaction(int id, String name, String agentName, BigDecimal amount) {

		AgentTransaction agent = new AgentTransaction(id, name, agentName, amount);
		
		service.show(agent);
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"1,Transfer,Aung Aung,5000"
	})
	public void test_consumerAgent(int id, String name, String consumerName, BigDecimal amount) {
		ConsumerTransaction counsumer = new ConsumerTransaction(id, name, consumerName, amount);
		service.show(counsumer);
	}
}
