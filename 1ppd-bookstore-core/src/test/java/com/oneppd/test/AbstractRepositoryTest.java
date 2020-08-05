package com.oneppd.test;

import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.oneppd.repository.BookstoreAbstractRepository;

public class AbstractRepositoryTest {

	@Test
	public void test() {
		
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository("");
		assertNull(abstractRepository);
		
	}

	
}
