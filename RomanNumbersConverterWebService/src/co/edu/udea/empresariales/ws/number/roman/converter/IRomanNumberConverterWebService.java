package co.edu.udea.empresariales.ws.number.roman.converter;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

@WebService()
public interface IRomanNumberConverterWebService {

	public Response convertFromDecimalNumber(Integer decimalNumber);
}