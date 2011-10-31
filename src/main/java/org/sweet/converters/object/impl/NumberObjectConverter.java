package org.sweet.converters.object.impl;

import java.text.DecimalFormat;
import java.text.Format;

import org.apache.commons.lang.StringUtils;
import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.utils.PatternType;


public abstract class NumberObjectConverter<N extends Number> extends PatternObjectConverter<N> {

	public NumberObjectConverter(PatternType type) {
		super(type);
	}

	public NumberObjectConverter(String pattern) {
		super(pattern);
	}

	public String getUsage() {
		String pattern = getPattern();

		if (StringUtils.isNotBlank(pattern)) {
			return '<' + getType() + ' ' + pattern + '>';
		} else {
			return '<' + getType() + '>';
		}
	}

	protected abstract String getType();

	@Override
	protected Format createFormat() {
		String pattern = getPattern();

		if (StringUtils.isNotBlank(pattern)) {
			return new DecimalFormat(pattern);
		} else {
			return new DecimalFormat();
		}
	}

	@SuppressWarnings("unchecked")
	protected final <T> T toNumber(Number value, Class<T> wantedType) throws ConverterException {
		if (wantedType.equals(value.getClass())) {
			return (T) value;
		}

		if (wantedType.equals(Integer.class)) {
			final long longValue = value.longValue();

			if (longValue > Integer.MAX_VALUE) {
				throw new ConverterException("Value <" + value + "> is too large for Integer");
			}

			if (longValue < Integer.MIN_VALUE) {
				throw new ConverterException("Value <" + value + "> is too small for Integer");
			}

			return (T) Integer.valueOf(value.intValue());
		}

		if (wantedType.equals(Long.class)) {
			final long longValue = value.longValue();

			if (longValue > Long.MAX_VALUE) {
				throw new ConverterException("Value <" + value + "> is too large for Long");
			}

			if (longValue < Long.MIN_VALUE) {
				throw new ConverterException("Value <" + value + "> is too small for Long");
			}

			return (T) Long.valueOf(value.longValue());
		}

		final double doubleValue = value.doubleValue();

		if (wantedType.equals(Float.class)) {
			if (doubleValue > Float.MAX_VALUE) {
				throw new ConverterException("Value <" + value + "> is too large for Float");
			}

			if (doubleValue < Float.MIN_VALUE) {
				throw new ConverterException("Value <" + value + "> is too small for Float");
			}

			return (T) new Float(value.floatValue());
		}

		if (wantedType.equals(Double.class)) {
			if (doubleValue > Double.MAX_VALUE) {
				throw new ConverterException("Value <" + value + "> is too large for Double");
			}

			if (doubleValue < Double.MIN_VALUE) {
				throw new ConverterException("Value <" + value + "> is too small for Double");
			}

			return (T) new Double(doubleValue);
		}

		throw new ConverterException("Don't know how to convert <" + value + "> to <" + wantedType + ">");
	}
}
