package com.oneppd.state;

import com.oneppd.domain.Order;
import com.oneppd.service.PaymentService;
import com.oneppd.service.impl.PaymentServiceImpl;

public class PaymentState implements State {
	
	private Order order;
	
	public PaymentState(Order order) {
		super();
		this.order = order;
	}

	@Override
	public void execute() {
		
		PaymentService paymentService = new PaymentServiceImpl();
		paymentService.process(this.order);
		
		new NotificationState(this.order).execute();
	}

}
