package com.oneppd.service;

import java.util.List;

import com.oneppd.domain.CreditCard;
import com.oneppd.domain.Customer;

public interface CreditCardService extends Service {
	
	/* Credit Card */
	
	public void add(CreditCard creditCard);

	public void update(CreditCard creditCard);

	public void remove(CreditCard creditCard);

	public Customer get(CreditCard creditCard);

	public List<CreditCard> allCreditCard();

}
