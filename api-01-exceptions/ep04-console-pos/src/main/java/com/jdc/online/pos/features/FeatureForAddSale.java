package com.jdc.online.pos.features;

import java.util.Arrays;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.exceptions.BussinessException;
import com.jdc.console.app.exceptions.ConsoleAppException;
import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.ProductModel;
import com.jdc.online.pos.model.SaleModel;
import com.jdc.online.pos.model.input.SaleItem;
import com.jdc.online.pos.model.output.Product;
import com.jdc.online.pos.model.output.Sale;
import com.jdc.online.pos.utils.ProductTableHelper;

public class FeatureForAddSale extends AbstractFeature{

	private static final int SIZE = 10;

	public FeatureForAddSale(int id) {
		super(id, "Create Sale");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBusiness() {
		
		boolean skipAsking = false;
		
		SaleItem[] cart = {};
		//Show Product List 
		System.out.println("Please Select Prouct");
		Product[] result = ProductModel.getInstance().search(null);
		ProductTableHelper.getTableView(result).draw();
		
	do {
		try {
			
			skipAsking = false;
			System.out.println("Add Item");
			//Get Product ID
			int id = UserInputs.readInt(SIZE, "Proudct ID");
			Product product = ProductModel.getInstance().findById(id);
			//show price
			System.out.printf("%-10s : %s%n", "Name",product.name());
			System.out.printf("%-10s : %s%n", "Price",FormatUtils.DF.format(product.price()));
			
			//Get Quantity
			int quantity = UserInputs.readInt(SIZE, "Quantity");
			
			//Add items to Cart
			SaleItem item = new SaleItem(product, quantity);
			cart = addItem(item,cart);
			
			
			//Show total for Items
			System.out.printf("%-10s : %s%n","Total",FormatUtils.DF.format(item.getTotal()));
			
		} catch (BussinessException e) {
			System.out.printf("Error : %s%n",e.getMessage());
			skipAsking = true;
		}
	}
	while(skipAsking || isEmpytInCart()); //false condition work
		
		try {
			if(cart.length > 0 ) {
				//register Sale History 
			Sale sale = SaleModel.getInstance().create(cart);
			System.out.println("Sale History");
			//Show sale Id
			System.out.printf("%-10s : %s%n","Sale Id",sale.id());
			//show Total Item
			System.out.printf("%-10s : %s%n","Item Count",sale.getItemCount());
			//show All total Amount
			System.out.printf("%-10s : %s%n","All Total",sale.getAllTotal());
			}
			
		} catch (ConsoleAppException  | BussinessException e) {
			System.out.printf("Error : %s%n%n",e.getMessage());
			doBusiness();
		}
		catch(ValidationException e) {
			System.out.println("Validation Errors");
			
			for(var message : e.getMessages())
			{
				System.out.println(message);
			}
			doBusiness();
		}
		
	
	}

	private SaleItem[] addItem(SaleItem item, SaleItem[] cart) {
		SaleItem[] newCart = Arrays.copyOf(cart, cart.length + 1);
		newCart[newCart.length - 1] = item;
		return newCart;
	}

	private boolean isEmpytInCart() {
		String result = UserInputs.readString("More Item(Y/Others)");
		System.out.println();
		return "Y".equalsIgnoreCase(result);
	}

}
