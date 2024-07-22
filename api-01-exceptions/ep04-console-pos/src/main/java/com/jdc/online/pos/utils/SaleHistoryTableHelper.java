package com.jdc.online.pos.utils;

import com.jdc.console.app.component.TableView;
import com.jdc.console.app.component.TableViewData;
import com.jdc.console.app.component.TableViewData.columnAlignment;
import com.jdc.console.app.component.TableViewModelBase;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.output.Sale;




public class SaleHistoryTableHelper {

	public static TableView getTableView(Sale[] sales) {
		
		String[] headers = new String[] {"Id", "SateAt", "Total Items","Total Amount"};
		columnAlignment[] columns = new columnAlignment[] {columnAlignment.Left, columnAlignment.Left, columnAlignment.Right, columnAlignment.Right};
		String[][] contents = new String[sales.length][];

		for (int i = 0; i < sales.length; i++) {
			Sale item = sales[i];
			
			contents[i] = new String[headers.length];
			
			contents[i][0] = String.valueOf(item.id());
			contents[i][1] = item.sateAt().format(FormatUtils.DATE_TIMEFMT);
			contents[i][2] = String.valueOf(item.getItemCount());
			contents[i][3] = FormatUtils.DF.format(item.getAllTotal());
			
			
			
		}
	
		TableViewData data =new TableViewData(columns, headers, contents);	
		return new TableView(new TableViewModelBase(data));
		
	}
}
