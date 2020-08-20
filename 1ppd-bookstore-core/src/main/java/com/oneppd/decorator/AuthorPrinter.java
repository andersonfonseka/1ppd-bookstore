package com.oneppd.decorator;

import com.oneppd.domain.Author;

public class AuthorPrinter implements DecoratorPrinter {

	private Author author;

	public AuthorPrinter(Author author) {
		super();
		this.author = author;
	}

	@Override
	public String doPrint() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.author.getName() + ", ");

		return sb.toString();
	}


}
