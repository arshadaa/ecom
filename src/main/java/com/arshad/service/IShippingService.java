package com.arshad.service;

import java.util.List;

import com.arshad.entity.Shipping;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IShippingService {
	Long saveShipping(Shipping shipping);

	void updateShipping(Shipping shipping);

	void deleteShipping(Long id);

	Shipping getOneShipping(Long id);

	List<Shipping> getAllShippings();
}
