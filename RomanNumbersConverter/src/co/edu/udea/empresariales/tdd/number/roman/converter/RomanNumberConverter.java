package co.edu.udea.empresariales.tdd.number.roman.converter;

import java.util.HashMap;
import java.util.Map;

import co.edu.udea.empresariales.tdd.number.roman.exception.RomanNumberException;

public class RomanNumberConverter {

	private static final String C = "C";
	private static final String D = "D";
	private static final String I = "I";
	private static final String L = "L";
	private static final String M = "M";
	private static final String V = "V";
	private static final String X = "X";

	public static final Integer MAXIMUM_CONVERTIBLE_VALUE = Integer
			.valueOf(3999);
	public static final Integer MINIMUM_CONVERTIBLE_VALUE = Integer.valueOf(1);
	public static final Map<Integer, String> ROMAN_NUMBERS_MAP = new HashMap<Integer, String>();

	static {
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(1), I);
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(2), I.concat(I));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(3), I.concat(I).concat(I));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(4), I.concat(V));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(5), V);
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(6), V.concat(I));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(7), V.concat(I).concat(I));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(8),
				V.concat(I).concat(I).concat(I));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(9), I.concat(X));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(10), X);
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(20), X.concat(X));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(30), X.concat(X).concat(X));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(40), X.concat(L));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(50), L);
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(60), L.concat(X));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(70), L.concat(X).concat(X));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(80), L.concat(X).concat(X)
				.concat(X));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(90), X.concat(C));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(100), C);
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(200), C.concat(C));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(300), C.concat(C).concat(C));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(400), C.concat(D));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(500), D);
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(600), D.concat(C));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(700), D.concat(C).concat(C));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(800), D.concat(C).concat(C)
				.concat(C));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(900), C.concat(M));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(1000), M);
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(2000), M.concat(M));
		ROMAN_NUMBERS_MAP.put(Integer.valueOf(3000), M.concat(M).concat(M));
	}

	public RomanNumberConverter() {
		super();
	}

	public String convertDecimalNumberToRomanNumber(Integer decimalNumber) {
		StringBuilder romanNumberString = new StringBuilder();

		if (this.validateDecimalNumber(decimalNumber)) {
			int decimalNumberValue = decimalNumber.intValue();
			int divisor = 10;
			int moduleValue;

			while (decimalNumberValue > 0) {
				moduleValue = decimalNumberValue % 10;
				decimalNumberValue = (int) (decimalNumber.intValue() / divisor);

				if (moduleValue != 0) {
					romanNumberString.insert(
							0,
							ROMAN_NUMBERS_MAP.get(Integer.valueOf(moduleValue
									* (divisor / 10))));
				}

				divisor *= 10;
			}
		}

		return (romanNumberString.toString());
	}

	private boolean validateDecimalNumber(Integer decimalNumber) {
		if (decimalNumber == null) {
			throw new RomanNumberException(String.format("%s",
					"The Decimal Number can not be null."));
		}

		if (decimalNumber.compareTo(MAXIMUM_CONVERTIBLE_VALUE) > 0) {
			throw new RomanNumberException(
					String.format(
							"%s: %d",
							"The Decimal Number is too big for converting. The maximum acceptable value is",
							MAXIMUM_CONVERTIBLE_VALUE.intValue()));
		}

		if (decimalNumber.compareTo(MINIMUM_CONVERTIBLE_VALUE) < 0) {
			throw new RomanNumberException(
					String.format(
							"%s: %d",
							"The Decimal Number is too short for converting. The minimum acceptable value is",
							MINIMUM_CONVERTIBLE_VALUE.intValue()));
		}

		return (true);
	}
}