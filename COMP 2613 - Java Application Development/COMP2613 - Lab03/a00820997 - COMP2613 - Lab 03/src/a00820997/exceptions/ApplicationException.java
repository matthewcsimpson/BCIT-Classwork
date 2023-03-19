/**
 * Project: COMP2613 - 03 - Lab 03
 * File: ApplicationException.java
 * Date: May 3, 2019
 * Time: 8:41:51 p.m.
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

	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
