package com.oneppd.service.impl;

import com.oneppd.chainofresponsibility.CreditCardExpirationChecker;
import com.oneppd.chainofresponsibility.CreditCardFraudChecker;
import com.oneppd.chainofresponsibility.CreditCardLimitChecker;
import com.oneppd.domain.CreditCard;
import com.oneppd.domain.Order;
import com.oneppd.domain.Payment;
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
			
			CreditCardFraudChecker fraudChecker = new CreditCardFraudChecker(null);
			CreditCardLimitChecker limitChecker = new CreditCardLimitChecker(fraudChecker);
			CreditCardExpirationChecker expirationChecker = new CreditCardExpirationChecker(limitChecker);
			
			expirationChecker.processRequest(order.getPayment().getValue(), creditCard);
		}
	}




}
