package org.sweet.converters.object.impl;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.sweet.converters.utils.PatternType;

public class DateObjectConverter extends PatternObjectConverter<Date> {

    public DateObjectConverter(PatternType type) {
        super(type);
    }

    public DateObjectConverter(String pattern) {
        super(pattern);
    }

    public String getUsage() {
        String pattern = getPattern();

        if (StringUtils.isNotBlank(pattern)) {
            return "<date " + pattern + ">";
        }
        return "<date>";
    }

    @Override
    protected Format createFormat() {
        return new SimpleDateFormat(getPattern());
    }
}
