package com.oneppd.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.oneppd.builders.CustomerBuilder;
import com.oneppd.builders.CustomerBuilderImpl;
import com.oneppd.decorator.CustomerPrinter;
import com.oneppd.decorator.DecoratorPrinter;
import com.oneppd.decorator.PrinterImpl;
import com.oneppd.domain.Address;
import com.oneppd.domain.CreditCard;
import com.oneppd.domain.Customer;
import com.oneppd.domain.Payment;
import com.oneppd.repository.BookstoreAbstractRepository;
import com.oneppd.repository.memory.AddressRepository;
import com.oneppd.repository.memory.CreditCardRepository;
import com.oneppd.repository.memory.CustomerRepository;

public class CustomerTest {

	@Test
	public void testAdd() {
		
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		
		CustomerRepository customerRepository = abstractRepository.getCustomerRepository();
		AddressRepository addressRepository = abstractRepository.getAddressRepository();
		CreditCardRepository creditCardRepository = abstractRepository.getCreditCardRepository();
		
		Customer customer = new Customer();
		customer.setFirstName("Anderson");
		customer.setLastName("Fonseca");
		
		customerRepository.add(customer);
		
		Address address = new Address();
		address.setPerson(customer);
		address.setAddress("Av. Tucunare, 2000");
		address.setAddress2("Condominio XPTO");
		address.setCity("Barueri");
		address.setState("SP");
		address.setCountry("Brazil");
		address.setZip("06000-000");
		
		addressRepository.add(address);
		
		CreditCard creditCard = new CreditCard();
		creditCard.setPerson(customer);
		creditCard.setType(Payment.VISA);
		creditCard.setFirstName(customer.getFirstName());
		creditCard.setLastName(customer.getLastName());
		creditCard.setExpirationMonth(2);
		creditCard.setExpirationYear(2019);
		creditCard.setNumber("0800 8910 3680 0500");
		creditCard.setLimit(100.00);
		creditCard.setSecurityCode("123");
		
		CreditCard creditCard1 = new CreditCard();
		creditCard1.setPerson(customer);
		creditCard1.setType(Payment.MASTERCARD);
		creditCard1.setFirstName(customer.getFirstName());
		creditCard1.setLastName(customer.getLastName());
		creditCard1.setExpirationMonth(12);
		creditCard1.setExpirationYear(2021);
		creditCard1.setNumber("5105 1051 0510 5100");
		creditCard1.setLimit(200.00);
		creditCard1.setSecurityCode("666");
		
		CreditCard creditCard2 = new CreditCard();
		creditCard2.setPerson(customer);
		creditCard2.setType(Payment.AMEX);
		creditCard2.setFirstName(customer.getFirstName());
		creditCard2.setLastName(customer.getLastName());
		creditCard2.setExpirationMonth(12);
		creditCard2.setExpirationYear(2020);
		creditCard2.setNumber("3782 8224 6310 005");
		creditCard2.setLimit(1000.00);
		creditCard2.setSecurityCode("999");
		
		creditCardRepository.add(creditCard);
		creditCardRepository.add(creditCard1);
		creditCardRepository.add(creditCard2);
		
		CustomerBuilder builder = new CustomerBuilderImpl(customer.getUuid());
		Customer customer2 = builder.build();
		
		DecoratorPrinter printer = new PrinterImpl(new CustomerPrinter(customer2));
		System.out.println(printer.doPrint());
		
		assertNotNull(customer2);
		
	}
		
}
