package com.oneppd.service.impl;

import com.oneppd.chainofresponsibility.CreditCardExpirationChecker;
import com.oneppd.chainofresponsibility.CreditCardLimitChecker;
import com.oneppd.domain.CreditCard;
import com.oneppd.domain.Order;
import com.oneppd.domain.Payment;
import com.oneppd.observer.Message;
import com.oneppd.repository.Repository;
import com.oneppd.service.PaymentService;

public class PaymentServiceImpl extends ServiceImpl<Payment> implements PaymentService {

	public PaymentServiceImpl() {}
	
	public PaymentServiceImpl(Repository<Payment> repository) {
		super(repository);
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
