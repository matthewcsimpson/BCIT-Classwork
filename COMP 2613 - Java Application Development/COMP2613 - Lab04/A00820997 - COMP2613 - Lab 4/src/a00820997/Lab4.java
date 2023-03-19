/**
 * Project: COMP2613 - 04 - Lab 04
 * File: Lab3.java
 * Date: May 3, 2019
 * Time: 5:19:37 p.m.
 * 
 * @author Matthew Simpson / A00820997
 */

package a00820997;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Map;

import a00820997.data.Customer;
import a00820997.exceptions.ApplicationException;
import a00820997.io.CustomerReader;
import a00820997.io.CustomerReport;

/**
 * @author Matthew Simpson / A00820997
 * @date Spring / Summer 2019
 *
 */
public class Lab4 {

	String customerData;
	Customer[] customerDB;
	Map<Long, Customer> newCustomerDB;
	static Instant startTime, endTime;

	/**
	 * The main method.
	 * 
	 * @param args
	 * @throws ApplicationException
	 */
	public static void main(String[] args) throws ApplicationException {

		startTime = Instant.now();

		if (args.length == 0 || args == null) { // FORGOT TO MAKE SURE THERE ARE ARGUMENTS
			System.out.println("There is no data to process!");
			System.exit(-1);
		} else {
			System.out.println(startTime);
			System.out.println();
			new Lab4(args[0]).run();
			endTime = Instant.now();
			System.out.println(endTime);
			long nanonseconds = Duration.between(startTime, endTime).toMillis();
			System.out.println(nanonseconds + " milliseconds");
		}

	}

	/**
	 * The lab 3 constructor. assigns incoming data / programming to be processed.
	 * 
	 * @param incomingData
	 *            - a string
	 *            - the program arguments
	 */
	public Lab4(String incomingData) {
		customerData = incomingData;
	}

	/**
	 * run the CusteomrReader to break the data down into Customer objects and then run CustomerReport to print out the formatted report.
	 * 
	 * @throws ApplicationException
	 */

	private void run() throws ApplicationException {

		// populate the customer array with the customer data input string.
		try {
			newCustomerDB = CustomerReader.readData(customerData);
		} catch (ApplicationException | DateTimeParseException e) {
			System.out.println(e.getMessage());
		}

		// print out the report.
		CustomerReport.reportCustomerDB(newCustomerDB);
		System.out.println();

	}

}
