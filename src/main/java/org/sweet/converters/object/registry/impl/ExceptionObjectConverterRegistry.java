package org.sweet.converters.object.registry.impl;

import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.object.ObjectConverter;
import org.sweet.converters.object.registry.ObjectConverterRegistry;

public class ExceptionObjectConverterRegistry extends
		ObjectConverterRegistryDelegate {

	public ExceptionObjectConverterRegistry(ObjectConverterRegistry delegate) {
		super(delegate);
	}

	@Override
	public <T> ObjectConverter<T> getConverter(Class<T> type) {
		ObjectConverter<T> result = super.getConverter(type);

		if (result == null) {
			throw new ConverterException("Don't know how to handle <" + type
					+ ">");
		}

		return result;
	}
}
