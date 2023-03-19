/**
 * COMP 1451 - Assignment Three
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

package comp1451.assignment3.bankdata;

import java.util.HashMap;

public class Bank {

	/**
	 * The bank collection to hold all BankCustomer data. Uses a customer's account
	 * number as key and the BankCustomer reference as the value.
	 */
	public static HashMap<String, BankCustomer> theBank;

	/**
	 * Default constructor for Bank class. Initializes the HashMap
	 */
	public Bank() {
		theBank = new HashMap<String, BankCustomer>();
	}

	/**
	 * Adds a new BankCustomer object to the HashMap. Checks that the account is not
	 * already in the HashMap.
	 * 
	 * @param newCustomer - The new element to add to the HashpMap using the account
	 *                    number as the key and the new BankCustomer as the value.
	 */
	public void createAccount(BankCustomer newCustomer) {
		if (newCustomer != null && !theBank.containsKey(newCustomer.getAccount().getAccountNumber())) {
			theBank.put(newCustomer.getAccount().getAccountNumber(), newCustomer);
		}

	}

	/**
	 * Finds a BankCustomer object in the HashMap, and then sets the referenced
	 * account object status to inactive (false).
	 * 
	 * @param accountNumber - the key (a String) of the element to be removed from
	 *                      the HashMap.
	 */
	public void deactivate(String accountNumber) {
		if (accountNumber != null && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).getAccount().setActive(false);
		}
	}

	/**
	 * Retrieves a BankCustomer object from the HashMap, then retrieves the
	 * referenced account object and adds a double to that object's balance.
	 * 
	 * @param accountNumber - the key (a string) to the BankCustomer Object in the
	 *                      HashMap.
	 * @param amount        - the double to be added to the BankCustomer's Account
	 *                      objects balance.
	 */
	public void deposit(String accountNumber, double amount) {
		if (accountNumber != null && amount >= 0.0 && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).getAccount().addToBalance(amount);
		}
	}

	/**
	 * Retrieves a BankCustomer object from the HashMap, then retrieves the
	 * referenced account object and subtracts a double from that object's balance.
	 * 
	 * @param accountNumber - the key (a string) to the BankCustomer object in the
	 *                      hashmap.
	 * @param amount        - the double to be subtracted from the BankCustomer's
	 *                      Account object balance.
	 */
	public void withdraw(String accountNumber, double amount) {
		if (accountNumber != null && amount >= 0.0 && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).getAccount().subtractFromBalance(amount);
		}

	}

	/**
	 * Displays the details of a BankCustomer element in the HashMap. Uses
	 * BankCustomer.toString() implementation.
	 * 
	 * @param customer - the BankCustomer object chosen to be displayed.
	 */
	public static void displayCustomerInformation(BankCustomer customer) {
		if (customer != null) {
			System.out.println(customer.toString());
		}
	}


	/**
	 * Displays all elements of the HashMap by using BankCustomer.toString()
	 * implementation of each.
	 */
	public static void displayAllCustomers() {
		if (theBank != null) {
			for (BankCustomer index : theBank.values()) {
				System.out.println(index.toString());
			}
		}
	}
}
