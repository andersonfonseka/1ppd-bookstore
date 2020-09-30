package com.oneppd.memento;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

import com.oneppd.domain.ShoppingCart;

public class Memento {
	
	private static Memento INSTANCE;
	
	private static ReentrantLock lock = new ReentrantLock();

	private Stack<ShoppingCart> stack = new Stack<ShoppingCart>();
	
	private Memento() {}
	
	public static Memento getInstance() {
		
		lock.lock();
		if (INSTANCE == null) {
			INSTANCE = new Memento();
		}
		lock.unlock();

		return INSTANCE;
	}
	
	
	public void saveState(ShoppingCart e) {
		try {
			this.stack.push(e.clone());
		} catch (CloneNotSupportedException e1) {}
	}
	
	public ShoppingCart restore() {
		return stack.pop();
	}

}
