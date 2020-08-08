package com.oneppd.repository.memory;

import java.util.List;
import java.util.stream.Collectors;

import com.oneppd.domain.CreditCard;
import com.oneppd.domain.Person;

public class CreditCardRepository extends BaseRepository<CreditCard> {
	
	private static CreditCardRepository INSTANCE;
	
	public static CreditCardRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CreditCardRepository();
		}

		return INSTANCE;
	}
	
	private CreditCardRepository() {}
	
	public List<CreditCard> listByPerson(Person person){
		List<CreditCard> creditCards = super.all().stream()
						.filter(ps -> ps.getPerson().getUuid().equals(person.getUuid()))
						.collect(Collectors.toList());
		
		return creditCards;
	}
	

}
