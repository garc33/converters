package org.sweet.converters.object.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.sweet.converters.exception.ConverterException;
import org.sweet.date.BusinessDate;

public class BusinessDateObjectConverter extends SimpleObjectConverter<BusinessDate> {

	private final DateFormat formatter = new SimpleDateFormat(BusinessDate.ISO);

	public String getUsage() {
		return "<date " + BusinessDate.ISO + ">";
	}

	@Override
	protected BusinessDate doConvert(String s) throws ConverterException {
		try {
			return new BusinessDate(formatter.parse(s));
		} catch (ParseException e) {
			throw new ConverterException("Failed to convert <" + s + "> with pattern <" + BusinessDate.ISO + ">", e);
		}
	}
}
