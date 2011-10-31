package org.sweet.converters.object.registry.impl;

import org.sweet.converters.object.ObjectConverter;
import org.sweet.converters.object.registry.ObjectConverterRegistry;

public abstract class ObjectConverterRegistryDelegate implements ObjectConverterRegistry {

	private final ObjectConverterRegistry delegate;

	protected ObjectConverterRegistryDelegate(ObjectConverterRegistry delegate) {
		this.delegate = delegate;
	}

	public <T> void register(Class<T> type, ObjectConverter<T> converter) {
		delegate.register(type, converter);
	}

	public <T> ObjectConverter<T> getConverter(Class<T> type) {
		return delegate.getConverter(type);
	}

	protected final ObjectConverterRegistry getDelegate() {
		return delegate;
	}
}
