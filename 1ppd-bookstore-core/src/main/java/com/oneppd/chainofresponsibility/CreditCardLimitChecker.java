package com.oneppd.chainofresponsibility;

import java.util.logging.Logger;

import com.oneppd.domain.CreditCard;

public class CreditCardLimitChecker extends CreditCardChecker {
	
	private static Logger LOGGER = Logger.getLogger(CreditCardLimitChecker.class.getName()); 

	public CreditCardLimitChecker(CreditCardChecker creditCardChecker) {
		super(creditCardChecker);
	}

	@Override
	public boolean validate(double value, CreditCard creditCard) {
		boolean valid = creditCard.getLimit() >= value;

		if (valid) {
			LOGGER.info("Credit Card no. " + creditCard.getNumber() + " valid limit");
		} else {	
			LOGGER.info("Credit Card no. " + creditCard.getNumber() + " limit exceeded");
		}
		
		return valid;
	}

}
