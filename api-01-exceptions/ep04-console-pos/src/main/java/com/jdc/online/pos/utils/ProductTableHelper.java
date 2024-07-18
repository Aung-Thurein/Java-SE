package com.jdc.online.pos.utils;

import com.jdc.console.app.component.TableView;
import com.jdc.console.app.component.TableViewData;
import com.jdc.console.app.component.TableViewData.columnAlignment;
import com.jdc.console.app.component.TableViewModelBase;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.output.Product;

public class ProductTableHelper {

	
	public static TableView getTableView(Product[] products) {
		String[] headers =new String[] {"Id", "Name", "Price" };
		columnAlignment [] columns = new columnAlignment[] {columnAlignment.Left, columnAlignment.Left, columnAlignment.Right};
		
		
		String[][] contents = new String[products.length][];
		
		for(int i = 0; i < contents.length; i++) {
			Product product = products[i];
			
			contents[i] = new String[3];
			
			contents[i][0] = String.valueOf(product.id());
			contents[i][1] = product.name();
			contents[i][2] = FormatUtils.DF.format(product.price());
			
			
		}
		TableViewData data =new TableViewData(columns, headers, contents);	
		
		
		return new TableView(new TableViewModelBase(data));
	}
}
