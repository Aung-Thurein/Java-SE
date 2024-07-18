package com.jdc.online.pos.model.component;

import com.jdc.console.app.component.TableViewModel;
import com.jdc.online.pos.model.output.Sale;

import static com.jdc.console.app.utils.FormatUtils.*;
public class SaleModelAdaptor implements TableViewModel {
	private Sale[]sales;
	private String rowFormat;
	private static String [] headers = {"Id","SaleAt","Items","Total"};
	private static int [] columnSizes = {};
	
	static {
		
		for (int i = 0; i < headers.length; i++) {
			columnSizes[i] =  headers[i].length() + 3;
		}
	}
	
	public SaleModelAdaptor(Sale[] sales) {
		super();
		this.sales = sales;
		
		for(Sale sale : sales) {
			if(String.valueOf(sale.id()).length() + 3 > columnSizes[0]) {
				columnSizes[0] = String.valueOf(sale.id()).length() + 3;
			}
			
			if(DATE_TIMEFMT.format(sale.sateAt()).length() + 3 > columnSizes[1]) {
				 columnSizes[1] = DATE_TIMEFMT.format(sale.sateAt()).length() + 3 ;
			}
			
			if(String.valueOf(sale.getItemCount()).length() +3 > columnSizes[2]) {
				columnSizes[2] = String.valueOf(sale.getItemCount()).length() +3;
			}
			if(String.valueOf(sale.getAllTotal()).length() + 3 > columnSizes [3]) {
				columnSizes [3] = String.valueOf(sale.getAllTotal()).length() + 3;
			}
			
		}
		setRowFormat();
	}

	@Override
	public int maxSize() {
		int total = 0;
		for (int size : columnSizes) {
			total += size;
		}
		return total;
	}

	@Override
	public String header() {
		return rowFormat.formatted(headers[0], headers[1], headers[2], headers[3]);
	}

	@Override
	public String[] rows() {
		String[] rows = new String[sales.length];
		
		for(int i = 0; i < sales.length; i++) {
			Sale sale = sales[i];
			rows[i] = rowFormat.formatted(sale.id(), 
					sale.sateAt(),
					sale.getItemCount(),
					sale.getAllTotal());
		}
		return rows;
	}
	
	private void setRowFormat() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(FMT_String.formatted(columnSizes[0]));
		sb.append(FMT_String.formatted(columnSizes[1]));
		sb.append(FMT_NUMBER.formatted(columnSizes[2]));
		sb.append(FMT_NUMBER.formatted(columnSizes[3]));
		
		rowFormat = sb.toString();

	}

}
