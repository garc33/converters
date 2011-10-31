package org.sweet.converters.object.impl;

import java.text.DecimalFormat;
import java.text.Format;

import org.sweet.converters.exception.ConverterException;


public class LongObjectConverter extends NumberObjectConverter<Long> {

	public LongObjectConverter(String pattern) {
		super(pattern);
	}

	@Override
	protected String getType() {
		return "integer";
	}

	@Override
	protected Long doConvert(String s) throws ConverterException {
		Number result = super.doConvert(s);

		return toNumber(result, Long.class);
	}

	@Override
	protected Format createFormat() {
		DecimalFormat result = (DecimalFormat) super.createFormat();

		result.setMaximumFractionDigits(0);
		result.setDecimalSeparatorAlwaysShown(false);
		result.setParseIntegerOnly(true);

		return result;
	}
}
