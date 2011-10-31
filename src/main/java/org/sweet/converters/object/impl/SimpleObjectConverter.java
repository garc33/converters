package org.sweet.converters.object.impl;

import org.apache.commons.lang.StringUtils;
import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.object.ObjectConverter;


public abstract class SimpleObjectConverter<T> implements ObjectConverter<T> {

	public T convert(String s) throws ConverterException {
		if (StringUtils.isBlank(s)) {
			return null;
		}

		return doConvert(s);
	}

	protected abstract T doConvert(String s) throws ConverterException;
}
