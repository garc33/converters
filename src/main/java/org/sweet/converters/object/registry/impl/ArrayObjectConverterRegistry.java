package org.sweet.converters.object.registry.impl;

import org.sweet.converters.object.ObjectConverter;
import org.sweet.converters.object.impl.ArrayObjectConverter;
import org.sweet.converters.object.registry.ObjectConverterRegistry;

public class ArrayObjectConverterRegistry extends ObjectConverterRegistryDelegate {

	public ArrayObjectConverterRegistry(ObjectConverterRegistry delegate) {
		super(delegate);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> ObjectConverter<T> getConverter(Class<T> type) {
		ObjectConverter<T> result = super.getConverter(type);

		if (result == null && type.isArray()) {
			Class<?> componentType = type.getComponentType();
			ObjectConverter<?> componentConverter = getDelegate().getConverter(componentType);

			if (componentConverter != null) {
				result = new ArrayObjectConverter(componentConverter, componentType);

				register(type, result);
			}
		}

		return result;
	}
}
