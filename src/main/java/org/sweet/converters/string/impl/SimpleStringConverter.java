package org.sweet.converters.string.impl;

import org.apache.commons.lang3.StringUtils;
import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.string.StringConverter;

public class SimpleStringConverter implements StringConverter {

    public String convert(Object o) throws ConverterException {
        if (o == null) {
            return StringUtils.EMPTY;
        }

        return doConvert(o);
    }

    @Override
    public String toString() {
        return "toStringConverter";
    }

    protected String doConvert(Object o) throws ConverterException {
        return o.toString();
    }
}
