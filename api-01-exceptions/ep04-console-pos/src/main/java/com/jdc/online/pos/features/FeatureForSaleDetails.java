package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.exceptions.BussinessException;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.SaleModel;
import com.jdc.online.pos.model.output.Sale;
import com.jdc.online.pos.utils.SaleItemTableHelper;

public class FeatureForSaleDetails extends AbstractFeature {

	private static final int SIZE = 14;

	public FeatureForSaleDetails(int id) {
		super(id, "Sale Details");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBusiness() {

		try {
			//get sale id
			int id = UserInputs.readInt(SIZE,"Enter Sale Id");
			//find sale
			Sale sale = SaleModel.getInstance().findById(id);
			
			//show sale Details;
			//Sate At
			System.out.printf("%-14s : %s%n","Sate At",FormatUtils.DATE_TIMEFMT.format(sale.sateAt()));
			//Total count
			System.out.printf("%-14s : %s%n","Items",sale.getItemCount());
			//Total amount
			System.out.printf("%-14s : %s%n%n","Total Amount",FormatUtils.DF.format(sale.getAllTotal()));
			//Sale Item
			System.out.println("Sale Items");
			
			SaleItemTableHelper.getTableView(sale.items()).draw();

		} catch (BussinessException e) {
			System.out.printf("Error : %s%n%n",e.getMessage());
			doBusiness();
		}
	}

}
