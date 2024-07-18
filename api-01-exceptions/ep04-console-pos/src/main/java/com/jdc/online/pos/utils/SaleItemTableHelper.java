package com.jdc.online.pos.utils;

import com.jdc.console.app.component.TableView;
import com.jdc.console.app.component.TableViewData;
import com.jdc.console.app.component.TableViewData.columnAlignment;
import com.jdc.console.app.component.TableViewModelBase;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.input.SaleItem;

public class SaleItemTableHelper {

	public static TableView getTableView(SaleItem[] sales) {
	
		String[] headers =new String[] {"No", "Product", "Unit Price", "Quantity", "Total" };
		columnAlignment [] columns = new columnAlignment[] {columnAlignment.Left, columnAlignment.Left, columnAlignment.Right, columnAlignment.Right, columnAlignment.Right };
		
		String[][] contents = new String[sales.length][];
	
		for (int i = 0; i < sales.length; i++) {
			SaleItem item = sales[i];
			contents[i] = new String[headers.length];
			
			contents[i][0] = String.valueOf(i + 1);
			contents[i][1] = item.product().name();
			contents[i][2] = FormatUtils.DF.format(item.product().price());
			contents[i][3] = String.valueOf(item.count());
			contents[i][4] = FormatUtils.DF.format(item.getTotal());
			
			
			
		}
		TableViewData data =new TableViewData(columns, headers, contents);	
		
		
		return new TableView(new TableViewModelBase(data));
		
	}
}
