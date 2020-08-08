package com.oneppd.service;

import com.oneppd.domain.Order;
import com.oneppd.observer.Observable;

public interface PaymentService extends Service, Observable {
	
	public void process(Order order); 

}
