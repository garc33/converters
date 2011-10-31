package org.sweet.converters.object;

import org.apache.commons.lang.StringUtils;
import org.sweet.converters.exception.ConverterException;
import org.sweet.converters.object.impl.ArrayObjectConverter;
import org.sweet.converters.object.impl.BooleanObjectConverter;
import org.sweet.converters.object.impl.DoubleObjectConverter;
import org.sweet.converters.object.impl.EnumObjectConverter;
import org.sweet.converters.object.impl.FloatObjectConverter;
import org.sweet.converters.object.impl.IntegerObjectConverter;
import org.sweet.converters.object.impl.LongObjectConverter;
import org.sweet.converters.object.impl.StringObjectConverter;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test
public class ObjectConverterTest {

	public void testStringObjectConverter() {
		StringObjectConverter converter = new StringObjectConverter();

		Assert.assertEquals(converter.convert(null), null);
		Assert.assertEquals(converter.convert(StringUtils.EMPTY),
				StringUtils.EMPTY);
		Assert.assertEquals(converter.convert("youpi"), "youpi");
	}

	public void testBooleanObjectConverter() {
		BooleanObjectConverter converter = new BooleanObjectConverter();

		Assert.assertEquals(converter.convert(null), null);
		Assert.assertEquals(converter.convert(StringUtils.EMPTY), null);
		Assert.assertEquals(converter.convert("true"), Boolean.TRUE);
		Assert.assertEquals(converter.convert("y"), Boolean.TRUE);
		Assert.assertEquals(converter.convert("false"), Boolean.FALSE);
		Assert.assertEquals(converter.convert("n"), Boolean.FALSE);
	}

	@Test(expectedExceptions = ConverterException.class)
	public void testBooleanObjectConverterFailure() {
		BooleanObjectConverter converter = new BooleanObjectConverter();

		converter.convert("youpi");
	}

	public void testEnumObjectConverter() {
		EnumObjectConverter<SimpleEnum> converter = new EnumObjectConverter<SimpleEnum>(
				SimpleEnum.class);

		Assert.assertEquals(converter.convert(null), null);
		Assert.assertEquals(converter.convert(StringUtils.EMPTY), null);
		Assert.assertEquals(converter.convert("TWO"), SimpleEnum.TWO);
		Assert.assertEquals(converter.convert("two"), SimpleEnum.TWO);
	}

	@Test(expectedExceptions = ConverterException.class)
	public void testEnumObjectConverterFailure() {
		EnumObjectConverter<SimpleEnum> converter = new EnumObjectConverter<SimpleEnum>(
				SimpleEnum.class);

		converter.convert("youpi");
	}

	public void testArrayObjectConverter() {
		ArrayObjectConverter<SimpleEnum> converter = new ArrayObjectConverter<SimpleEnum>(
				new EnumObjectConverter<SimpleEnum>(SimpleEnum.class),
				SimpleEnum.class);

		Assert.assertEquals(converter.convert(null), null);
		Assert.assertEquals(converter.convert(StringUtils.EMPTY), null);
		Assert.assertEquals(converter.convert("one,TWO"), new Object[] {
				SimpleEnum.ONE, SimpleEnum.TWO });
	}

	public void testIntegerObjectConverter() {
		IntegerObjectConverter converter = new IntegerObjectConverter(null);

		Assert.assertEquals(converter.convert(null), null);
		Assert.assertEquals(converter.convert(StringUtils.EMPTY), null);
		Assert.assertEquals(converter.convert("1"), Integer.valueOf(1));
	}

	public void testLongObjectConverter() {
		LongObjectConverter converter = new LongObjectConverter(null);

		Assert.assertEquals(converter.convert(null), null);
		Assert.assertEquals(converter.convert(StringUtils.EMPTY), null);
		Assert.assertEquals(converter.convert("1"), Long.valueOf(1));
	}

	public void testFloatObjectConverter() {
		FloatObjectConverter converter = new FloatObjectConverter(null);

		Assert.assertEquals(converter.convert(null), null);
		Assert.assertEquals(converter.convert(StringUtils.EMPTY), null);
		Assert.assertEquals(converter.convert("1"), Float.valueOf(1));
	}

	public void testDoubleObjectConverter() {
		DoubleObjectConverter converter = new DoubleObjectConverter(null);

		Assert.assertEquals(converter.convert(null), null);
		Assert.assertEquals(converter.convert(StringUtils.EMPTY), null);
		Assert.assertEquals(converter.convert("1"), Double.valueOf(1));
	}
}
