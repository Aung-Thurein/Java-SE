package com.jdc.online.pos.model;

import com.jdc.online.pos.model.input.SaleItem;
import com.jdc.online.pos.model.output.Sale;

public class SaleModelImpl implements SaleModel {

	private static SaleModel instance;
	
	public static SaleModel getInstance() {
		instance = new SaleModelImpl();
		return instance;
	}

	@Override
	public Sale create(SaleItem[] cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sale findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sale[] findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
