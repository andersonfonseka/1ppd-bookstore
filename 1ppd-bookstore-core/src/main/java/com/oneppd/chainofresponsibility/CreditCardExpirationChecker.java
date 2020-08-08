package com.oneppd.chainofresponsibility;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import com.oneppd.domain.CreditCard;

public class CreditCardExpirationChecker extends CreditCardChecker {
	
	private static Logger LOGGER = Logger.getLogger(CreditCardExpirationChecker.class.getName()); 

	public CreditCardExpirationChecker(CreditCardChecker creditCardChecker) {
		super(creditCardChecker);
	}

	public boolean validate(double value, CreditCard creditCard) {
		
		Calendar calendar = new GregorianCalendar();
		
		if (calendar.get(Calendar.YEAR) <= creditCard.getExpirationYear()) {
			if (calendar.get(Calendar.MONTH) <= creditCard.getExpirationMonth()) {
				LOGGER.info("Credit Card no. " + creditCard.getNumber() + " valid expiration date");
				return true;
			} 
		}
		
		LOGGER.info("Credit Card no. " + creditCard.getNumber() + " expired");
		
		return false;
	}

}
