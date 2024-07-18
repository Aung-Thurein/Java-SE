package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
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

		//Add product 
		String name = UserInputs.readString(SIZE, "Name");
		
		int price = UserInputs.readInt(SIZE, "Price");
		
		ProductForm form = new ProductForm(name, price);
		
		int id = model.create(form);
		
		System.out.printf("%s has been create with ID %d.%n".formatted(name, id));
		
		
	}

}
