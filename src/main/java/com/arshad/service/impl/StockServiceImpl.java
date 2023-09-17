package com.arshad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arshad.entity.Stock;
import com.arshad.repo.StockRepository;
import com.arshad.service.IStockService;

@Service
public class StockServiceImpl implements IStockService {

	@Autowired
	private StockRepository repo;
	
	public Long createStock(Stock stock) {
		return repo.save(stock).getId();
	}

	@Transactional
	public void updateStock(Long id, Long count) {
		repo.updateStock(id, count);
	}

	public List<Stock> getStockDetails() {
		return repo.findAll();
	}
	
	public Long getStockIdByProduct(Long productId) {
		return repo.getStockIdByProduct(productId);
	}

}
