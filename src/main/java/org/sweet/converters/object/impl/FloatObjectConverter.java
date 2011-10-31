package org.sweet.converters.object.impl;

import org.sweet.converters.exception.ConverterException;

public class FloatObjectConverter extends NumberObjectConverter<Float> {

	public FloatObjectConverter(String pattern) {
		super(pattern);
	}

	@Override
	protected String getType() {
		return "decimal number";
	}

	@Override
	protected Float doConvert(String s) throws ConverterException {
		Number result = super.doConvert(s);

		return toNumber(result, Float.class);
	}
}
