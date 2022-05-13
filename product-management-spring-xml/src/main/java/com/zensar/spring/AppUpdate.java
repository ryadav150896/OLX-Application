package com.zensar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.zensar.spring.beans.Product;
import com.zensar.spring.service.ProductService;

public class AppUpdate {
	
	  public static void main( String[] args )
	    {
	        ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
	        
	        ProductService service=context.getBean("service",ProductService.class);
	        
	        Product product=new Product();
	       // service.insertProduct(product);
	       // product.setProductId(1);
	      //  product.setProductName("mobileaa");
	       // product.setProductCost(100000);
	        
	        service.updateProduct(product);
	        System.out.println("Product updated successfullyyyyy !!!");
	       // Product product1 = new Product(2,"mobile",5000);
	    }
}
