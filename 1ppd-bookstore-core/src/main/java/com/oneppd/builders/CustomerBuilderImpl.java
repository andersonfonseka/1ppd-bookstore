package com.oneppd.builders;

import com.oneppd.domain.Customer;
import com.oneppd.repository.BookstoreAbstractRepository;

public class CustomerBuilderImpl implements CustomerBuilder {

	private Customer customer;

	private BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
	
	public CustomerBuilderImpl(String uuid) {
		this.customer = builderCustomer(uuid);
		buildAddress();
		buildCreditCard();
	}

	@Override
	public Customer builderCustomer(String uuid) {
		return (Customer) abstractRepository.getCustomerRepository().get(new Customer(uuid));
	}
	
	@Override
	public void buildAddress() {
		this.customer.setAddresses(abstractRepository.getAddressRepository().listByPerson(this.customer));
	}

	@Override
	public void buildCreditCard() {
		this.customer.setCreditCards(abstractRepository.getCreditCardRepository().listByPerson(this.customer));
	}
	
	@Override
	public Customer build() {
		return this.customer;
	}

	
}
