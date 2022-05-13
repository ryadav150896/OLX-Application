package com.zensar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.service.ProductService;

public class AppDelete {
	
	public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
        
        ProductService service=context.getBean("service",ProductService.class);
        
        //Product product=new Product(2,"Laptop",150000);
      //  Product product=new Product();
       //service.insertProduct(product);
        service.deleteProduct(2);
        System.out.println("Product Deleted successfullyyyyy !!! of given productId ");
        
    }
}


