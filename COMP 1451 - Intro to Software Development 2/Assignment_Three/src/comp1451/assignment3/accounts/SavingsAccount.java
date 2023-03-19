/**
 * COMP 1451 - Assignment Three
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

package comp1451.assignment3.accounts;

import java.time.LocalDateTime;

public class SavingsAccount extends Account {

	// the minimum ammount necesaary to keep a savings account active.
	public static final double MIN_AMOUNT = 10.0;

	/**
	 * Default constructor.
	 */
	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Main constructor for new SavingsAccount objects, which are a subclass of
	 * Account. All parameters validated by the superclass, balance validated with
	 * overridden method.
	 * 
	 * @param balance       - a double - the balance to set.
	 * @param accountNumber - a String - the account number to set.
	 * @param active        - a boolean - the account status.
	 */
	public SavingsAccount(double balance, boolean active) {
		super(balance, active);
		
		checkActive(this.balance);
		addTransactionInfo("opening balance: $" + String.format("%.2f", balance));


	}

	/*
	 * (non-Javadoc)
	 * 
	 * Overridden method so that SavingsAccount object account numbers have the
	 * prefix "SA-"
	 * 
	 * @see Account#setAccountNumber(java.lang.String)
	 */
	@Override
	public void setAccountNumber() {
		super.setAccountNumber();
		this.accountNumber = "SA-" + this.accountNumber;
		
	}

	/**
	 * Adds to the customer balance. Checks the amount to be added is not negative.
	 * Also calls method to add an entry to the account transaction history.
	 * 
	 * @param amount - the double to be added to customers balance
	 */
	@Override
	public void addToBalance(double amount) {
		if (amount > 0) {
			this.balance += amount;
			checkActive(this.balance);

			// add to transaction history
			addTransactionInfo("deposit: $" + String.format("%.2f", amount));
		}

	}

	/**
	 * @see Account#subtractFromBalance(double)
	 * 
	 *      Overridden abstract subtractFromBalance method. Makes sure that
	 *      withdrawal will not result in negative balance. Also checks current
	 *      balance against the active minimum and sets whether the account is still
	 *      active as a result.
	 */
	@Override
	public void subtractFromBalance(double amount) {
		if (amount >= 0) {
			double checkBalance = this.balance - amount;
			if (checkBalance >= 0) {
				this.balance -= amount;
				checkActive(this.balance);
				// add to transaction history.
				addTransactionInfo("withdrawal: $" + String.format("%.2f", amount));

			} else {
				System.out.println("error: you cannot withdraw more than you have!");
			}
		}

	}

	/**
	 * Method to check the account balance against the minimum amount required for
	 * the SavingsAccount to remain active.
	 * 
	 * @param check - a double - the amount to check.
	 */
	private void checkActive(final double check) {
		if (check >= MIN_AMOUNT) {
			this.setActive(true);
		} else {
			this.setActive(false);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * Overridden toString method to output the SavingsAccount object specific
	 * details.
	 */
	@Override
	public String toString() {
		return "SavingsAccount [" + super.toString() + "]";
	}

	/**
	 * @see Account#addTransactionInfo(String)
	 * 
	 *      Overridden abstract addTransactionInfo method. Generates a string
	 *      including Account, transaction details, and active status.
	 */
	@Override
	public void addTransactionInfo(String newEntry) {
		if (newEntry != null) {
			LocalDateTime timestamp = LocalDateTime.now();
			String formattedTimeStamp = timestamp.format(formatter);

			// active status
			String activeStatus = null;
			if (this.isActive() == true) {
				activeStatus = "Active";
			} else if (this.isActive() == false) {
				activeStatus = "Inactive";
			}

			transactionInfo.add("Account " + getAccountNumber() + " " + formattedTimeStamp + " - " + newEntry
					+ "\r Current Balance: $" + String.format("%.2f", getBalance()) + "| Current Status: "
					+ activeStatus);
		}

	}

}
