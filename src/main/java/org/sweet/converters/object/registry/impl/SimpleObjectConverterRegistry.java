package org.sweet.converters.object.registry.impl;

import java.util.HashMap;
import java.util.Map;

import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.object.ObjectConverter;
import org.sweet.converters.object.registry.ObjectConverterRegistry;


public class SimpleObjectConverterRegistry implements ObjectConverterRegistry {

	private final Map<Class<?>, ObjectConverter<?>> converters = new HashMap<Class<?>, ObjectConverter<?>>();

	public <T> void register(Class<T> type, ObjectConverter<T> converter) {
		ObjectConverter<?> currentConverter = converters.get(type);

		if (currentConverter != null) {
			throw new ConverterException("There is already a converter for <" + type + "> : " + currentConverter);
		}

		converters.put(type, converter);
	}

	@SuppressWarnings("unchecked")
	public <T> ObjectConverter<T> getConverter(Class<T> type) {
		return (ObjectConverter<T>) converters.get(type);
	}
}
