package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.exceptions.BussinessException;
import com.jdc.console.app.exceptions.ConsoleAppException;
import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.online.pos.model.ProductModel;
import com.jdc.online.pos.model.input.ProductForm;
import com.jdc.online.pos.model.output.Product;

public class FeatureForAddProduct extends AbstractFeature {

	private ProductModel model;
	private static final int SIZE = 6;

	public FeatureForAddProduct(int id) {
		super(id, "Create Product");
		// TODO Auto-generated constructor stub
		model = ProductModel.getInstance();
	}

	@Override
	public void doBusiness() {
		
		try {
			//Add product 
			String name = UserInputs.readString(SIZE, "Name");
			
			int price = UserInputs.readInt(SIZE, "Price");
			
			ProductForm form = new ProductForm(name, price);
			
			int id = model.create(form);
			
			System.out.printf("%s has been create with ID %d.%n".formatted(name, id));
			

		} catch (ConsoleAppException  | BussinessException e) {
			System.out.printf("Error : %s%n%n",e.getMessage());
			doBusiness();
		}
		catch (ValidationException e) {
			System.out.println("Validation Errors");
			
			for(String message : e.getMessages())
			{
				System.out.println(message);
			}
			doBusiness();
		}
		
	}

}
