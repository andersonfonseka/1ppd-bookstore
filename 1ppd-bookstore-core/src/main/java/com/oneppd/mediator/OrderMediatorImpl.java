package com.oneppd.mediator;

import java.util.ArrayList;
import java.util.Date;

import com.oneppd.command.OrderCommand;
import com.oneppd.decorator.OrderPrinter;
import com.oneppd.decorator.PrinterImpl;
import com.oneppd.domain.Address;
import com.oneppd.domain.Item;
import com.oneppd.domain.Order;
import com.oneppd.domain.Payment;
import com.oneppd.domain.PaymentMethod;
import com.oneppd.domain.ShoppingCart;
import com.oneppd.repository.BookstoreAbstractRepository;

public class OrderMediatorImpl implements OrderMediator {

	private ShoppingCart shoppingCart;
	
	private BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
	
	private Order order = new Order();

	public OrderMediatorImpl(ShoppingCart shoppingCart) {
		
		this.shoppingCart = shoppingCart;
		
		order.setDate(new Date());
		order.setCustomer(this.shoppingCart.getCustomer());
		order.setItems(new ArrayList<Item>(this.shoppingCart.getItems()));
		
		for (Item item : order.getItems()) {
			item.setOrder(order);
		}
	}


	@Override
	public void checkout(PaymentMethod paymentMethod, Address shippingAddress) {
		
		Payment payment = new Payment();
		payment.setDate(new Date());
		payment.setPaymentMethod(paymentMethod);
		
		double itemsValue = 0.0;
		
		for(Item item: this.order.getItems()) {
			itemsValue =+ item.getBook().getPrice().getValue() * item.getQuantity();
		}
		
		payment.setValue(itemsValue);
		
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		
		OrderCommand orderCommand = new OrderCommand(order);
		orderCommand.execute();
		
	}

	@Override
	public void complete() {
		abstractRepository.getOrderRepository().add(this.order);
	}

	@Override
	public void remove(Item item) {
		this.order.getItems().remove(item);
	}

	@Override
	public void update(Item item) {
		int idx = this.order.getItems().indexOf(item);
		this.order.getItems().set(idx, item);
	}

	@Override
	public void add(Item item) {
		this.order.getItems().add(item);
	}


	@Override
	public Order getOrder() {
		return this.order;
	}

	@Override
	public String print() {
		return new PrinterImpl(new OrderPrinter(this.order)).doPrint();
	}

}
