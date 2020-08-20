package com.oneppd.decorator;

import com.oneppd.domain.Address;
import com.oneppd.domain.CreditCard;
import com.oneppd.domain.Customer;

public class CustomerPrinter implements DecoratorPrinter {

	private Customer customer;

	public CustomerPrinter(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public String doPrint() {
		
			StringBuilder sb = new StringBuilder();

			sb.append(this.customer.getLastName() +", ");
			sb.append(this.customer.getFirstName() +"\n");
			sb.append(this.customer.getNickName() +"\n");
			
			for (Address address: this.customer.getAddresses()) {
				sb.append(new AddressPrinter(address).doPrint());
			}
			
			for (CreditCard creditCard: this.customer.getCreditCards()) {
				sb.append(new CreditCardPrinter(creditCard).doPrint());
			}
		
			return sb.toString();
	}

	
}
