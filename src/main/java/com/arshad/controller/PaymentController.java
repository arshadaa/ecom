package com.arshad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arshad.constants.OrderStatus;
import com.arshad.entity.Order;
import com.arshad.service.IOrderService;
import com.arshad.util.OrderUtil;

@Controller
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private IOrderService orderService;
	@Autowired
	private OrderUtil orderUtil;
	
	@GetMapping("/billPay")
	public String showPayment(
			@RequestParam Long orderId,
			@RequestParam(required = false) String message,
			Model model) 
	{
		
		Order order = orderService.getOrderById(orderId);
		orderUtil.calculateGrandTotalOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("message", message);
		return "PaymentsPage";
	}
	
	@GetMapping("/showPay")
	public String showPaymentPage(
			@RequestParam Long orderId,
			Model model
			) 
	{
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return "ShowPaymentPage";
	}
	
	@GetMapping("/doPay")
	public String doPayment(
			@RequestParam Long orderId
			) 
	{
		orderService.updateOrderStatus(orderId, OrderStatus.PLACED.name());
		return "redirect:/order/customerOrders";
	}
}
