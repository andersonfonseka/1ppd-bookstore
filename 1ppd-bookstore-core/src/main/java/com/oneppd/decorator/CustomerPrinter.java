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
			
			sb.append("Customer\n");
			sb.append("===================================\n");

			
			sb.append(this.customer.getUuid() +"\n");
			sb.append(this.customer.getFirstName() +"\n");
			sb.append(this.customer.getLastName() +"\n");
			sb.append(this.customer.getNickName() +"\n");
			
			for (Address address: this.customer.getAddresses()) {
				sb.append("-------------------------------------------------------\n");
				sb.append(address.getAddress()+"\n");
				sb.append(address.getAddress2()+"\n");
				sb.append(address.getCity()+"\n");
				sb.append(address.getState()+"\n");
				sb.append(address.getCountry()+"\n");
				sb.append(address.getZip()+"\n");
			}
			
			for (CreditCard creditCard: this.customer.getCreditCards()) {
				sb.append("-------------------------------------------------------\n");
				sb.append(creditCard.getType()+"\n");
				sb.append(creditCard.getNumber()+"\n");
				sb.append(creditCard.getSecurityCode()+"\n");
				sb.append(creditCard.getFirstName()+"\n");
				sb.append(creditCard.getLastName()+"\n");
				sb.append(creditCard.getLimit()+"\n");
				sb.append(creditCard.getExpirationMonth() +"/"+ creditCard.getExpirationYear() +"\n");
			}
		
			return sb.toString();
	}

	
}
