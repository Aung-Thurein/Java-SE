package com.jdc.online.pos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import com.jdc.console.app.exceptions.BussinessException;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.input.SaleItem;
import com.jdc.online.pos.model.output.Sale;

public class SaleModelImpl implements SaleModel {

	private static SaleModel instance;
	private static int ID;
	private Sale[] sales = {};
	
	public static SaleModel getInstance() {
		if(null == instance)
		{
			instance = new SaleModelImpl();
		}
		return instance;
	}

	@Override
	public Sale create(SaleItem[] cart) {
		Sale sale = new Sale(++ ID, LocalDateTime.now(), cart);
		
		sales = Arrays.copyOf(sales, sales.length + 1);
		sales[sales.length - 1] = sale;
		
		return sale;
	}

	@Override
	public Sale findById(int id) {
		
		for(Sale sale : sales)
		{
			if(sale.id() == id)
			{
				return sale;
			}
		}
			
		throw new BussinessException("Please Enter Valid sale Id");
	}

	@Override
	public Sale[] findByDate(String date) {
		Sale[] result = {};
		LocalDate data = LocalDate.parse(date,FormatUtils.DATE_FM);
		
		for(Sale sale : sales)
		{
			if(sale.sateAt().toLocalDate().equals(data))
			{
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length -1] = sale;
			}
			
		
		}
		return result;
	}

}
