package com.oneppd.observer;

import java.util.ArrayList;
import java.util.List;

import com.oneppd.state.Context;

public class BookstoreObserver {
	
	private static BookstoreObserver INSTANCE;
	
	private List<Observable> observables = new ArrayList<Observable>();

	private BookstoreObserver() {
		this.observables.add((Observable) new Context());
	}
	
	public static BookstoreObserver getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BookstoreObserver();
		}

		return INSTANCE;
	}

	public void addMessage(Message message) {
		for (Observable observable : observables) {
			observable.update(message);
		}
	}
	
}
