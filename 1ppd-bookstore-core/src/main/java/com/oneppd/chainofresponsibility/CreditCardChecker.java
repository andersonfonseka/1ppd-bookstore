package com.oneppd.chainofresponsibility;

import com.oneppd.domain.CreditCard;

public abstract class CreditCardChecker {
	
	private CreditCardChecker creditCardChecker;
	
	public CreditCardChecker(CreditCardChecker creditCardChecker) {
		super();
		this.creditCardChecker = creditCardChecker;
	}

	public abstract boolean validate(double value, CreditCard creditCard);
	
	public void processRequest(double value, CreditCard creditCard){
		if(this.validate(value, creditCard) && (null != this.creditCardChecker)){
			this.creditCardChecker.processRequest(value, creditCard);
		}
	}
	
}
