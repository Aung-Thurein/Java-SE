package com.jdc.pattern.domain;

public record TransactionTypeForTransfer(
		String name,
		String TransferTo,
		String TransferFrom) implements TransactionType{

}
