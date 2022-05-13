package com.zensar.spring.service;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductService {

	public int insertProduct(Product product);
	public int updateProduct(Product product);
	public int deleteProduct(int productId);
	public List<Product> getAllProduct();
	public Product findProduct(int productId);
}
