package com.oneppd.service.impl;

import com.oneppd.chainofresponsibility.CreditCardExpirationChecker;
import com.oneppd.chainofresponsibility.CreditCardLimitChecker;
import com.oneppd.domain.CreditCard;
import com.oneppd.domain.Order;
import com.oneppd.observer.BookstoreObserver;
import com.oneppd.observer.Message;
import com.oneppd.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
	
	private BookstoreObserver bookstoreObserver = BookstoreObserver.getInstance();
	
	public PaymentServiceImpl() {
		bookstoreObserver.add(this);
	}

	@Override
	public void process(Order order) {
		if (order.getPayment().getPaymentMethod() instanceof CreditCard) {

			CreditCard creditCard = (CreditCard) order.getPayment().getPaymentMethod();
			
			CreditCardLimitChecker limitChecker = new CreditCardLimitChecker(null);
			CreditCardExpirationChecker expirationChecker = new CreditCardExpirationChecker(limitChecker);
			
			expirationChecker.processRequest(order.getPayment().getValue(), creditCard);
		}
	}

	@Override
	public void update(Message o) {
		if (o.getType().equals(Message.PAYMENT)) {
			process((Order) o.getMessage());
		}
	}


}
