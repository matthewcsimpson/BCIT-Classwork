/**
 * Project: COMP2613 - 03 - Lab 03
 * File: Validator.java
 * Date: May 3, 2019
 * Time: 5:23:34 p.m.
 */

package a00820997.data.util;

/**
 * @author Matthew Simpson / A00820997
 * @date Spring / Summer 2019
 *
 */
public class Validator {

	/**
	 * Private constructor to prevent instantiation
	 */

	private Validator() {
	}

	/**
	 * Method to check an email address is valid. If the email is valid, return said email. If it is not valid, return "n/a"
	 * 
	 * @param checkEmail
	 *            the email address to be checked.
	 */
	public static boolean checkEmail(String checkEmail) {
		boolean good = false;
		if (!checkEmail.isEmpty() && checkEmail != null && checkEmail.matches("\\w+@+\\w+\\.\\w{2,6}")) {
			good = true;
		} else {
			good = false;
		}
		return good;
	}

	/**
	 * @deprecated Please now use checkEmail();
	 * @see checkEmail()
	 *      Method to check an email address is valid. If the email is valid, return said email. If it is not valid, return "n/a"
	 * 
	 * @param checkEmail
	 * @return the email address (or not).
	 */
	@Deprecated
	public String checkEmailAddress(String checkEmail) {

		if (!checkEmail.isEmpty() && checkEmail != null && checkEmail.matches("\\w+@+\\w+\\.\\w{2,6}")) {
			return checkEmail;
		} else {
			return "n/a";
		}

	}

}
