package com.oneppd.decorator;

public class PrinterImpl implements Printer {

	private Printer printer;
	
	public PrinterImpl(Printer printer) {
		super();
		this.printer = printer;
	}

	@Override
	public String doPrint() {
		return this.printer.doPrint();
	}

}
