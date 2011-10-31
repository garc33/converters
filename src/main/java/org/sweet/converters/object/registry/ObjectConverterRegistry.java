package org.sweet.converters.object.registry;

import org.sweet.converters.object.ObjectConverter;

public interface ObjectConverterRegistry {

	<T> void register(Class<T> type, ObjectConverter<T> converter);

	<T> ObjectConverter<T> getConverter(Class<T> type);
}
