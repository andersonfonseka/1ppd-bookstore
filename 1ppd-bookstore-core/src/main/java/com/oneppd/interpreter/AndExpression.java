package com.oneppd.interpreter;

public class AndExpression implements Expression {
	
	Expression expr1;
	
	Expression expr2;
	
	public AndExpression(Expression expr1, Expression expr2) {
		super();
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean interpreter() {
		return expr1.interpreter() && expr2.interpreter();
	}

	@Override
	public Expression getExpression() {
		return this;
	}

	@Override
	public Object getValue() {
		return null;
	}
	
	

}
