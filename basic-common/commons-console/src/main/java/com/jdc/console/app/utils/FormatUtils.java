package com.jdc.console.app.utils;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public interface FormatUtils {

	
	String FMT_String = "%%-%ds";
	String FMT_NUMBER = "%%%ds";
	
	DecimalFormat DF = new DecimalFormat("#,##0.00");
	DateTimeFormatter DATE_TIMEFMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	DateTimeFormatter DATE_FM = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	

}
