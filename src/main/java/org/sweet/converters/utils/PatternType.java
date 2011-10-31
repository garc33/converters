package org.sweet.converters.utils;

public enum PatternType {

	ISO_BUSINESS_DATE("yyyy-MM-dd"), ISO_TIME("HH:mm:ss");

	private final String pattern;

	PatternType(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}
}
