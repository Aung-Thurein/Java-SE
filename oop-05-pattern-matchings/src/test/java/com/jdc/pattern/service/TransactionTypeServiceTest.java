package com.jdc.pattern.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.pattern.domain.TransactionTypeForCashOut;
import com.jdc.pattern.domain.TransactionTypeForTransfer;

public class TransactionTypeServiceTest {

	private TransactionTypeService service;
	
	@BeforeEach
	public void initEach() {
		service = new TransactionTypeService();
	}
	
	@ParameterizedTest
	@CsvSource({
		"Cash Out,Thidar,196 Store"
	})
	public void test_transactionTypeForCashOut(String name, String consumerName, String agentShop) {
		TransactionTypeForCashOut cashout = new TransactionTypeForCashOut(name, consumerName, agentShop);
		
		service.show(cashout);
	}
	
	@ParameterizedTest
	@CsvSource({
		
		"Transfer,Aung Aung,Zaw Zaw"
	})
	public void test_transactionTypeForTransfer(String name, String From, String To) {
		TransactionTypeForTransfer transfer = new TransactionTypeForTransfer(name, To, From);
		service.show(transfer);
	}
	
}
