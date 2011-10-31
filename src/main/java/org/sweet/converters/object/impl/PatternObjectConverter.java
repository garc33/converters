package org.sweet.converters.object.impl;

import java.text.Format;

import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.utils.PatternType;


public abstract class PatternObjectConverter<T> extends SimpleObjectConverter<T> {

	private final String pattern;

	private Format format;

	protected PatternObjectConverter(PatternType type) {
		this(type.getPattern());
	}

	protected PatternObjectConverter(String pattern) {
		this.pattern = pattern;
	}

	public final String getPattern() {
		return pattern;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected T doConvert(String s) throws ConverterException {
		try {
			return (T) getFormat().parseObject(s);
		} catch (Exception e) {
			throw new ConverterException("Failed to convert <" + s + "> with pattern <" + pattern + ">", e);
		}
	}

	protected final Format getFormat() throws ConverterException {
		if (format == null) {
			try {
				this.format = createFormat();
			} catch (Exception e) {
				throw new ConverterException("Failed to create format with pattern <" + pattern + ">", e);
			}
		}

		return format;
	}

	protected abstract Format createFormat();
}
