package org.sweet.converters.string;

import org.sweet.converters.exception.ConverterException;

public interface StringConverter {

	String convert(Object o) throws ConverterException;
}
