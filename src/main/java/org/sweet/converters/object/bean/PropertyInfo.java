package org.sweet.converters.object.bean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.sweet.converters.object.annotation.Convert;
import org.sweet.converters.object.annotation.Description;

public class PropertyInfo implements Comparable<PropertyInfo> {

    public static PropertyInfo introspect(PropertyDescriptor descriptor) {
        if (descriptor.getWriteMethod() != null) {
            return new PropertyInfo(descriptor);
        }
        return null;
    }

    private final String javaName;

    private final boolean optional;

    private final String displayName;

    private final Class<?> propertyType;

    private final Convert convert;

    private final String description;

    private PropertyInfo(PropertyDescriptor descriptor) {
        javaName = descriptor.getName();
        propertyType = descriptor.getPropertyType();
        optional = javaName.startsWith("optional");

        if (optional) {
            displayName = Character.toLowerCase(javaName.charAt(8))
                    + javaName.substring(9);
        } else {
            displayName = javaName;
        }

        Method writeMethod = descriptor.getWriteMethod();

        convert = writeMethod.getAnnotation(Convert.class);

        Description description = writeMethod.getAnnotation(Description.class);

        if (description != null) {
            this.description = description.value();
        } else {
            this.description = null;
        }
    }

    public String getDescription() {
        return description;
    }

    public String getJavaName() {
        return javaName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Class<?> getPropertyType() {
        return propertyType;
    }

    public boolean isOptional() {
        return optional;
    }

    public Convert getConvert() {
        return convert;
    }

    @Override
    public int hashCode() {
        return displayName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(o instanceof PropertyInfo)) {
            return false;
        }

        PropertyInfo other = (PropertyInfo) o;

        return displayName.equals(other.displayName);
    }

    public int compareTo(PropertyInfo other) {
        int result = 0;

        if (optional) {
            if (!other.optional) {
                result = 1;
            }
        } else if (other.optional) {
            result = -1;
        }

        if (result == 0) {
            result = displayName.compareTo(other.displayName);
        }

        return result;
    }
}
