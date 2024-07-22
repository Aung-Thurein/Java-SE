package com.jdc.online.pos.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import com.jdc.console.app.exceptions.BussinessException;
import com.jdc.online.pos.model.input.ProductForm;
import com.jdc.online.pos.model.output.Product;
import com.jdc.online.pos.model.storage.ProductStorage;

public class ProductModelImpl extends AbstractModel implements ProductModel {

	private static final String FILE_NAME = "products.obj";
	private static ProductModel instance;
	private static int id;

	private Product[] data = {};
	
	private ProductModelImpl() {
		//restore last Data
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(FILE_NAME))){
		
			Object result = input.readObject();
			
			if(result != null && result instanceof ProductStorage(int id, Product[] data))
			{
				ProductModelImpl.id = id;
				this.data = data;
				
			}
		} catch (Exception e) {
		
		}
	}
	
	public static ProductModel getInstance() {
		if(instance == null)
		{
			instance = new ProductModelImpl();
			
		}
		return instance;
	}
	
	

 	@Override
	public int create(ProductForm form) {
	
 		validate(form);
 		
		Product product = new Product (++id, form.name(), form.price());
		
		data = Arrays.copyOf(data, data.length + 1);
		data[data.length - 1] = product;
	
		//save storage
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
			
			output.writeObject(new ProductStorage(id, data));
		} catch (Exception e) {
			//Nothing to do	
		}
		return product.id();
		
	}

	@Override
	public Product[] search(String name) {
		
		Product [] result = new Product[0];
		
		for (Product product : data) {
			if(name == null 
					|| name.isBlank() 
					|| product.name().toLowerCase().startsWith(name.toLowerCase())) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = product;

			}
		}
		return result;
	

	}

	@Override
	public Product findById(int id) {
		for(Product product : data)
		{
			if(product.id() == id)
			{
				return product;
			}
		}
		throw new BussinessException("Please Enter Valid Product Id");
	}

	
 	
 	



}
