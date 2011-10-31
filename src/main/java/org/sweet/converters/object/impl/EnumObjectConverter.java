package org.sweet.converters.object.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.sweet.converters.exception.ConverterException;


public class EnumObjectConverter<E extends Enum<E>> extends
		SimpleObjectConverter<E> {

	private final Class<E> enumType;

	public EnumObjectConverter(Class<E> enumType) {
		this.enumType = enumType;
	}

	public String getUsage() {
		StrBuilder sb = new StrBuilder();

		sb.append('<');

		for (E enumConstant : enumType.getEnumConstants()) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append(enumConstant.name());
		}

		sb.append('>');

		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("EnumObjectConverter<");
		sb.append(enumType.getName());
		sb.append('>');

		return sb.toString();
	}

	@Override
	protected E doConvert(String s) throws ConverterException {
		E[] enumConstants = enumType.getEnumConstants();

		for (E enumConstant : enumConstants) {
			if (enumConstant.name().equalsIgnoreCase(s)) {
				return enumConstant;
			}
		}

		throw new ConverterException("Invalid value <" + s
				+ ">, must be one of <" + StringUtils.join(enumConstants, ", ")
				+ ">");
	}
}
