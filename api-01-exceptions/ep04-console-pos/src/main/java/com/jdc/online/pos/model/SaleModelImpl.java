package com.jdc.online.pos.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import com.jdc.console.app.exceptions.BussinessException;
import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.input.SaleItem;
import com.jdc.online.pos.model.output.Sale;
import com.jdc.online.pos.model.storage.SaleStorage;

public class SaleModelImpl extends AbstractModel implements SaleModel {

	private static final String FILE_NAME = "sales.obj";
	private static SaleModel instance;
	private static int ID;
	private Sale[] sales = {};
	
	private SaleModelImpl() {
		//restore 
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(FILE_NAME))){
			
			Object result = input.readObject();
			
			if(result != null && result instanceof SaleStorage(int id, Sale[] sales))
			{
				SaleModelImpl.ID = id;
				this.sales = sales;
			}
			
		} catch (Exception e) {
			//nth to do
		}
	}
	
	public static SaleModel getInstance() {
		if(null == instance)
		{
			instance = new SaleModelImpl();
		}
		return instance;
	}

	@Override
	public Sale create(SaleItem[] cart) {
		
		validate(cart);
		Sale sale = new Sale(++ ID, LocalDateTime.now(), cart);
		
		
		sales = Arrays.copyOf(sales, sales.length + 1);
		sales[sales.length - 1] = sale;
	
		//save state
		try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			
			output.writeObject(new SaleStorage(ID, sales));
		} catch (Exception e) {
			// TODO: handle exception
		}

		return sale;
	}

	private void validate(SaleItem[] cart) {

		if(null == cart || cart.length == 0) 
		{
			throw new BussinessException("Please add items to cart");
		}
		
		String[] messages = {};
		
		for(SaleItem item : cart)
		{
			try {
				super.validate(item);
	
			} catch (ValidationException e) {
				for(String message : e.getMessages())
				{
					messages = Arrays.copyOf(messages, messages.length + 1);
					messages[messages.length - 1] = message;
				}
			}
		}
		
		if(messages.length > 0)
		{
			throw new ValidationException(messages);
		}
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
		
		try {
		
			Sale[] result = {};
			LocalDate data =(date == null || date.isBlank()) ? LocalDate.now() : LocalDate.parse(date,FormatUtils.DATE_FM);
			
			for(Sale sale : sales)
			{
				if(sale.sateAt().toLocalDate().equals(data))
				{
					result = Arrays.copyOf(result, result.length + 1);
					result[result.length -1] = sale;
				}
			}
			return result;
			
		} catch (DateTimeParseException e) {
			throw new BussinessException("Please enter datae with yyyy-MM-dd format.");
		}
		
	}

}
