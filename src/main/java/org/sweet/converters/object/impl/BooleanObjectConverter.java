package org.sweet.converters.object.impl;

import org.sweet.converters.exception.ConverterException;

public class BooleanObjectConverter extends SimpleObjectConverter<Boolean> {

	public String getUsage() {
		return "<y/n>";
	}

	@Override
	protected Boolean doConvert(String s) throws ConverterException {
		if ("true".equalsIgnoreCase(s) || "y".equalsIgnoreCase(s)) {
			return Boolean.TRUE;
		} else if ("false".equalsIgnoreCase(s) || "n".equalsIgnoreCase(s)) {
			return Boolean.FALSE;
		} else {
			throw new ConverterException("Invalid boolean value <" + s
					+ ">, must be one of <true, y, false, n>");
		}
	}
}
