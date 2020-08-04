package com.oneppd.repository.memory;

import java.util.List;
import java.util.stream.Collectors;

import com.oneppd.domain.Author;
import com.oneppd.domain.Book;
import com.oneppd.domain.BookHasAuthor;

public class BookHasAuthorRepository extends BaseRepository<BookHasAuthor> {

	private static BookHasAuthorRepository INSTANCE;
	
	public static BookHasAuthorRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BookHasAuthorRepository();
		}

		return INSTANCE;
	}
	
	
	private BookHasAuthorRepository() {}
	
	public List<Author> listByBook(Book book){
		List<Author> authors = super.all().stream()
						.filter(ba -> ba.getBook().getUuid().equals(book.getUuid()))
						.map(a -> a.getAuthor())
						.collect(Collectors.toList());
		
		return authors;
	}
	
	public List<Book> listByAuthor(Author author){
		List<Book> books = super.all().stream()
						.filter(ba -> ba.getAuthor().getUuid().equals(author.getUuid()))
						.map(b -> b.getBook())
						.collect(Collectors.toList());
		
		return books;
	}
	
}
