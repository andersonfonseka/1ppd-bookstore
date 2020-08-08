package com.oneppd.decorator;

import com.oneppd.domain.CreditCard;

public class CreditCardPrinter implements DecoratorPrinter {

	private CreditCard creditCard;

	public CreditCardPrinter(CreditCard creditCard) {
		super();
		this.creditCard = creditCard;
	}

	@Override
	public String doPrint() {
		
			StringBuilder sb = new StringBuilder();
			
			sb.append("-------------------------------------------------------\n");
			sb.append(creditCard.getType()+"\n");
			sb.append(creditCard.getNumber()+"\n");
			sb.append(creditCard.getSecurityCode()+"\n");
			sb.append(creditCard.getFirstName()+"\n");
			sb.append(creditCard.getLastName()+"\n");
			sb.append(creditCard.getLimit()+"\n");
			sb.append(creditCard.getExpirationMonth() +"/"+ creditCard.getExpirationYear() +"\n");
		
			return sb.toString();
	}

	
}
