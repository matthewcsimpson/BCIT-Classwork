/**
 * Project: COMP2613 - 03 - Lab 03
 * File: CustomerReader.java
 * Date: May 3, 2019
 * Time: 5:27:50 p.m.
 */

package a00820997.io;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import a00820997.data.Customer;
import a00820997.data.util.Validator;
import a00820997.exceptions.ApplicationException;

/**
 * @author Matthew Simpson / A00820997
 * @date Spring / Summer 2019
 *
 */
public class CustomerReader {

	public static String CUSTOMER_DELIMITER = ":";
	public static String DATA_DELIMITER = "\\|";

	/**
	 * Private constructor to prevent instantiation
	 */

	private CustomerReader() {
	}

	/**
	 * Method to check a string and separate out customer data using the defined delimiters.
	 * 
	 * @param checkData
	 *            - a string
	 * @return customers - an array of Customer objects.
	 */
	public static Customer[] checkInput(String checkData) throws ApplicationException {
		Customer[] customers = null;

		if (!checkData.isEmpty() || !checkData.equals("")) {
			String[] tempCustomer = checkData.split(CUSTOMER_DELIMITER);

			int indexNumber = tempCustomer.length;
			customers = new Customer[indexNumber];

			for (int i = 0; i < tempCustomer.length; i++) {
				String[] tempData = tempCustomer[i].split(DATA_DELIMITER);

				if (tempData.length == 9) {
					for (int j = 0; j < tempData.length; j++) {
						String checkEmail = null;
						if (Validator.checkEmail(tempData[7]) == true) {
							checkEmail = tempData[7];
						} else {
							throw new ApplicationException(tempData[7] + " is not a valid email address");
						}

						customers[i] = new Customer.Builder(Integer.parseInt(tempData[0]), tempData[6]).firstName(tempData[1]).lastName(tempData[2])
								.streetName(tempData[3]).city(tempData[4]).postalCode(tempData[5]).emailAddress(checkEmail)
								.joinDate(LocalDate.parse(tempData[8], DateTimeFormatter.BASIC_ISO_DATE)).build();
					}

				} else {
					String details = "[";
					for (int k = 0; k < tempData.length; k++) {
						details = details + tempData[k] + ", ";
					}
					details = details + "]";

					throw new ApplicationException("Expected 9 elements but received " + tempData.length + ":" + details);
				}
			}

		}
		return customers;

	}

}
