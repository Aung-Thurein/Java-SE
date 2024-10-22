package com.jdc.online.pos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.console.app.component.TableView;
import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.online.pos.model.component.ProductModelAdaptor;
import com.jdc.online.pos.model.input.ProductForm;
import com.jdc.online.pos.model.output.Product;
@TestMethodOrder(value = org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class ProductModelTest {

	private static ProductModel model;
	private Product product;
	
	@BeforeAll
	static void init() {
		model = ProductModel.getInstance();
	}
	@Disabled
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		",500,Please enter product name,",
	})
	public void test_product_add_error(String name, int price, String message1, String message2) {
		
		ProductForm form = new ProductForm(name, price);
		
		ValidationException exception = assertThrows(ValidationException.class, () ->{
			model.create(form);
		});
		
		String[] messages = exception.getMessages();
		
		if(messages.length >= 1) {
			assertEquals(message1, messages[0]);
		
		if(messages.length >= 2) {
			assertEquals(message2, messages[1]);
		}
		
	}

}
	@Disabled
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		",10,Please enter product name,Please enter price with min 100,",
	})
	public void test_product_add_error1(String name, int price, String message1, String message2) {
		
		ProductForm form = new ProductForm(name, price);
		
	
		ValidationException exception = assertThrows(ValidationException.class, () ->{
			model.create(form);
		});
		
		
		String[] messages = exception.getMessages();
		
		if(messages.length >= 1) {
			assertEquals(message1, messages[0]);
		
		if(messages.length >= 2) {
			assertEquals(message2, messages[1]);
		}
		
	}

}
	@Disabled
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"Coke,20,Please enter price with min 100,",
	})
	public void test_product_add_error2(String name, int price, String message1, String message2) {
		
		ProductForm form = new ProductForm(name, price);
		
		ValidationException exception = assertThrows(ValidationException.class, () ->{
			model.create(form);
		});
		
		String[] messages = exception.getMessages();
		
		if(messages.length >= 1) {
			assertEquals(message1, messages[0]);
		
		if(messages.length >= 2) {
			assertEquals(message2, messages[1]);
		}
		
	}

}
	
	
		@Order(4)
		@ParameterizedTest
		@CsvSource({
			"Coke,1000,1",
			"Potato,800,2",
			"Cake,500,3"
		})
		public void product_test_success(String name, int price, int expectedId) {
			
			ProductForm form = new ProductForm(name,price);
			int id = model.create(form);
		
			Product[] result = model.search(name);

			ProductModelAdaptor adptor = new ProductModelAdaptor(result);
			TableView table = new TableView(adptor);
			table.draw();

			assertEquals(expectedId, id);
			
		}
		
		
		@Order(5)
		@ParameterizedTest
		@CsvSource({
			"c,2",
			"co,1",
			"Potato,1",
			"PotatoChips,0"		
		})
		public void product_search(String name, int count) {
		
			Product[] result = model.search(name);
			
			
			
			assertEquals(count, result.length);
			
			
			
		}
	
	
	

	}