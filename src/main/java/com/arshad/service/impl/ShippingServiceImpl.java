package com.arshad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshad.entity.Shipping;
import com.arshad.exception.ShippingNotFoundException;
import com.arshad.repo.ShippingRepository;
import com.arshad.service.IShippingService;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Service
public class ShippingServiceImpl implements IShippingService {
	@Autowired
	private ShippingRepository repo;

	public Long saveShipping(Shipping shipping) {
		return repo.save(shipping).getId();
	}

	public void updateShipping(Shipping shipping) {
		if(shipping.getId()==null || !repo.existsById(shipping.getId()))
			throw new ShippingNotFoundException("Shipping Not exist");
		else
			repo.save(shipping);
	}

	public void deleteShipping(Long id) {
		repo.delete(getOneShipping(id));
	}


	public Shipping getOneShipping(Long id) {
		return repo.findById(id).orElseThrow(
				()->new ShippingNotFoundException("Shipping Not exist")
				);
	}

	public List<Shipping> getAllShippings() {
		return repo.findAll();
	}
}
