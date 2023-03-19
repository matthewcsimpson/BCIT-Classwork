/**
 * COMP 1451 - Assignment Three
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

package comp1451.assignment3.bankdata;

import comp1451.assignment3.accounts.Account;
import comp1451.assignment3.accounts.GoldAccount;

public class BankCustomer {

	// fields
	private String firstName;
	private String lastName;
	private String passcode;
	private Account myAccount;
	private int age;

	private static final String DEFAULT_PASSCODE = "0000";
	private static final String DEFAULT_FIRST_NAME = "John";
	private static final String DEFAULT_LAST_NAME = "Doe";

	private int generated_account_number = 1000;

	/**
	 * Default constructor for a BankCustomer. Sets the fields to the default values
	 * for each type.
	 */
	public BankCustomer() {

	}

	/**
	 * Constructor for new customer objects.
	 * 
	 * @param firstName - String to initialize the firstName field
	 * @param lastName  - String to initialize the lastName field
	 * @param passcode  - String to initialize the passcode field
	 * @param newAge    - Int to initializ the age field.
	 */
	public BankCustomer(String firstName, String lastName, String passcode, int newAge) {
		setFirstName(firstName);
		setLastName(lastName);
		setPasscode(passcode);
		setAge(newAge);
	}

	// getters
	// ----------------------------------------------------------------------

	/**
	 * Access method for the firstName field
	 * 
	 * @return the firstName as a String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Access method for the lastName field
	 * 
	 * @return the lastName as a String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Access method for the passcode field
	 * 
	 * @return the passcode as a String
	 */
	public String getPasscode() {
		return passcode;
	}

	/**
	 * Access method for the customer account.
	 * 
	 * @return the account as an account object. .
	 */
	public Account getAccount() {
		return myAccount;
	}

	/**
	 * Access method for the customer age.
	 * 
	 * @return the age as an int
	 */
	public int getAge() {
		return age;
	}

	// setters
	// ----------------------------------------------------------------------

	/**
	 * Mutator method for the firstName field. Sets the default if null.
	 * 
	 * @param firstName - the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName != null) {
			this.firstName = firstName;
		} else {
			this.firstName = DEFAULT_FIRST_NAME;
		}
	}

	/**
	 * Mutator method for the lastName field. Sets the default if null.
	 * 
	 * @param lastName - the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName != null) {
			this.lastName = lastName;
		} else {
			this.lastName = DEFAULT_LAST_NAME;
		}
	}

	/**
	 * Mutator method for the passcode field. Sets the default if null.
	 * 
	 * @param passcode - the passcode to set.
	 */
	public void setPasscode(String passcode) {
		if (passcode != null) {
			this.passcode = passcode;
		} else {
			this.passcode = DEFAULT_PASSCODE;
		}
	}

	/**
	 * Mutator method for the Account object reference. Checks that the new object
	 * is not null. If GoldAccount is the type to be set, validates against the
	 * BankCustomer's minimum age (if this check fails, a default Account object is
	 * set).
	 * 
	 * @param newAccount - the new account object to set.
	 */
	public void setAccount(Account newAccount) {
		if (newAccount != null) {
			if (newAccount instanceof GoldAccount) {
				if (age >= GoldAccount.MIN_AGE) {
					this.myAccount = newAccount;
				} else {
					System.out.println("error, must be 65 or older to have a gold account");
				}

			} else {
				this.myAccount = newAccount;

			}
		}
	}

	/**
	 * Mutator method for the customers age. Checks that the age is not negative.
	 * 
	 * @param newAge
	 */
	public void setAge(int newAge) {
		if (newAge > 0) {
			this.age = newAge;
		}
	}

	/**
	 * Output customer data as a string.
	 */
	public String toString() {
		return "BankCustomer [firstName=" + firstName + ", lastName=" + lastName + ", passcode=" + passcode
				+ ", account=" + myAccount.toString() + ", age=" + age + "]";
	}

}
