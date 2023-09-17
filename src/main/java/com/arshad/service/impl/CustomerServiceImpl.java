package com.arshad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshad.constants.UserRole;
import com.arshad.entity.Address;
import com.arshad.entity.Customer;
import com.arshad.entity.User;
import com.arshad.repo.CustomerRepository;
import com.arshad.service.ICustomerService;
import com.arshad.service.IUserService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private IUserService userService;
	
	public Long saveCustomer(Customer customer) {
		Long id = repo.save(customer).getId();
		if(id!=null) {
			User user = new User();
			user.setDisplayName(customer.getName());
			user.setEmail(customer.getEmail());
			user.setContact(customer.getMobile());
			user.setRole(UserRole.BUYER);
			user.setAddress(customer.getAddress().get(0).toString());
			userService.saveUser(user);
		}
		return id;
	}

	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public Customer findByEmail(String email) {
		return repo.findByEmail(email).get();
	}
	@Override
	public List<Address> getCustomerAddress(Long id) {
		return repo.getCustomerAddress(id);
	}
}
