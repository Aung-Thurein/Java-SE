package com.jdc.online.pos.model.component;

import java.text.DecimalFormat;

import com.jdc.console.app.component.TableViewModel;
import com.jdc.online.pos.model.input.ProductForm;
import com.jdc.online.pos.model.output.Product;

public class ProductModelAdaptor implements TableViewModel{

	private Product[] products;
	private static final String HEADER_ID = "Id";
	private static final String HEADER_NAME = "Name";
	private static final String HEADER_PRICE = "Price";
	
	private static  int idLength = HEADER_ID.length() + 2;
	private static  int nameLength = HEADER_NAME.length() + 2;
	private static  int priceLength = HEADER_PRICE.length() + 2;
	 
	private static final DecimalFormat DF = new DecimalFormat("#,##0.00");

	public ProductModelAdaptor(Product[] products) {
		super();
		this.products = products;
		
		for(Product product : this.products) {
			if(String.valueOf(product.id()).length() + 2 > idLength ) {
				idLength = String.valueOf(product.id()).length() + 2;
			}
			if(product.name().length() + 2 > nameLength) {
				nameLength = product.name().length() + 2;
			}
			if(DF.format(product.price()).length() + 2 > priceLength){
				priceLength = DF.format(product.price()).length() + 2;
			}
		}
	}
	
	@Override
	public int maxSize() {
		return idLength + nameLength + priceLength;
	}

	@Override
	public String header() {
		return rowFormat().formatted(HEADER_ID, HEADER_NAME, HEADER_PRICE);
	}

	@Override
	public String[] rows() {
		String [] rows = new String[this.products.length];
		
		for(int i = 0; i < products.length; i++) {
			Product product = this.products[i];
			
			rows[i] = rowFormat().formatted(product.id(), product.name(), DF.format(product.price() ));
		}
			
		return rows;
	}
	
	private String rowFormat() {
		return "%%-%ds%%-%ds%%%ds".formatted(idLength, nameLength, priceLength);
	}

}
