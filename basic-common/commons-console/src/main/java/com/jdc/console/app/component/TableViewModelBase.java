package com.jdc.console.app.component;

import java.util.Arrays;

import com.jdc.console.app.component.TableViewData.columnAlignment;
import com.jdc.console.app.exceptions.InvalidComponentDataException;

public  class TableViewModelBase implements TableViewModel {

	TableViewData data;
	private int[] columnSizes;
	private String rowFormat;

	public TableViewModelBase(TableViewData data) {
		super();
		this.data = data;
		
		if(data == null) {
			throw new InvalidComponentDataException("Table View", "Data for table view must not be null");
		}
		
		initColumnSizes();
		
		initRowFormat();
	}
	
	
	private void initRowFormat() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < columnSizes.length; i++) {
			
			columnAlignment allignment = data.columns()[i];
			int maxSize = columnSizes[i];
			
			sb.append(allignment.format().formatted(maxSize));
		}
		
		rowFormat = sb.toString();
	}


	private void initColumnSizes() {
		columnSizes = new int[data.columns().length];
		
		for(int i = 0; i < columnSizes.length; i++) {
			int maxLength = data.headers()[i].length();
			
			for(String[] content : data.contents()) {
				maxLength = maxLength > content[i].length() ? maxLength :content[i].length();
			}
			
			columnSizes[i] = maxLength + 3;
		}
		
		
	}


	@Override
	public String header() {

		return rowFormat.formatted(Arrays.asList(data.headers()).toArray());
	} 
	@Override
	public String[] rows() {

		String[] array = new String[data.contents().length];
		
		for(int i = 0; i < array.length; i++) {
			String[] rowData = data.contents()[i];
			array[i] = rowFormat.formatted(Arrays.asList(rowData).toArray());
		}
		return array;
	}
	@Override
	public int maxSize() {
		
		int total = 0;
				
		for(int size : columnSizes) {		
			total += size;
		}
		return total;
	}
	
}
