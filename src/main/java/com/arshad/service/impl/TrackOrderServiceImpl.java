package com.arshad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshad.entity.TrackOrder;
import com.arshad.repo.TrackOrderRepository;
import com.arshad.service.ITrackOrderService;

@Service
public class TrackOrderServiceImpl implements ITrackOrderService {

	@Autowired
	private TrackOrderRepository repo;
	
	@Override
	public void addTrackOrder(TrackOrder to) {
		repo.save(to);
	}

	@Override
	public List<TrackOrder> getAllTrackOrdersByOrderid(Long orderId) {
		return repo.findAllTrackOrderByOrderId(orderId);
	}

}
