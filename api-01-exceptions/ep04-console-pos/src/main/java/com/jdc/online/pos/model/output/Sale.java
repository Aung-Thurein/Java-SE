package com.jdc.online.pos.model.output;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.jdc.online.pos.model.input.SaleItem;

public record Sale(
	int id ,
	LocalDateTime sateAt,
	SaleItem[] items
		)implements Serializable {	

	public int getItemCount() {
		return items.length;
	}
	
	public int getAllTotal() {
		int total = 0;
		
		for(SaleItem item : items) {
			total += item.getTotal();
		}
		return total;
	}
	
}
