package com.jdc.pattern.service;

import com.jdc.pattern.domain.TransactionType;
import com.jdc.pattern.domain.TransactionTypeForCashOut;
import com.jdc.pattern.domain.TransactionTypeForTransfer;

public class TransactionTypeService {

	
	public void show(TransactionType trx) {
		System.out.println("Transaction Information");
		System.out.printf("%-16s: %s%n","Type Name", trx.name());
		//record pattern matching
		if(trx instanceof  TransactionTypeForCashOut(String name, String consumer,String agent)) {
			System.out.printf("%-16s: %s%n","Agent Name", agent);
			System.out.printf("%-16s: %s%n","Consumer Name", consumer);
		}
		
		if(trx instanceof TransactionTypeForTransfer (String name, String From , String to)) {
			System.out.printf("%-16s: %s%n","From", From);
			System.out.printf("%-16s: %s%n","To", to);
		}
	}
}
