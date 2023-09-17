package com.arshad.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arshad.entity.Address;
import com.arshad.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmail(String email);
	@Query("SELECT c.address FROM Customer c WHERE c.id=:id")
	List<Address> getCustomerAddress(Long id);
}
