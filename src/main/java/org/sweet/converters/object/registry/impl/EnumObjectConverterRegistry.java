package org.sweet.converters.object.registry.impl;

import org.sweet.converters.object.ObjectConverter;
import org.sweet.converters.object.impl.EnumObjectConverter;
import org.sweet.converters.object.registry.ObjectConverterRegistry;

public class EnumObjectConverterRegistry extends ObjectConverterRegistryDelegate {

	public EnumObjectConverterRegistry(ObjectConverterRegistry delegate) {
		super(delegate);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> ObjectConverter<T> getConverter(Class<T> type) {
		ObjectConverter<T> result = super.getConverter(type);

		if (result == null && type.isEnum()) {
			result = new EnumObjectConverter(type);

			register(type, result);
		}

		return result;
	}
}
