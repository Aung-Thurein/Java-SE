
package com.jdc.demo.kinds;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.annotation.Annotation;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.demo.kinds.model.Child;
import com.jdc.demo.kinds.model.Parent;
@TestMethodOrder(value = OrderAnnotation.class)
public class KindOfPresentTest {
	@Order(1)
	@Test
	void test_directly_presence() {
		var annotations = Parent.class.getDeclaredAnnotations();
		
		for (var annotation : annotations) {
			System.out.println(annotation.annotationType());
		}
		
		var singles = Parent.class.getDeclaredAnnotation(Singles.class);
		assertNotNull(singles);
		
		var singlesValue = singles.value();
		
		for(var single : singlesValue) {
			System.out.println(single.value());
		}
		
		
		
		var single = Parent.class.getDeclaredAnnotation(Single.class);
		assertNull(single);
		
		
	}
	@Test
	@Order(2)
	
	public void test_indirectly_present() {
		
		System.out.println("Indriectly present");
	    Single[] annotation1 = Parent.class.getDeclaredAnnotationsByType(Single.class);
	   
	    for(var annotation : annotation1) {
	    	System.out.println(annotation.annotationType());
	    	System.out.printf("value %d%n",annotation.value());
	    }
	    
	    Singles[] annotation2 = Parent.class.getDeclaredAnnotationsByType(Singles.class);
	    		
	    for (var annotation : annotation2) {
	    	System.out.println(annotation.annotationType());
	    	
	    }
	  }
	
	@Test
	@Order(3)
	public void test_present() {
		
		System.out.println("Present");
		
		Annotation[] array = Child.class.getAnnotations();
		
		for (Annotation anno : array) {
			System.out.println(anno.annotationType());
		}
		//Present
		Singles singles = Child.class.getAnnotation(Singles.class);
		
		assertNotNull(singles);
		
		
		//Directly
		Other other = Child.class.getAnnotation(Other.class);
		
		assertNotNull(other);
		
	//	System.out.println(other.name());
		
	}
	
	@Test
	@Order(4)
	public void test_associate() {
		System.out.println("associate present");
		
		//Present
		Singles[] singles = Child.class.getAnnotationsByType(Singles.class);
		
		for(Singles anno : singles) {
			System.out.println(anno.annotationType());
		}
		
		//associate
		Single[] single = Child.class.getAnnotationsByType(Single.class);
		for(Single anno : single) {
			System.out.println(anno.annotationType());
		}
		//Directly present
		Other[] other = Child.class.getAnnotationsByType(Other.class);
 		
		for(Other anno : other) {
			System.out.println(anno.annotationType());
		}
		
		//Indirectly present 
		
		Another[] another = Child.class.getAnnotationsByType(Another.class);
		
		for(Another anno : another) {
			System.out.println(anno.annotationType());
		}
	}
	
	
			
		
	
	
}
