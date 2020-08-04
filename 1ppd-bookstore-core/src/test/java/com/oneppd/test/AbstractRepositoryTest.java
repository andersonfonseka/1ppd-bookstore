package com.oneppd.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.oneppd.builders.AuthorBuilderImpl;
import com.oneppd.domain.Author;
import com.oneppd.domain.Book;
import com.oneppd.domain.BookHasAuthor;
import com.oneppd.repository.AbstractRepository;
import com.oneppd.repository.memory.AuthorRepository;
import com.oneppd.repository.memory.BookHasAuthorRepository;
import com.oneppd.repository.memory.BookRepository;

public class AbstractRepositoryTest {

	@Test
	public void test() {
		
		AbstractRepository abstractRepository = AbstractRepository.getRepository("");
		assertNull(abstractRepository);
		
	}

	
}
