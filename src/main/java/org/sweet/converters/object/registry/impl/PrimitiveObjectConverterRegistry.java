package org.sweet.converters.object.registry.impl;

import org.apache.commons.lang.ClassUtils;
import org.sweet.converters.object.ObjectConverter;
import org.sweet.converters.object.registry.ObjectConverterRegistry;


public class PrimitiveObjectConverterRegistry extends ObjectConverterRegistryDelegate {

	public PrimitiveObjectConverterRegistry(ObjectConverterRegistry delegate) {
		super(delegate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> ObjectConverter<T> getConverter(Class<T> type) {
		return super.getConverter(ClassUtils.primitiveToWrapper(type));
	}
}
