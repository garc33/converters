package org.sweet.converters.string.impl;

import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.string.StringConverter;
import org.sweet.converters.utils.ConverterConstants;

public class ArrayStringConverter extends SimpleStringConverter {

	private final StringConverter elementConverter;

	private final char separator;

	public ArrayStringConverter(StringConverter elementConverter) {
		this(elementConverter, ConverterConstants.DEFAULT_SEPARATOR);
	}

	public ArrayStringConverter(StringConverter elementConverter,
			final char separator) {
		this.elementConverter = elementConverter;
		this.separator = separator;
	}

	@Override
	protected String doConvert(Object o) throws ConverterException {
		Object[] array = (Object[]) o;
		StringBuilder sb = new StringBuilder();
		boolean first = true;

		for (Object object : array) {
			if (first) {
				first = false;
			} else {
				sb.append(separator);
			}

			sb.append(elementConverter.convert(object));
		}

		return sb.toString();
	}
}
