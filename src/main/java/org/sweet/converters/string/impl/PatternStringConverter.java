package org.sweet.converters.string.impl;

import java.text.Format;

import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.utils.PatternType;


public abstract class PatternStringConverter extends SimpleStringConverter {

	private final String pattern;

	private Format format;

	protected PatternStringConverter(PatternType type) {
		this(type.getPattern());
	}

	protected PatternStringConverter(String pattern) {
		this.pattern = pattern;
	}

	public final String getPattern() {
		return pattern;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("PatternStringConverter<");
		sb.append(pattern);
		sb.append('>');

		return sb.toString();
	}

	@Override
	protected String doConvert(Object o) throws ConverterException {
		try {
			return getFormat().format(o);
		} catch (IllegalArgumentException iae) {
			throw new ConverterException("Failed to convert <" + o
					+ "> with pattern <" + pattern + ">", iae);
		}
	}

	protected final Format getFormat() throws ConverterException {
		if (format == null) {
			try {
				this.format = createFormat();
			} catch (Exception e) {
				throw new ConverterException(
						"Failed to create format with pattern <" + pattern
								+ ">", e);
			}
		}

		return format;
	}

	protected abstract Format createFormat();
}
