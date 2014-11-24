package co.edu.udea.empresariales.tdd.number.roman.exception;

public class RomanNumberException extends RuntimeException {

	private static final long serialVersionUID = 2555018597092048681L;

	public RomanNumberException() {
		super();
	}

	public RomanNumberException(String message) {
		super(message);
	}

	public RomanNumberException(Throwable cause) {
		super(cause);
	}

	public RomanNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public RomanNumberException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}