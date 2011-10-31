package org.sweet.converters.object.impl;

import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.object.ObjectConverter;

public class CharacterObjectConverter implements ObjectConverter<Character> {

	public Character convert(String s) throws ConverterException {
		if (s == null) {
			return null;
		}

		if (s.length() != 1) {
			throw new ConverterException("Invalid character <" + s + ">");
		}

		return Character.valueOf(s.charAt(0));
	}

	public String getUsage() {
		return "<character>";
	}
}
