package com.oneppd.service;

import com.oneppd.domain.Order;
import com.oneppd.domain.Payment;

public interface PaymentService extends Service<Payment> {
	
	public void process(Order order); 

}
