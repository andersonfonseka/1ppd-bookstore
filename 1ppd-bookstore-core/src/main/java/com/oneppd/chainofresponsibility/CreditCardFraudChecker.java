package com.oneppd.chainofresponsibility;

import java.util.logging.Logger;

import com.oneppd.domain.CreditCard;

public class CreditCardFraudChecker extends CreditCardChecker {
	
	private static Logger LOGGER = Logger.getLogger(CreditCardFraudChecker.class.getName()); 

	public CreditCardFraudChecker(CreditCardChecker creditCardChecker) {
		super(creditCardChecker);
	}

	@Override
	public boolean validate(double value, CreditCard creditCard) {
		boolean valid = creditCard.getFirstName().equals("Anderson");

		if (!valid) {
			LOGGER.info("Credit Card no. " + creditCard.getNumber() + " valid name");
		} else {	
			LOGGER.info("Credit Card no. " + creditCard.getNumber() + " fraud detected by name");
		}
		
		return valid;
	}

}
