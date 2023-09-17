package com.arshad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arshad.entity.Order;
import com.arshad.repo.OrderRepository;
import com.arshad.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository repo;
	
	public Long placeOrder(Order order) {
		return repo.save(order).getId();
	}

	@Override
	public List<Order> getOrdersByCustomerId(Long id) {
		return repo.getOrdersByCustomer(id);
	}

	@Override
	public List<Order> fetchAllOrders() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public void updateOrderStatus(Long id, String status) {
		repo.updateOrderStatus(id, status);
	}

	@Override
	public List<Order> findByOrderStatus(String status) {
		return repo.findByStatus(status);
	}
	
	@Override
	public Order getOrderById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Object[]> getOrderStatusAndCount() {
		return repo.getOrderStatusAndCount();
	}
}
