package com.arshad.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arshad.entity.Coupon;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {
	
	Optional<Coupon> findByCode(String code);
}
