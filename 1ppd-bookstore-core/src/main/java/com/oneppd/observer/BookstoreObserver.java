package com.oneppd.observer;

import java.util.ArrayList;
import java.util.List;

public class BookstoreObserver {
	
	private static BookstoreObserver INSTANCE;
	
	private List<Observable> observables = new ArrayList<Observable>();

	private BookstoreObserver() {}
	
	public static BookstoreObserver getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BookstoreObserver();
		}

		return INSTANCE;
	}
	
	public void add(Observable observable) {
		this.observables.add(observable);
	}
	
	public void addMessage(Message message) {
		for (Observable observable : observables) {
			observable.update(message);
		}
	}
	
}
