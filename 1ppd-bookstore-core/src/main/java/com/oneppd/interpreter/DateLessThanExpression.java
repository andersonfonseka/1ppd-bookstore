package com.oneppd.interpreter;

import java.util.Calendar;

public class DateLessThanExpression implements Expression {
	
	Expression expr1;
	
	Expression expr2;
	
	public DateLessThanExpression(Expression expr1, Expression expr2) {
		super();
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean interpreter() {
		
		int result = 1;
		
		if (expr1.interpreter() && expr2.interpreter()) {
			result =  ((Calendar) this.expr1.getExpression().getValue()).compareTo((Calendar) this.expr2.getExpression().getValue());
		}
		
		return result < 0 ? true : false;
	}

	@Override
	public Object getValue() {
		return null;
	}

	@Override
	public Expression getExpression() {
		return null;
	}



}
