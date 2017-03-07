package fr.univbrest.dosi.spi.exception;

/**
 * @author DOSI
 *
 */
public class SPIException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private SpiExceptionCode codeException;

	public SPIException() {
		super();
	}

	public SPIException(final String message) {
		super(message);

	}

	public SPIException(final String message, final Throwable cause) {
		super(message, cause);

	}

	public SPIException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public SPIException(final SpiExceptionCode code, final String message, final Throwable cause) {
		super(message, cause);
		this.codeException = code;
	}

	public SPIException(final SpiExceptionCode code, final String message) {
		super(message);
		this.codeException = code;
	}

	public SPIException(final SpiExceptionCode code, final Throwable cause) {
		super(cause);
		this.codeException = code;
	}

	public SPIException(final Throwable cause) {
		super(cause);

	}

	public SpiExceptionCode getCodeException() {
		return this.codeException;
	}

	public void setCodeException(final SpiExceptionCode codeException) {
		this.codeException = codeException;
	}

}
