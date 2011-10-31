package org.sweet.converters.object.impl;

import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.object.ObjectConverter;

public class StringObjectConverter implements ObjectConverter<String> {

	public String convert(String s) throws ConverterException {
		return s;
	}

	public String getUsage() {
		return "<string>";
	}
}
