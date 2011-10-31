package org.sweet.converters.object.impl;

import java.io.File;

import org.sweet.converters.exception.ConverterException;


public class FileObjectConverter extends SimpleObjectConverter<File> {

	public String getUsage() {
		return "<file>";
	}

	@Override
	protected File doConvert(String s) throws ConverterException {
		return new File(s);
	}
}
