package com.CP.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.CP.dto.Purchase;
import com.CP.dto.PurchaseResponse;
import com.CP.entities.Customer;
import com.CP.entities.Order;
import com.CP.entities.OrderItem;
import com.CP.repositories.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImp implements CheckoutService {
	
	private CustomerRepository customerRepository;
	
	public CheckoutServiceImp(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		Order order = purchase.getOrder();
		
		String orderTrackingNumber = generateTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));
		
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		Customer customer = purchase.getCustomer();
		customer.add(order);
		
		customerRepository.save(customer);
		
		return new PurchaseResponse(orderTrackingNumber);
	}
	
	private String generateTrackingNumber() {
		return UUID.randomUUID().toString();
	}
	
}
