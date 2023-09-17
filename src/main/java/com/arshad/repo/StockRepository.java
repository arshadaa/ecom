package com.arshad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.arshad.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	@Query("SELECT s.id FROM Stock s INNER JOIN s.product as p WHERE p.id=:productId")
	Long getStockIdByProduct(Long productId);
	
	@Modifying
	@Query("UPDATE Stock SET qoh=qoh+:count WHERE id=:id")
	void updateStock(Long id, Long count);
}
