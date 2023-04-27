package com.CP.dto;

import java.util.Set;

import com.CP.entities.Address;
import com.CP.entities.Customer;
import com.CP.entities.Order;
import com.CP.entities.OrderItem;

import lombok.Data;

@Data
public class Purchase {
	
	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
	
}
