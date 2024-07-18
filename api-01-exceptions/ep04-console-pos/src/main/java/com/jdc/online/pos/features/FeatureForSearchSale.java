package com.jdc.online.pos.features;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.SaleModel;
import com.jdc.online.pos.model.output.Sale;
import com.jdc.online.pos.utils.SaleHistoryTableHelper;

public class FeatureForSearchSale  extends AbstractFeature{

	public FeatureForSearchSale(int id) {
		super(id, "Sale History");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBusiness() {
		//get Sale Date
		String date = UserInputs.readString("Enter Date");

		
		//Search form Model
		Sale[] sale = SaleModel.getInstance().findByDate(date);
		//Show Result
		
		SaleHistoryTableHelper.getTableView(sale).draw();

	}

	
}
