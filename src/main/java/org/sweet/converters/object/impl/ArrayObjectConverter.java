package org.sweet.converters.object.impl;

import java.lang.reflect.Array;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.object.ObjectConverter;
import org.sweet.converters.utils.ConverterConstants;

public class ArrayObjectConverter<T> extends SimpleObjectConverter<T[]> {

    private final ObjectConverter<T> elementConverter;

    private final char separator;

    private final Class<T> type;

    public ArrayObjectConverter(ObjectConverter<T> elementConverter,
            Class<T> type) {
        this(elementConverter, type, ConverterConstants.DEFAULT_SEPARATOR);
    }

    public ArrayObjectConverter(ObjectConverter<T> elementConverter,
            Class<T> type, final char separator) {
        this.elementConverter = elementConverter;
        this.type = type;
        this.separator = separator;
    }

    public String getUsage() {
        return "comma separated list of " + elementConverter.getUsage();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected T[] doConvert(String s) throws ConverterException {
        String[] strings = StringUtils.split(s, separator);
        final int length = strings.length;
        final Object result = Array.newInstance(
                ClassUtils.primitiveToWrapper(type), length);

        for (int i = 0; i < length; ++i) {
            final T element = elementConverter.convert(strings[i]);

            Array.set(result, i, element);
        }

        return (T[]) result;
    }
}
