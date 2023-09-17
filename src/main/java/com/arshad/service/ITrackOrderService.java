package com.arshad.service;

import java.util.List;

import com.arshad.entity.TrackOrder;

public interface ITrackOrderService {

	void addTrackOrder(TrackOrder to);
	List<TrackOrder> getAllTrackOrdersByOrderid(Long orderId);
}
