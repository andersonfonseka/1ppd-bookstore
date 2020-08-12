package com.oneppd.facade;

import com.oneppd.repository.AbstractRepository;
import com.oneppd.repository.BookstoreAbstractRepository;
import com.oneppd.service.AddressService;
import com.oneppd.service.CustomerService;
import com.oneppd.service.ServiceFactory;
import com.oneppd.service.impl.AddressServiceImpl;
import com.oneppd.service.impl.CustomerServiceImpl;

public class CustomerFacade {
	
	public CustomerService getCustomerService() {
		return (CustomerService) new ServiceFactory().getService(new CustomerServiceImpl(BookstoreAbstractRepository.getRepository(AbstractRepository.MEMORY).getCustomerRepository()));
	}
	
	public AddressService getAddressService() {
		return (AddressService) new ServiceFactory().getService(new AddressServiceImpl(BookstoreAbstractRepository.getRepository(AbstractRepository.MEMORY).getAddressRepository()));
	}
	
}
