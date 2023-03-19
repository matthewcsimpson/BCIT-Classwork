/**
 * COMP 1451 - Assignment Three
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

package comp1451.assignment3.accounts;

import java.time.LocalDateTime;

public class ChequingAccount extends Account {

	public static final double FEE = 1.0;
	private int numberOfCheques;

	/**
	 * Default constructor.
	 */
	public ChequingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Main constructor for ChequingAccounts. Balance, accountNumber, account status
	 * validated by superclass.
	 * 
	 * @param balance         - a double - the balance to be set.
	 * @param accountNumber   - a String - the account number to be set.
	 * @param active          - a boolean - the status of the account as active
	 *                        (true) or not (false).
	 * @param numberOfCheques - an int - the number of cheques assigned to this
	 *                        account.
	 */
	public ChequingAccount(double balance, boolean active, int numberOfCheques) {
		super(balance, active);
		setNumberOfCheques(numberOfCheques);
		
		addTransactionInfo("opening balance: $" + String.format("%.2f", balance));

	}

	/**
	 * Access method for the number of cheques.
	 * 
	 * @return the numberOfCheques as an int.
	 */
	public int getNumberOfCheques() {
		return numberOfCheques;
	}

	/**
	 * Mutator method for the number of cheques assigned to the account.
	 * 
	 * @param numberOfCheques - an int - the numberOfCheques to set
	 */
	public void setNumberOfCheques(int numberOfCheques) {
		if (numberOfCheques >= 0) {
			this.numberOfCheques = numberOfCheques;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Account#setAccountNumber(java.lang.String)
	 * 
	 * Overridden method so that ChequingAccount objects account numbers have the
	 * prefix "CH-".
	 */
	@Override
	public void setAccountNumber() {
		super.setAccountNumber();
		this.accountNumber = "CH-" + this.accountNumber;
		}

	/**
	 * @see Account#subtractFromBalance(double)
	 * 
	 *      Overridden Abstract ubstractFromBalance method. Checks that withdrawals
	 *      plus fees will not result in a negative balance. Also processes a fee
	 *      for each withdrawal and subtracts one cheque from the user.
	 */
	@Override
	public void subtractFromBalance(double amount) {
		if (amount >= 0) {
			double checkBalance = this.balance - (amount + FEE);
			if (checkBalance >= 0) {
				this.balance -= amount;
				// add to transaction history.
				addTransactionInfo("withdrawal: $" + String.format("%.2f", amount));

				// process the cheque fee
				numberOfCheques -= 1;
				this.balance -= FEE;
				addTransactionInfo("cheque fee: $" + String.format("%.2f", FEE));

			} else {
				System.out.println("error: you cannot withdraw more than you have!");
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * Overridden toString method to output the ChequingAccount object specific
	 * details.
	 */
	@Override
	public String toString() {
		return "ChequingAccount [numberOfCheques=" + numberOfCheques + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @see Account#addTransactionInfo(String)
	 * 
	 *      Overridden Abstract addTransacitonINfo method. Generates a string that
	 *      includes the account number, transaction details, and the number of
	 *      cheques remaining.
	 */
	@Override
	public void addTransactionInfo(String newEntry) {
		if (newEntry != null) {
			LocalDateTime timestamp = LocalDateTime.now();
			String formattedTimeStamp = timestamp.format(formatter);

			transactionInfo.add("Account " + getAccountNumber() + " " + formattedTimeStamp + " - " + newEntry
					+ "\r Current Balance: $" + String.format("%.2f", getBalance()) + "| No. of Cheques Remaining: "
					+ getNumberOfCheques());
		}

	}

}
