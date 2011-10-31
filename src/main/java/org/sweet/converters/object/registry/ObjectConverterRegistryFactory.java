package org.sweet.converters.object.registry;

import org.sweet.converters.object.registry.impl.ArrayObjectConverterRegistry;
import org.sweet.converters.object.registry.impl.DefaultObjectConverterRegistry;
import org.sweet.converters.object.registry.impl.EnumObjectConverterRegistry;
import org.sweet.converters.object.registry.impl.ExceptionObjectConverterRegistry;
import org.sweet.converters.object.registry.impl.PrimitiveObjectConverterRegistry;

public class ObjectConverterRegistryFactory {

	public static ObjectConverterRegistry create() {
		return new ExceptionObjectConverterRegistry(new ArrayObjectConverterRegistry(new PrimitiveObjectConverterRegistry(
				new EnumObjectConverterRegistry(new DefaultObjectConverterRegistry()))));
	}

	private ObjectConverterRegistryFactory() {
	}
}
