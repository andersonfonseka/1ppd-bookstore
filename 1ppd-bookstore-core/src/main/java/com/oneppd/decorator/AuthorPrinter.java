package com.oneppd.decorator;

import com.oneppd.domain.Author;

public class AuthorPrinter implements Printer {

	private Author author;

	public AuthorPrinter(Author author) {
		super();
		this.author = author;
	}

	@Override
	public String doPrint() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.author.getUuid() + "\n");
		sb.append(this.author.getName() + "\n");

		return sb.toString();
	}


}
