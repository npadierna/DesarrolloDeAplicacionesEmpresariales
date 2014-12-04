package co.edu.udea.empresariales.ws.number.roman.contract;

public class RomanNumberWebServiceContract {

	private RomanNumberWebServiceContract() {
		super();
	}

	public static final class ConverterWebServiceContract {

		/*
		 * End Point Interface.
		 */
		public static final String END_POINT_INTERFACE = "co.edu.udea.empresariales.ws.number.roman.converter.IRomanNumberConverterWebService";

		/*
		 * URL Paths.
		 */
		public static final String ROOT_URL_PATH = "/number/roman";
		public static final String CONVERT_FROM_DECIMAL_NUMBER_URL_PATH = "/converter/decimalnumber";

		/*
		 * Queries Parameters.
		 */
		public static final String DECIMAL_NUMBER_QUERY_PARAMETER = "decimalNumber";

		private ConverterWebServiceContract() {
			super();
		}
	}
}