package com.CP.service;

import com.CP.dto.Purchase;
import com.CP.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder (Purchase purchase);
	
}
