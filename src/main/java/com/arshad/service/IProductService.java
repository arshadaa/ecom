package com.arshad.service;

import java.util.List;
import java.util.Map;

import com.arshad.entity.Product;

public interface IProductService {

	Long saveProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(Long id);
	Product getOneProduct(Long id);
	List<Product> getAllProducts();
	Map<Long,String> getProductIdAndName();
	
	List<Object[]> getProductsByBrands(Long brandId);
	List<Object[]> getProductsByCategory(Long catId);
	List<Object[]> getProductByNameMatching(String input);
}
