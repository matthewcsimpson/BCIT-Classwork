/**
 * Project: COMP2613 - 05 - Lab 05
 * File: ApplicationException.java
 * Date: May 21, 2019
 * Time: 11:41:51 p.m.
 */

package a00820997.exceptions;

/**
 * @author Matthew Simpson / A00820997
 * @date Spring / Summer 2019
 *
 */

@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	public ApplicationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(final String message, final Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(final Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
