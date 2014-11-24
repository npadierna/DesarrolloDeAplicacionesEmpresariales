package co.edu.udea.empresariales.tdd.number.roman.converter;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.empresariales.tdd.number.roman.exception.RomanNumberException;

public class RomanNumberConverterTester {

	private RomanNumberConverter romanNumberConverter = new RomanNumberConverter();

	@Test(expected = RomanNumberException.class)
	public void testCheckingLowerLimit() {
		Integer decimalInteger = Integer
				.valueOf(RomanNumberConverter.MINIMUM_CONVERTIBLE_VALUE
						.intValue() - 1);

		assertNotNull(this.romanNumberConverter
				.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test(expected = RomanNumberException.class)
	public void testCheckingUpperLimit() {
		Integer decimalInteger = Integer
				.valueOf(RomanNumberConverter.MAXIMUM_CONVERTIBLE_VALUE
						.intValue() + 1);

		assertNotNull(this.romanNumberConverter
				.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_1() {
		Integer decimalInteger = Integer.valueOf(1);

		assertEquals("I",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_2() {
		Integer decimalInteger = Integer.valueOf(2);

		assertEquals("II",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_4() {
		Integer decimalInteger = Integer.valueOf(4);

		assertEquals("IV",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_15() {
		Integer decimalInteger = Integer.valueOf(15);

		assertEquals("XV",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_23() {
		Integer decimalInteger = Integer.valueOf(23);

		assertEquals("XXIII",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_193() {
		Integer decimalInteger = Integer.valueOf(193);

		assertEquals("CXCIII",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_653() {
		Integer decimalInteger = Integer.valueOf(653);

		assertEquals("DCLIII",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_1000() {
		Integer decimalInteger = Integer.valueOf(1000);

		assertEquals("M",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_1991() {
		Integer decimalInteger = Integer.valueOf(1991);

		assertEquals("MCMXCI",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_2816() {
		Integer decimalInteger = Integer.valueOf(2816);

		assertEquals("MMDCCCXVI",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_3998() {
		Integer decimalInteger = Integer.valueOf(3998);

		assertEquals("MMMCMXCVIII",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}

	@Test()
	public void testConvertingNumber_3999() {
		Integer decimalInteger = Integer.valueOf(3999);

		assertEquals("MMMCMXCIX",
				this.romanNumberConverter
						.convertDecimalNumberToRomanNumber(decimalInteger));
	}
}