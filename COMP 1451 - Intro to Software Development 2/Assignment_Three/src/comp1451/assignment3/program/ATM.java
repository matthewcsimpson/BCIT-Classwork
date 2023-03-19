/**
 * COMP 1451 - Assignment Three
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

package comp1451.assignment3.program;

import comp1451.assignment3.accounts.Account;
import comp1451.assignment3.accounts.ChequingAccount;
import comp1451.assignment3.accounts.GoldAccount;
import comp1451.assignment3.accounts.SavingsAccount;
import comp1451.assignment3.bankdata.Bank;
import comp1451.assignment3.bankdata.BankCustomer;
import comp1451.assignment3.bankdata.BankReport;

public class ATM {

	// booleans to control whether someone is signed in & whether that person is an
	// employee, also if the program is running.
	private boolean signedIn;
	private boolean employeeSignedIn;
	boolean running;
	// new InputReader to capture input from the customer
	private InputReader reader;
	// the bank object.
	private Bank myBank;
	// a new BankCustomer object to be the customer currently interacting with the
	// bank.
	private BankCustomer currentCustomer;
	// a new BankReport object, so reports can be run.
	private BankReport reportRunner;

	/**
	 * The default constructor. Initializes the currentCustomer & InputReader
	 * objects, call the initialize() and run() methods to run the program.
	 */
	public ATM() {
		// currentCustomer = new BankCustomer();
		reader = new InputReader();
		reportRunner = new BankReport();
		running = true;
		initialize();
		run();
	}

	/**
	 * The main method - calls the default constructor.
	 * 
	 * @param args - for program arguments (unused).
	 */
	public static void main(String[] args) {

		new ATM();

	}

	/**
	 * Creates new BankCustomer objects, attaches them to BankCustomers, and stores
	 * them in the myBank Bank HashMap. Called by the default constructor.
	 */
	public void initialize() {
		// make a new bank.
		myBank = new Bank();

		// make accounts of each type/sub-type.
		Account johnsAccount = new SavingsAccount(4.0, true);
		Account paulsAccount = new ChequingAccount(500, true, 20);
		Account georgesAccount = new GoldAccount(35, true, 1.0, false);
		Account ringosAccount = new SavingsAccount(5.0, true);

		Account micksAccount = new ChequingAccount(600.0, true, 100);
		Account keithsAccount = new GoldAccount(-40.0, true, 1.0, false);
		Account charliesAccount = new SavingsAccount(6.0, true);
		Account ronniesAccount = new ChequingAccount(12345.0, true, 85);

		Account fleetsAccount = new SavingsAccount(9.0, true);
		Account lindsaysAccount = new SavingsAccount(8.0, true);

		// make new customers.
		BankCustomer john = new BankCustomer("John", "Lennon", "0000", 45);
		BankCustomer paul = new BankCustomer("Paul", "McCartney", "0000", 58);
		BankCustomer george = new BankCustomer("George", "Harrison", "0000", 70);
		BankCustomer ringo = new BankCustomer("Richard", "Starkey", "0000", 39);

		BankCustomer mick = new BankCustomer("Michael", "Jagger", "0000", 88);
		BankCustomer keith = new BankCustomer("Keith", "Richards", "0000", 105);
		BankCustomer charlie = new BankCustomer("Charles", "Watt", "0000", 78);
		BankCustomer ronnie = new BankCustomer("Ronald", "Wood", "0000", 57);

		BankCustomer mickF = new BankCustomer("MIck", "Fleetwood", "0000", 64);
		BankCustomer lindsay = new BankCustomer("Lindsay", "Buckingham", "0000", 55);

		// assign accounts to the customers.
		john.setAccount(johnsAccount);
		paul.setAccount(paulsAccount);
		george.setAccount(georgesAccount);
		ringo.setAccount(ringosAccount);

		mick.setAccount(micksAccount);
		keith.setAccount(keithsAccount);
		charlie.setAccount(charliesAccount);
		ronnie.setAccount(ronniesAccount);

		mickF.setAccount(fleetsAccount);
		lindsay.setAccount(lindsaysAccount);

		// add the customers to the bank.
		myBank.createAccount(john);
		myBank.createAccount(paul);
		myBank.createAccount(george);
		myBank.createAccount(ringo);

		myBank.createAccount(mick);
		myBank.createAccount(keith);
		myBank.createAccount(charlie);
		myBank.createAccount(ronnie);

		myBank.createAccount(mickF);
		myBank.createAccount(lindsay);
	}

	/**
	 * The primary application processor. All application functions are called from
	 * here. Uses a while loop & boolean (running) to prompt users for input and
	 * banking transactions. Uses a boolean (signedIn) to check that a user is
	 * signed in, a boolean (employeeSignedIn) to check if an Employee is signed in,
	 * and uses a switch case to determine user selections.
	 */
	public void run() {
		while (running == true) {
			displayInterface();
			int choice = reader.getIntInput();

			switch (choice) {
			case 1:
				if (!signedIn && !employeeSignedIn) {
					verifyCustomer();
				} else if (signedIn) {
					signedIn = false;
				} else if (employeeSignedIn) {
					employeeSignedIn = false;
				}
				break;
			case 2:
				if (!signedIn && !employeeSignedIn) {
					signout();
				} else if (signedIn) {
					transactDeposit();
				} else if (employeeSignedIn) {
					System.out.println("Savings = SA, Chequing = CH, Gold = GL");
					System.out.print("Please enter an account prefix: ");
					String checkPrefix = reader.getStringInput();
					reportRunner.displayByCode(myBank.theBank, checkPrefix);
				}
				break;
			case 3:
				if (signedIn) {
					transactWithdraw();
				} else if (employeeSignedIn) {
					System.out.println("all active accounts (ascending order):");
					reportRunner.displayAllCodes(myBank.theBank);
				}
				break;
			case 4:
				if (signedIn) {
					displayAccountInformation();
				} else if (employeeSignedIn) {
					System.out.println("all inactive accounts (descending order)");
					reportRunner.displayInactiveCodes(myBank.theBank);
				}
				break;
			case 5:
				if (signedIn) {
					signout();
				} else if (employeeSignedIn) {
					reportRunner.displayAccountTotals(myBank.theBank);
				}
				break;
			case 6:
				signout();
				break;
			case 10:
				debug();
				
			
//	I commented this out because this way of someone makes a type things keep moving. 
//			default:
//				System.out.println("Here's looking at you, kid");
//				System.exit(0);
				
			}
		}

	}

	/**
	 * Method that signs the user out of the bank. Separated into a method because
	 * the employee menu has more functions than the customer menu, so can be called
	 * from multiple places.
	 */
	public void signout() {
		System.out.println("Thank you for banking with Dewey, Screwem, & Howe");
		if (currentCustomer != null) {
			System.out.println(currentCustomer.toString());
			currentCustomer.getAccount().printTransactionInfo();
		}
		debug();
		running = false;
	}

	/**
	 * Performs a deposit into a BankCustomer's account. Checks to see if the user
	 * has signed in. If not, then verifyCustomer() is called and the menu is
	 * displayed again. Checks to see if amount to be deposited is positive. If not,
	 * user is notified and method is called again,
	 */
	public void transactDeposit() {
		double depAmount;
		if (signedIn == true) {
			System.out.println("Please enter the amount to deposit:");
			depAmount = reader.getDoubleInput();
			if (depAmount > 0.0) {
				myBank.deposit(currentCustomer.getAccount().getAccountNumber(), depAmount);
				System.out.println();
			} else if (depAmount <= 0.0) {
				System.out.println("Error: deposit amount cannot be negative!");
				transactDeposit();
			}
		} else if (signedIn == false) {
			System.out.println("Error: You must sign in first!");
			verifyCustomer();
			transactDeposit();
		}
	}

	/**
	 * Performs a withdrawal from a BankCustomer's account. Checks to see if the
	 * user has signed in. If not, then verifyCustomer() is called and the menu is
	 * displayed again. Checks to see if amount to be withdrawn is positive. If not,
	 * user is notified and method is called again,
	 */
	public void transactWithdraw() {
		double withAmount;
		if (signedIn == true) {
			System.out.println("Please enter the amount to withdraw:");
			withAmount = reader.getDoubleInput();
			if (withAmount > 0.0) {
				myBank.withdraw(currentCustomer.getAccount().getAccountNumber(), withAmount);
				System.out.println();
			} else if (withAmount <= 0.0) {
				System.out.println("Error: withdraw amount cannot be negative!");
				transactWithdraw();
			}
		} else if (signedIn == false) {
			System.out.println("Error: You must sign in first!");
			verifyCustomer();
			transactWithdraw();
		}
	}

	/**
	 * Displays a BankCustomer's account information if the customer has been
	 * previously verified.
	 */
	public void displayAccountInformation() {
		if (signedIn == true) {
			String customerDetails = currentCustomer.toString();
			System.out.println("Your account details:");
			System.out.println(customerDetails);
			currentCustomer.getAccount().printTransactionInfo();
			System.out.println();
		} else if (signedIn == false) {
			System.out.println("Error: You must sign in first!");
			verifyCustomer();
			displayAccountInformation();
		}

	}

	/**
	 * Confirms a customer's account number and password. Called when a customer is
	 * required to sign in. Checks account number against the HashMap first and
	 * verifies password if an account is found. Sets a boolean so the user does not
	 * have to sign in again in the same session.
	 */
	public void verifyCustomer() {
		String accountNum;
		String accountPass;
		if (myBank != null) {
			System.out.print("Please enter your account number:");
			accountNum = reader.getStringInput();
			if (myBank.theBank.containsKey(accountNum) == true) {
				System.out.print("Please enter your password:");
				accountPass = reader.getStringInput();
				if (myBank.theBank.get(accountNum).getPasscode().contentEquals(accountPass)) {
					signedIn = true;
					currentCustomer = myBank.theBank.get(accountNum);
					System.out.println();
					System.out.println("You are now signed in");
					System.out.println();
				} else {
					System.out.println();
					System.out.println("password incorrect!");
					System.out.println();
				}
			} else if (accountNum.equalsIgnoreCase("admin")) {
				System.out.print("Please enter your admin password:");
				accountPass = reader.getStringInput();
				if (accountPass.equalsIgnoreCase("admin")) {
					employeeSignedIn = true;
					System.out.println("Bank Administrator now signed in");
					System.out.println();

				}
			} else if (myBank.theBank.containsKey(accountNum) == false) {
				System.out.println("ERROR: Account not found!");
				System.out.println();
			}
		}
	}

	/**
	 * Displays the ATM interface. If no user is signed in, displays login and exit
	 * options.
	 */
	private void displayInterface() {
		if (signedIn == false && employeeSignedIn == false) {
			System.out.println("Welcome to Dewey, Screwem, & Howe Financial Advisors");
			System.out.println("Please choose one of the following options");
			System.out.println("1 - Sign In");
			System.out.println("2 - Exit");
			System.out.print(">");

		} else if (signedIn == true) {
			System.out.println("Greetings " + currentCustomer.getFirstName());
			System.out.println("Please choose one of the following options");
			System.out.println("1 - Sign Out");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Display Account Info");
			System.out.println("5 - Exit");
			System.out.print(">");
			
		} else if (employeeSignedIn == true) {
			System.out.println("BANK ADMINISTRATIVE REPORTING");
			System.out.println("Please choose one of the following options");
			System.out.println("1 - Sign Out");
			System.out.println("2 - Display Accounts by Prefix");
			System.out.println("3 - Display Active Accounts");
			System.out.println("4 - Display Inactive Accounts");
			System.out.println("5 - Display Total Amount in Bank");
			System.out.println("6 - Exit");
			System.out.print(">");
		}

	}

	/**
	 * Calls the Bank displayAllCustomer() method to display all customer info.
	 */
	private void debug() {
		System.out.println();
		System.out.println("DEBUG: Displaying all customers in the bank:");
		myBank.displayAllCustomers();
	}
}
