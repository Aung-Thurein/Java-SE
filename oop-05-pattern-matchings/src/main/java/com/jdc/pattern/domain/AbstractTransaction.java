package com.jdc.pattern.domain;

public sealed abstract class AbstractTransaction implements Transaction permits AgentTransaction, ConsumerTransaction {

	private long id;
	private String name;
	
	public AbstractTransaction(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public long getTransactionID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	@Override
	public String getTransactionName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
