package org.sweet.converters.string;

import java.text.ParseException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.string.StringConverter;
import org.sweet.converters.string.impl.ArrayStringConverter;
import org.sweet.converters.string.impl.DateStringConverter;
import org.sweet.converters.string.impl.NumberStringConverter;
import org.sweet.converters.string.impl.SimpleStringConverter;
import org.sweet.converters.utils.PatternType;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test
public class StringConverterTest {

	public void testSimpleStringConverter() {
		StringConverter converter = new SimpleStringConverter();

		Assert.assertEquals(converter.convert(null), StringUtils.EMPTY);
		Assert.assertEquals(converter.convert(StringUtils.EMPTY),
				StringUtils.EMPTY);
		Assert.assertEquals(converter.convert("youpi"), "youpi");
		Assert.assertEquals(converter.convert(1), "1");
		Assert.assertEquals(converter.convert(1.0), "1.0");
		Assert.assertEquals(converter.convert(Boolean.TRUE), "true");
	}

	public void testDateStringConverter() throws ConverterException,
			ParseException {
		StringConverter converter = new DateStringConverter(
				PatternType.ISO_BUSINESS_DATE);

		Assert.assertEquals(converter.convert(null), StringUtils.EMPTY);
		Assert.assertEquals(converter.convert(DateUtils.parseDate("01/03/2010",
				new String[] { "dd/MM/yyyy" })), "2010-03-01");
	}

	public void testNumberStringConverter() throws ConverterException,
			ParseException {
		StringConverter converter = new NumberStringConverter("00.##", '.');

		Assert.assertEquals(converter.convert(null), StringUtils.EMPTY);
		Assert.assertEquals(converter.convert(1), "01");
		Assert.assertEquals(converter.convert(1.1), "01.1");
	}

	public void testArrayStringConverter() {
		StringConverter converter = new ArrayStringConverter(
				new SimpleStringConverter());

		Assert.assertEquals(converter.convert(null), StringUtils.EMPTY);
		Assert.assertEquals(converter.convert(new Object[0]), StringUtils.EMPTY);
		Assert.assertEquals(converter.convert(new Object[] { "youpi" }),
				"youpi");
		Assert.assertEquals(converter.convert(new Object[] { "one", "two" }),
				"one,two");
		Assert.assertEquals(converter.convert(new Object[] { 1, 2 }), "1,2");
		Assert.assertEquals(converter.convert(new Object[] { 1.0, 2.0 }),
				"1.0,2.0");
		Assert.assertEquals(converter.convert(new Object[] { true, false }),
				"true,false");
	}
}
