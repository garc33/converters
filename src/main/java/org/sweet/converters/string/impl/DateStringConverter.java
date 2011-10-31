package org.sweet.converters.string.impl;

import java.text.Format;
import java.text.SimpleDateFormat;

import org.sweet.converters.utils.PatternType;


public class DateStringConverter extends PatternStringConverter {

	public DateStringConverter(PatternType type) {
		super(type);
	}

	public DateStringConverter(String pattern) {
		super(pattern);
	}

	@Override
	protected Format createFormat() {
		return new SimpleDateFormat(getPattern());
	}
}
