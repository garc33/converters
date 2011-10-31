package org.sweet.converters.object;

import org.sweet.converters.exception.ConverterException;

public interface ObjectConverter<T> {

	T convert(String s) throws ConverterException;

	String getUsage();
}
