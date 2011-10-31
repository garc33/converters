package org.sweet.converters.object.bean;

import org.sweet.converters.object.annotation.Description;
import org.sweet.converters.object.bean.BeanIntrospector;
import org.sweet.converters.object.bean.PropertyInfo;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test
public class BeanIntrospectorTest {

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testInvalid() {
		new BeanIntrospector(InvalidBean.class);
	}

	public void testSimple() {
		BeanIntrospector introspector = new BeanIntrospector(SimpleBean.class);
		Object[][] expectedResult = new Object[][] {
				{ "mandatoryOption", "mandatoryOption", Boolean.FALSE, null,
						String.class },
				{ "option", "optionalOption", Boolean.TRUE, "description",
						Boolean.class } };
		int i = 0;

		for (PropertyInfo pi : introspector) {
			Assert.assertEquals(pi.getDisplayName(), expectedResult[i][0]);
			Assert.assertEquals(pi.getJavaName(), expectedResult[i][1]);
			Assert.assertEquals(pi.isOptional(), expectedResult[i][2]);
			Assert.assertEquals(pi.getDescription(), expectedResult[i][3]);
			Assert.assertEquals(pi.getPropertyType(), expectedResult[i][4]);

			++i;
		}

		Assert.assertNotNull(introspector.getPropertyInfo("mandatoryOption"));
		Assert.assertNotNull(introspector.getPropertyInfo("option"));
		Assert.assertNull(introspector.getPropertyInfo("youpi"));
	}

	public class InvalidBean {

		private String option;

		private String optionalOption;

		public String getOption() {
			return option;
		}

		public void setOption(String option) {
			this.option = option;
		}

		public String getOptionalOption() {
			return optionalOption;
		}

		public void setOptionalOption(String optionalOption) {
			this.optionalOption = optionalOption;
		}
	}

	public class SimpleBean {

		private String mandatoryOption;

		private Boolean optionalOption;

		private String hiddenOption;

		public String getMandatoryOption() {
			return mandatoryOption;
		}

		public void setMandatoryOption(String mandatoryOption) {
			this.mandatoryOption = mandatoryOption;
		}

		public Boolean getOptionalOption() {
			return optionalOption;
		}

		@Description("description")
		public void setOptionalOption(Boolean optionalOption) {
			this.optionalOption = optionalOption;
		}

		public String getHiddenOption() {
			return hiddenOption;
		}
	}
}
