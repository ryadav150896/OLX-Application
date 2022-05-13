package com.zensar.spring.repository;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductRepository {

	public int insertProduct(Product product);
	public int updateProduct(Product product);
	public int deleteProduct(int productId);
	public List<Product> getAllProduct();
	public Product findProduct(int productId);
}
