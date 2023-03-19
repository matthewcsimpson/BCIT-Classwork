/**
 * Project: COMP2613 - 04 - Lab 4
 * File: CompareByJoinDate.java
 * Date: May 13, 2019
 * Time: 5:59:51 p.m.
 * 
 * @author Matthew Simpson / A00820997
 */

package a00820997.data.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import a00820997.data.Customer;

/**
 * @author Matthew Simpson / A00820997
 * @date Spring / Summer 2019
 *
 */
public class CompareByJoinDate implements Comparator<Customer> {

	/**
	 * Method to compare two LocalDate objects.
	 */
	@Override
	public int compare(Customer numberOne, Customer numberTwo) {
		LocalDate c1 = numberOne.getJoinDate();
		LocalDate c2 = numberTwo.getJoinDate();
		return c1.compareTo(c2);

	}

	public static ArrayList<Customer> sortData(Map<Long, Customer> customerData) {
		ArrayList<Customer> sortedData = new ArrayList<Customer>();

		for (Map.Entry<Long, Customer> index : customerData.entrySet()) {
			if (index != null) {
				sortedData.add(index.getValue());
			}

		}
		sortedData.sort(new CompareByJoinDate());

		return sortedData;

	}

}
