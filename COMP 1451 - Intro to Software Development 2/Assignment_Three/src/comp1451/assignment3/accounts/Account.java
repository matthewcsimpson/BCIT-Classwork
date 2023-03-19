/**
 * COMP 1451 - Assignment Three
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

package comp1451.assignment3.accounts;

import java.util.ArrayList;

import java.time.format.DateTimeFormatter;

public abstract class Account {

	protected double balance;
	protected String accountNumber;
	private boolean active;
	protected ArrayList<String> transactionInfo;
	protected DateTimeFormatter formatter;
	
	private static int nextAccountNumber = 1000;

	/**
	 * Default Constructor
	 */
	public Account() {
		super();
	}

	/**
	 * Main constructor for the SuperType Account objects. Uses set methods to
	 * validate balance, accountNumber, and account status. Also initializes the
	 * transactionInfo ArrayList which holds transaction history, and the date and
	 * time formatter.
	 * 
	 * @param balance       - a double - the balance of the account.
	 * @param accountNumber - a string - the account number
	 * @param active        - a boolean - whether the account is active (true) or
	 *                      not (false)
	 */
	public Account(double balance, boolean active) {
		setBalance(balance);
		setActive(active);
		nextAccountNumber++;
		setAccountNumber();

		transactionInfo = new ArrayList<String>();
		formatter = DateTimeFormatter.ofPattern("EE LLLL dd, yyyy HH:mm:ss");

	}

	// getters ----------------------------------------------

	/**
	 * Access method for the balance.
	 * 
	 * @return the balance as a double
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Access method for the accountNumber
	 * 
	 * @return the accountNumber as a String.
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Access method for the account status as active (true) or not (false)
	 * 
	 * @return active as a boolean.
	 */
	public boolean isActive() {
		return active;
	}

	// setters ----------------------------------------------

	/**
	 * Mutator method for the balance. Checks the number is not negative and then
	 * assigns.
	 * 
	 * @param balance the balance to set, a double.
	 */
	public void setBalance(double balance) {
		if (balance >= 0) {
			this.balance = balance;
		}
	}

	/**
	 * Mutator method for the accountNumber. Checks the parameter is not null and
	 * then assigns.
	 * 
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber() {
		
		Integer nAc = new Integer(nextAccountNumber);
		this.accountNumber = nAc.toString();
		
	}

	/**
	 * Mutator method for the account status.
	 * 
	 * @param active the boolean to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	// methods ----------------------------------------------

	/**
	 * Adds to the customer balance. Checks the amount to be added is not negative.
	 * Also calls method to add an entry to the account transaction history.
	 * 
	 * @param amount - the double to be added to customers balance
	 */
	public void addToBalance(double amount) {
		if (amount > 0) {
			this.balance += amount;

			// add to transaction history
			addTransactionInfo("deposit: $" + String.format("%.2f", amount));
		}

	}

	/**
	 * Abstract method to subtract from the account balance.
	 * 
	 * @param amount - the double to be subtracted from the customer's balance.
	 */
	public abstract void subtractFromBalance(double amount);

	/**
	 * Print method for the transaction info. Checks the ArrayList is not null, then
	 * iterates it and prints the contents.
	 */
	public void printTransactionInfo() {
		System.out.println("CURRENT ACCOUNT SUMMARY:");
		if (transactionInfo != null) {
			for (String index : transactionInfo) {
				System.out.println(index);
			}
		}
	}

	/**
	 * Abstract method to add a line to the transactionInfo ArrayList.
	 * 
	 * @param newEntry, a String of the transaction info to be passed in.
	 */
	public abstract void addTransactionInfo(String newEntry);

	/*
	 * Outputs the account data as a String.
	 */
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber=" + accountNumber + ", active=" + active + "]";
	}

}
