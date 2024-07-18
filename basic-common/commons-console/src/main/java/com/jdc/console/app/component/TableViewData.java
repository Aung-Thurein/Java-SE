package com.jdc.console.app.component;

import com.jdc.console.app.exceptions.InvalidComponentDataException;
import com.jdc.console.app.utils.FormatUtils;

public record TableViewData(
		columnAlignment[] columns,
		String[] headers,
		String[][] contents) {
	
	public TableViewData {
	if(columns == null || columns.length == 0) {	
		throw new InvalidComponentDataException("Table View", "Columns length must not be empty" );
	}
	if(headers == null || headers.length == 0) {
		throw new InvalidComponentDataException("Table View", "Headers lengths must not be empty");
	}
	if(columns.length != headers.length) {
		throw new InvalidComponentDataException("Table View", "Columns and Headers length must be the same");
		
	}
	
	for(String[] row : contents) {
		if(row != null && columns.length != row.length) {
			throw new InvalidComponentDataException("Table View", "Columns and Row length must be the same");
		}
	}
	
	
	}
	
	
	
	
	public enum columnAlignment {
		Left {
			@Override
			public String format() {
				return FormatUtils.FMT_String;
			}
		}, Right {
			@Override
			public String format() {
				return FormatUtils.FMT_NUMBER;
			}
		};
		
		public abstract String format() ;
	}
}
