package org.sweet.converters.string.impl;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;

public class NumberStringConverter extends PatternStringConverter {

	private final Character decimalCharacter;

	public NumberStringConverter(String pattern) {
		super(pattern);

		this.decimalCharacter = null;
	}

	public NumberStringConverter(String pattern, final char decimalSeparator) {
		super(pattern);

		this.decimalCharacter = Character.valueOf(decimalSeparator);
	}

	@Override
	protected Format createFormat() {
		DecimalFormat result = new DecimalFormat(getPattern());

		if (decimalCharacter != null) {
			DecimalFormatSymbols symbols = result.getDecimalFormatSymbols();

			symbols.setDecimalSeparator(decimalCharacter);

			result.setDecimalFormatSymbols(symbols);
		}

		return result;
	}
}
