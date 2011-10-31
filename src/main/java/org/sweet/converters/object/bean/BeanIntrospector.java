package org.sweet.converters.object.bean;

import java.beans.PropertyDescriptor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanIntrospector implements Iterable<PropertyInfo> {

	private final Map<String, PropertyInfo> properties = new TreeMap<String, PropertyInfo>();

	public BeanIntrospector(Class<?> beanClass) {
		PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(beanClass);

		for (PropertyDescriptor descriptor : descriptors) {
			final PropertyInfo propertyInfo = PropertyInfo.introspect(descriptor);

			if (propertyInfo != null) {
				final String displayName = propertyInfo.getDisplayName();

				if (properties.containsKey(displayName)) {
					throw new IllegalArgumentException("Bean <" + beanClass + "> has 2 properties with the same name <" + displayName + ">");
				}

				properties.put(displayName, propertyInfo);
			}
		}
	}

	public Iterator<PropertyInfo> iterator() {
		return new TreeSet<PropertyInfo>(properties.values()).iterator();
	}

	public PropertyInfo getPropertyInfo(String name) {
		return properties.get(name);
	}

	public Set<String> getMandatoryDisplayNames() {
		Set<String> result = new TreeSet<String>();

		for (PropertyInfo pi : properties.values()) {
			if (!pi.isOptional()) {
				result.add(pi.getDisplayName());
			}
		}

		return result;
	}
}
