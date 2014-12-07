package co.edu.udea.empresariales.ws.number.roman.converter;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.udea.empresariales.tdd.number.roman.converter.RomanNumberConverter;
import co.edu.udea.empresariales.tdd.number.roman.exception.RomanNumberException;
import co.edu.udea.empresariales.ws.number.roman.contract.RomanNumberWebServiceContract;
import co.edu.udea.empresariales.ws.number.roman.model.RomanNumber;

@Path(value = RomanNumberWebServiceContract.ConverterWebServiceContract.ROOT_URL_PATH)
@WebService(endpointInterface = RomanNumberWebServiceContract.ConverterWebServiceContract.END_POINT_INTERFACE)
public class RomanNumberConverterWebService implements
		IRomanNumberConverterWebService {

	private RomanNumberConverter romanNumberConverter;

	public RomanNumberConverterWebService() {
		this.romanNumberConverter = new RomanNumberConverter();
	}

	@GET()
	@Override()
	@Path(value = RomanNumberWebServiceContract.ConverterWebServiceContract.CONVERT_FROM_DECIMAL_NUMBER_URL_PATH)
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response convertFromDecimalNumber(
			@QueryParam(value = RomanNumberWebServiceContract.ConverterWebServiceContract.DECIMAL_NUMBER_QUERY_PARAMETER) Integer decimalNumber) {
		if (!this.validateDecimalNumber(decimalNumber)) {

			return (Response.status(Response.Status.BAD_REQUEST).build());
		}

		RomanNumber romanNumber = new RomanNumber();
		romanNumber.setDecimalNumber(decimalNumber);

		try {
			romanNumber.setRomanNumber(this.romanNumberConverter
					.convertDecimalNumberToRomanNumber(decimalNumber));
		} catch (RomanNumberException ex) {

			return (Response.status(Response.Status.NOT_MODIFIED).build());
		}

		return (Response.ok(romanNumber).build());
	}

	private boolean validateDecimalNumber(Integer decimalNumber) {

		return ((decimalNumber != null)
				&& (decimalNumber >= RomanNumberConverter.MINIMUM_CONVERTIBLE_VALUE) && (decimalNumber <= RomanNumberConverter.MAXIMUM_CONVERTIBLE_VALUE));
	}
}