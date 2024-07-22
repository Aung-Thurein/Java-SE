package com.jdc.lambda.effective;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

public class SupplierDemo {
	public static void main(String[] args) {
		
		printLength(Optional.ofNullable(null));
		
	}
	
	public static void printLength(Optional<String> str)
	{
		System.out.println(str.orElseGet(() -> "Default Value"));
	}
}
