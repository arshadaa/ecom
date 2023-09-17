package com.arshad.service;

import java.util.List;

import com.arshad.entity.Address;
import com.arshad.entity.Customer;

public interface ICustomerService {

	Long saveCustomer(Customer user);
	List<Customer> getAllCustomers();
	Customer findByEmail(String email);
	List<Address> getCustomerAddress(Long id);
}
