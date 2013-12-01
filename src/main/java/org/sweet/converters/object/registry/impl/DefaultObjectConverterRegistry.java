package org.sweet.converters.object.registry.impl;

import java.io.File;

import org.sweet.converters.object.impl.BooleanObjectConverter;
import org.sweet.converters.object.impl.CharacterObjectConverter;
import org.sweet.converters.object.impl.DoubleObjectConverter;
import org.sweet.converters.object.impl.FileObjectConverter;
import org.sweet.converters.object.impl.FloatObjectConverter;
import org.sweet.converters.object.impl.IntegerObjectConverter;
import org.sweet.converters.object.impl.LongObjectConverter;
import org.sweet.converters.object.impl.StringObjectConverter;

public class DefaultObjectConverterRegistry extends
        SimpleObjectConverterRegistry {

    public DefaultObjectConverterRegistry() {
        register(String.class, new StringObjectConverter());
        register(Character.class, new CharacterObjectConverter());
        register(Boolean.class, new BooleanObjectConverter());
        register(Integer.class, new IntegerObjectConverter(null));
        register(Long.class, new LongObjectConverter(null));
        register(Float.class, new FloatObjectConverter(null));
        register(Double.class, new DoubleObjectConverter(null));
        register(File.class, new FileObjectConverter());
    }
}
