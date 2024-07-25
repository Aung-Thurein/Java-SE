package com.jdc.stream.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Sale(
		int id, 
		String category,
		String product,
		int UnitPrice,
		int Quantity,
		LocalDateTime SateAts) {

	static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public int getTotal()
	{
		return UnitPrice * Quantity;
	}
	
	public static Sale From(String[] array)
	{
		int id = Integer.parseInt(array[0]);
		int price = Integer.parseInt(array[3]);
		int quantity = Integer.parseInt(array[4]);
		LocalDateTime SateAt = LocalDateTime.parse(array[5],df);
		
		return new Sale(id,array[1],array[2],price,quantity,SateAt);
		
	}
}
