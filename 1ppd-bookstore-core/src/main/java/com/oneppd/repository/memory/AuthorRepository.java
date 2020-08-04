package com.oneppd.repository.memory;

import com.oneppd.domain.Author;

public class AuthorRepository extends BaseRepository<Author> {
	
	private static AuthorRepository INSTANCE;
	
	public static AuthorRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AuthorRepository();
		}

		return INSTANCE;
	}
	
	private AuthorRepository() {}
	

}
