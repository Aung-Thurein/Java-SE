package com.jdc.pattern.domain;

import java.math.BigDecimal;
//pattern matchings

public final class AgentTransaction extends AbstractTransaction{

	private String agentName;
	private BigDecimal amount;
	
	public AgentTransaction(long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	public AgentTransaction(int id, String name, String agentName, BigDecimal amount) {
		super(id,name);
		this.agentName = agentName;
		this.amount = amount;
		
	}

	
	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



}
