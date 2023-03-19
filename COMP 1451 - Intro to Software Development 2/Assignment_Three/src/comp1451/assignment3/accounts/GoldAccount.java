/**
 * COMP 1451 - Assignment Three
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

package comp1451.assignment3.accounts;

import java.time.LocalDateTime;

public class GoldAccount extends Account {

	private double interestRate;
	private boolean inOverdraft;
	public static final double FEE = 5.0;
	public static final double OVERDRAFT_AMT = 100.0;
	public static final int MIN_AGE = 65;

	/**
	 * Default constructor.
	 */
	public GoldAccount() {
		super();
	}

	/**
	 * Main constructor for GoldAccount objects. Balance, accountNumber, active
	 * parameters set by the superclass, interestRate and overDraft status to be
	 * validated.
	 * 
	 * @param balance       - a double - the balance to be set
	 * @param accountNumber - a String - the account number to be set
	 * @param active        - a boolean - the status to be set
	 * @param interestRate  - a double - the interest rate to be set.
	 * @param inOverdraft   - a boolean - the overdraft status to be set.
	 */
	public GoldAccount(double balance, boolean active, double interestRate, boolean inOverdraft) {
		super(balance, active);
		setInterestRate(interestRate);
		setInOverdraft(inOverdraft);
		addTransactionInfo("opening balance: $" + String.format("%.2f", balance));

	}

// getters

	/**
	 * Access method for the interest rate.
	 * 
	 * @return the interestRate as a double.
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * Access method for the overdraft status as in overdraft (true) or not (false).
	 * 
	 * @return the inOverdraft as a boolean.
	 */
	public boolean isInOverdraft() {
		return inOverdraft;
	}

// setters

	/**
	 * Mutator method for the interest rate. Makes sure the interest rate is not
	 * negative.
	 * 
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		if (interestRate >= 0.0) {
			this.interestRate = interestRate;
		}
	}

	/**
	 * Mutator method for the overdraft status as in overdaft (true) or not (false).
	 * 
	 * @param inOverdraft the inOverdraft to set
	 */
	public void setInOverdraft(boolean inOverdraft) {
		this.inOverdraft = inOverdraft;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Account#setAccountNumber(java.lang.String)
	 * 
	 * Overridden method so that GoldAccount objects account numbers have the prefix
	 * "GA-".
	 */
	@Override
	public void setAccountNumber() {
		super.setAccountNumber();
		this.accountNumber = "GL-" + this.accountNumber;
		}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Account#setBalance(double)
	 * 
	 * Overridden method so that the new balance is checked with the zero minus the
	 * OVERDRAFT_AMT rather than zero. Also calls the checkOverdraft method to
	 * determine if the account is in overdraft.
	 */
	@Override
	public void setBalance(double balance) {
		if (balance >= (0 - OVERDRAFT_AMT)) {
			this.balance = balance;
			checkOverdraft(this.balance);
		} else {
			System.out.println("error: you cannot go lower than your overdraft limit.");
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Account#subtractFromBalance(double)
	 * 
	 *      Overridden method so that the new balance is checked against zero minus
	 *      the OVERDRAFT_AMT rather than just zero. Also calls the checkOverdraft
	 *      method to determines if the account is in overdraft.
	 */
	@Override
	public void subtractFromBalance(double amount) {
		if (amount >= 0) {
			double checkBalance = this.balance - (amount + FEE);
			if (checkBalance >= (0 - OVERDRAFT_AMT)) {
				this.balance -= amount;
				// add to transaction info
				addTransactionInfo("withdrawal: $" + String.format("%.2f", amount));

				if (checkBalance < 0 && checkBalance >= (0 - OVERDRAFT_AMT)) {
					// process overdraft fee
					this.balance -= FEE;
					// add to transaction info
					addTransactionInfo("overdraft fee: $" + String.format("%.2f", FEE));
				}

				// check overdraft status
			} else {
				System.out.println("error: you cannot withdraw past your overdraft limit.");
			}

		} else {
			System.out.println("error: withdrawal amount cannot be negative.");
		}
	}

	/**
	 * Method to check if an account is in overdraft (balance between zero and zero
	 * minus overdraft) and set the status boolean appropriately
	 * 
	 * @param check - a double - the balance to be checked
	 */
	private void checkOverdraft(double check) {
		double overdraftBalance = 0.0 - OVERDRAFT_AMT;
		if (check < 0.0 && check >= overdraftBalance) {
			this.setInOverdraft(true);
		} else {
			this.setInOverdraft(false);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * Overridden toString method to output the GoldAccount object specific details.
	 */
	@Override
	public String toString() {
		return "GoldAccount [interestRate=" + interestRate + ", inOverdraft=" + inOverdraft + " " + super.toString()
				+ "]";
	}

	/**
	 * @see Account#addTransactionInfo(String)
	 * 
	 *      Overridden / Abstract addTransaction method. First checks overdraft
	 *      status on the account. Then generates a string that includes the account
	 *      number, the transaction details, and the overdraft status.
	 */
	@Override
	public void addTransactionInfo(String newEntry) {
		// overdraft check is here because this method is called after every
		// transaction, which means it can be placed here once.
		checkOverdraft(this.balance);
		if (newEntry != null) {
			LocalDateTime timestamp = LocalDateTime.now();
			String formattedTimeStamp = timestamp.format(formatter);
			String overdraftStatus = null;

			// overdraft status
			if (inOverdraft == true) {
				overdraftStatus = "In Overdraft";
			} else if (inOverdraft == false) {
				overdraftStatus = "Not in Overdraft";
			}

			transactionInfo.add("Account " + getAccountNumber() + " " + formattedTimeStamp + " - " + newEntry
					+ "\r Current Balance: $" + String.format("%.2f", getBalance()) + "| Overdraft Status: "
					+ overdraftStatus);
		}
	}
}
