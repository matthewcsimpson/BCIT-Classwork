/**
 * Project: COMP2613 - 04 - Lab 04
 * File: Validator.java
 * Date: May 13, 2019
 * Time: 5:59:51 p.m.
 * 
 * @author Matthew Simpson / A00820997
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
