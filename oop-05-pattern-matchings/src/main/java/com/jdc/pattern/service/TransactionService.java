package com.jdc.pattern.service;

import com.jdc.pattern.domain.AgentTransaction;
import com.jdc.pattern.domain.ConsumerTransaction;
import com.jdc.pattern.domain.Transaction;

public class TransactionService {

	public void show(Transaction trx) {
		
		System.out.println("Transaction Information");
		System.out.printf("%-20s: %s%n","Transaction ID",trx.getTransactionID());
		System.out.printf("%-20s: %s%n","Transaction Name",trx.getTransactionName());
		
		if(trx instanceof AgentTransaction agentTrx) {
			System.out.printf("%-20s: %s%n","Agent Name",agentTrx.getAgentName());
			System.out.printf("%-20s: %s%n","Amount",agentTrx.getAmount());
		}
		if(trx instanceof ConsumerTransaction consumerTrx) {
			System.out.printf("%-20s: %s%n","Consumer Name",consumerTrx.getCousmerName());
			System.out.printf("%-20s: %s%n","Amount",consumerTrx.getAmount());
		}
		
	}
	

	
}
