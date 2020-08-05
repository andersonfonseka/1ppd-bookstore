package com.oneppd.decorator;

public class PrinterImpl implements DecoratorPrinter {

	private DecoratorPrinter printer;
	
	public PrinterImpl(DecoratorPrinter printer) {
		super();
		this.printer = printer;
	}

	@Override
	public String doPrint() {
		return this.printer.doPrint();
	}

}
