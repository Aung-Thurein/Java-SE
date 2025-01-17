package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.component.TableView;
import com.jdc.online.pos.model.ProductModel;
import com.jdc.online.pos.model.output.Product;
import com.jdc.online.pos.utils.ProductTableHelper;

public class FeatureForSearchProduct extends AbstractFeature {

	private ProductModel model;
	
	private Product[] products = {};
	
	public FeatureForSearchProduct(int id) {
		super(id, "Search Product");
		// TODO Auto-generated constructor stub

	}

	
	@Override
	public void doBusiness() {

		String name = UserInputs.readString("Search Name");
		
		 products = ProductModel.getInstance().search(name);
	
		
		//show result 
		TableView table = ProductTableHelper.getTableView(products);

		table.draw();
	
	}
}
