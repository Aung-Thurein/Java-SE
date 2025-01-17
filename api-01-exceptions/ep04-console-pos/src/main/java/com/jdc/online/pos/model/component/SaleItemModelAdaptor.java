package com.jdc.online.pos.model.component;

import java.text.DecimalFormat;

import com.jdc.console.app.component.TableViewModel;
import com.jdc.online.pos.model.input.SaleItem;
import static com.jdc.console.app.utils.FormatUtils.*;

public class SaleItemModelAdaptor implements TableViewModel{

	private SaleItem[] items;
	
	private String rowFormat;
	
	public SaleItemModelAdaptor(SaleItem[] items) {
		super();
		this.items = this.items;
		for(SaleItem item : items) {
			if(item.product().name().length() + 3 > LengthName ) {
				LengthName = item.product().name().length() + 3;
			}
			if(DF.format(item.product().price()).length() +3 > LengthPrice) {
				LengthPrice = DF.format(item.product().price()).length() +3 ;
			}
			
			if (DF.format(item.count()).length() + 3 > LengthQty){
				LengthQty = DF.format(item.count()).length() + 3 ; 
			}
			
			if(DF.format(item.getTotal()).length() + 3 > LengthTotal ){
				LengthTotal = DF.format(item.getTotal()).length() + 3 ;
			}
		}
		
		setRowFormat();
		
		
	}
	
	private static final String HEADER_NO = "No.";
	private static final String HEADER_NAME = "Product";
	private static final String HEADER_PRICE = "Price";
	private static final String HEADER_QUANTITY = "Qty";
	private static final String HEADER_TOTAL = "TOTAL";

	private int LengthNo = HEADER_NO.length() + 3;
	private int LengthName = HEADER_NAME.length() + 3;
	private int LengthPrice = HEADER_PRICE.length() + 3;
	private int LengthQty = HEADER_QUANTITY.length() + 3;
	private int LengthTotal = HEADER_TOTAL.length() + 3;
	
	@Override
	public int maxSize() {
		return LengthNo + LengthName + LengthPrice + LengthQty + LengthTotal;
	}

	@Override
	public String header() {

		return rowFormat.formatted(HEADER_NO, HEADER_NAME, HEADER_PRICE, HEADER_QUANTITY, HEADER_TOTAL);
	}

	@Override
	public String[] rows() {
		
		String[] rows = new String[items.length]; 
		
		for(int i = 0; i < items.length; i++) {
			SaleItem item = items[i];
			
			rows[i] = rowFormat.formatted(i + 1, item.product().name(), item.product().price(), item.count(), item.getTotal());
		}
		return rows;
	}

	private void setRowFormat() {
		StringBuilder sb = new StringBuilder();
		sb.append(FMT_String.formatted(LengthNo));
		sb.append(FMT_String.formatted(LengthName));
		sb.append(FMT_NUMBER.formatted(LengthPrice));
		sb.append(FMT_NUMBER.formatted(LengthQty));
		sb.append(FMT_NUMBER.formatted(LengthTotal));
		
		rowFormat = sb.toString();
	}
}
