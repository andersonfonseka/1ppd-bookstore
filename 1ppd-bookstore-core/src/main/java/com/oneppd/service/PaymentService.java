package com.oneppd.service;

import com.oneppd.domain.Order;
import com.oneppd.domain.Payment;
import com.oneppd.observer.Observable;

public interface PaymentService extends Service<Payment>, Observable {
	
	public void process(Order order); 

}
