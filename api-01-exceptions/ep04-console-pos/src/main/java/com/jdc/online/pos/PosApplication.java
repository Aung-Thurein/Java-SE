package com.jdc.online.pos;


import com.jdc.console.app.ConsoleApplication;
import com.jdc.online.pos.features.FeatureForAddProduct;
import com.jdc.online.pos.features.FeatureForAddSale;
import com.jdc.online.pos.features.FeatureForSaleDetails;
import com.jdc.online.pos.features.FeatureForSearchProduct;
import com.jdc.online.pos.features.FeatureForSearchSale;

public class PosApplication {

	public static void main(String[] args) {
		ConsoleApplication application = new ConsoleApplication("Console POS",
				new FeatureForAddProduct(1),
				new FeatureForSearchProduct(2),
				new FeatureForAddSale(3),
				new FeatureForSaleDetails(4),
				new FeatureForSearchSale(5));
		
		application.launch();
				
	}
	
	
	
		
}
