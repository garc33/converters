package org.sweet.converters.object.impl;

import org.sweet.converters.exception.ConverterException;

public class DoubleObjectConverter extends NumberObjectConverter<Double> {

	public DoubleObjectConverter(String pattern) {
		super(pattern);
	}

	@Override
	protected String getType() {
		return "decimal number";
	}

	@Override
	protected Double doConvert(String s) throws ConverterException {
		Number result = super.doConvert(s);

		return toNumber(result, Double.class);
	}
}
