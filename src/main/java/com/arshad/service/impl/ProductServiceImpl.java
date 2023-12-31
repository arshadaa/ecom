package com.arshad.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshad.entity.Product;
import com.arshad.exception.ProductNotFoundException;
import com.arshad.repo.ProductRepository;
import com.arshad.service.IProductService;
import com.arshad.util.AppUtil;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repo;

	public Long saveProduct(Product p) {
		return repo.save(p).getId();
	}

	public void updateProduct(Product p) {
		if(p.getId()==null || !repo.existsById(p.getId()))
			throw new ProductNotFoundException("Product Not Found");
		else
			repo.save(p);
	}

	public void deleteProduct(Long id) {
		repo.delete(getOneProduct(id));
	}

	public Product getOneProduct(Long id) {
		return repo.findById(id)
				.orElseThrow(()->new ProductNotFoundException("Product Not Found"));
	}

	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	
	public Map<Long, String> getProductIdAndName() {
		List<Object[]> list = repo.getProductIdAndNames();
		return AppUtil.convertListToMapLong(list);
	}
	
	@Override
	public List<Object[]> getProductsByBrands(Long brandId) {
		return repo.getProductsByBrands(brandId);
	}
	
	@Override
	public List<Object[]> getProductsByCategory(Long catId) {
		return repo.getProductsByCategory(catId);
	}
	
	@Override
	public List<Object[]> getProductByNameMatching(String input) {
		return repo.getProductByNameMatching(input);
	}

}
