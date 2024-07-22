package com.jdc.online.pos.model.input;

import java.io.Serializable;

import com.jdc.online.pos.model.output.Product;
import com.jdc.online.validator.annotation.MinValue;
import com.jdc.online.validator.annotation.NotNull;

public record SaleItem(
		@NotNull(message = "Please Select Product")
		Product product,
		@MinValue(value = 1, message = "Please enter item count.")
		int count
		)implements Serializable {
	
	public int getTotal() {
		return product.price() * count;
	}

}
