package com.oneppd.interpreter;

import java.util.Calendar;

public class DateGreaterThanExpression implements Expression {
	
	Expression expr1;
	
	Expression expr2;
	
	public DateGreaterThanExpression(Expression expr1, Expression expr2) {
		super();
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean interpreter() {
		
		int result = -1;
		
		if (expr1.interpreter() && expr2.interpreter()) {
			result = ((Calendar) this.expr1.getExpression().getValue()).compareTo((Calendar) this.expr2.getExpression().getValue());
		}
		
		return result < 0 ? false : true;
	}

	@Override
	public Expression getExpression() {
		return this;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
