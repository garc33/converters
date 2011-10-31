package org.sweet.converters.object.registry;

import java.lang.reflect.Array;

import org.sweet.converters.object.ObjectConverter;
import org.sweet.converters.object.SimpleEnum;
import org.sweet.converters.object.impl.ArrayObjectConverter;
import org.sweet.converters.object.impl.BooleanObjectConverter;
import org.sweet.converters.object.impl.DoubleObjectConverter;
import org.sweet.converters.object.impl.EnumObjectConverter;
import org.sweet.converters.object.impl.FloatObjectConverter;
import org.sweet.converters.object.impl.IntegerObjectConverter;
import org.sweet.converters.object.impl.LongObjectConverter;
import org.sweet.converters.object.impl.StringObjectConverter;
import org.sweet.converters.object.registry.ObjectConverterRegistry;
import org.sweet.converters.object.registry.ObjectConverterRegistryFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
public class ObjectConverterRegistryTest {

	private ObjectConverterRegistry registry;

	@BeforeSuite
	public void init() {
		registry = ObjectConverterRegistryFactory.create();
	}

	@DataProvider(name = "data")
	public Object[][] createData() {
		return new Object[][] { { "youpi", StringObjectConverter.class },
				{ SimpleEnum.ONE, EnumObjectConverter.class },
				{ Boolean.TRUE, BooleanObjectConverter.class },
				{ 1, IntegerObjectConverter.class },
				{ Long.valueOf(1), LongObjectConverter.class },
				{ Float.valueOf(1), FloatObjectConverter.class },
				{ Double.valueOf(1), DoubleObjectConverter.class }, };
	}

	@Test(dataProvider = "data")
	public void test(Object value, Class<?> expectedClass) {
		check(value, expectedClass);

		Object array = Array.newInstance(value.getClass(), 1);

		Array.set(array, 0, value);

		check(array, ArrayObjectConverter.class);
	}

	public void testPrimitive() {
		check(Integer.TYPE, IntegerObjectConverter.class);
		check(Long.TYPE, LongObjectConverter.class);
		check(Float.TYPE, FloatObjectConverter.class);
		check(Double.TYPE, DoubleObjectConverter.class);
		check(Boolean.TYPE, BooleanObjectConverter.class);
	}

	public void testPrimitiveArray() {
		check(new int[0].getClass(), ArrayObjectConverter.class);
		check(new long[0].getClass(), ArrayObjectConverter.class);
		check(new float[0].getClass(), ArrayObjectConverter.class);
		check(new double[0].getClass(), ArrayObjectConverter.class);
		check(new boolean[0].getClass(), ArrayObjectConverter.class);
	}

	private void check(Object o, Class<?> expectedClass) {
		check(o.getClass(), expectedClass);
	}

	private void check(Class<?> type, Class<?> expectedClass) {
		ObjectConverter<?> converter = registry.getConverter(type);

		Assert.assertNotNull(converter);

		if (expectedClass != null) {
			Assert.assertEquals(converter.getClass(), expectedClass);
		}
	}
}
