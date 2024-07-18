package com.jdc.pattern.domain;

import java.math.BigDecimal;

public final class ConsumerTransaction extends AbstractTransaction {

	private String CousmerName;
	private BigDecimal amount;
	public ConsumerTransaction(long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	public ConsumerTransaction (int id, String name, String cousmerName, BigDecimal amount) {
		super(id,name);
		this.CousmerName = CousmerName;
		this.amount = amount;
	}

	public String getCousmerName() {
		return CousmerName;
	}

	public void setCousmerName(String cousmerName) {
		CousmerName = cousmerName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	


}
