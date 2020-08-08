package com.oneppd.repository.memory;

import java.util.List;
import java.util.stream.Collectors;

import com.oneppd.domain.Address;
import com.oneppd.domain.Person;

public class AddressRepository extends BaseRepository<Address> {
	
	private static AddressRepository INSTANCE;
	
	public static AddressRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AddressRepository();
		}

		return INSTANCE;
	}
	
	private AddressRepository() {}
	
	public List<Address> listByPerson(Person person){
		List<Address> addresses = super.all().stream()
						.filter(ps -> ps.getPerson().getUuid().equals(person.getUuid()))
						.collect(Collectors.toList());
		
		return addresses;
	}
	

}
