/**
 * COMP 1451 - Assignment Three
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

package comp1451.assignment3.bankdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class BankReport implements Reporter {

	public BankReport() {

	}

	/**
	 * Method to display all the accounts of a certain type by searching for their
	 * account prefix. Generates an ArrayList of all matching accounts and outputs
	 * the contents. search is case insensitive.
	 * 
	 * @param records - the HashMap to search
	 * @param prefix  - the prefix (a string) to search for
	 */
	@Override
	public void displayByCode(HashMap<String, BankCustomer> records, String prefix) {
		if (records != null && prefix != null) {
			if (prefix.equalsIgnoreCase("sa") || prefix.equalsIgnoreCase("ch") || prefix.equalsIgnoreCase("gl")) {
				ArrayList<String> accountList = new ArrayList<String>();
				for (Entry<String, BankCustomer> index : records.entrySet()) {
					if (index.getKey().startsWith(prefix.toUpperCase())) {
						String activeStatus = null;
						if (index.getValue().getAccount().isActive()) {
							activeStatus = "(Active)";
						} else if (!index.getValue().getAccount().isActive()) {
							activeStatus = "(Inactive)";
						}

						accountList.add(index.getValue().getAccount().getAccountNumber() + ", $"
								+ String.format("%.2f", index.getValue().getAccount().getBalance()) + ", " + index.getValue().getFirstName()
								+ " " + index.getValue().getLastName() + " " + activeStatus);
					}
				}
				Collections.sort(accountList);
				for (String index : accountList) {
					System.out.println(index);

				}

			} else {
				System.out.println();
				System.out.println("please enter one of the three prefixes");
			}
			System.out.println();

		}
	}

	/**
	 * Method to display all the active accounts in the bank HashMap.
	 * 
	 * @param records - the HashMap to search
	 */
	@Override
	public void displayAllCodes(HashMap<String, BankCustomer> records) {
		if (records != null) {
			ArrayList<String> accountList = new ArrayList<String>();
			for (Entry<String, BankCustomer> index : records.entrySet()) {
				if (index.getValue().getAccount().isActive() == true) {
					String activeStatus = null;
					if (index.getValue().getAccount().isActive()) {
						activeStatus = "(Active)";
					} else if (!index.getValue().getAccount().isActive()) {
						activeStatus = "(Inactive)";
					}

					accountList.add(
							index.getValue().getAccount().getAccountNumber() + ", " + index.getValue().getFirstName()
									+ " " + index.getValue().getLastName() + " " + activeStatus);
				}
			}
			Collections.sort(accountList);
			for (String index : accountList) {
				System.out.println(index);
			}
			System.out.println();
		}
	}

	/**
	 * Method to display all the inactive accounts in the bank HashMap.
	 * 
	 * @param records - the HashMap to search
	 */
	@Override
	public void displayInactiveCodes(HashMap<String, BankCustomer> records) {
		if (records != null) {
			ArrayList<String> accountList = new ArrayList<String>();
			for (Entry<String, BankCustomer> index : records.entrySet()) {
				if (index.getValue().getAccount().isActive() == false) {
					String activeStatus = null;
					if (index.getValue().getAccount().isActive()) {
						activeStatus = "(Active)";
					} else if (!index.getValue().getAccount().isActive()) {
						activeStatus = "(Inactive)";
					}
					accountList.add(
							index.getValue().getAccount().getAccountNumber() + ", " + index.getValue().getFirstName()
									+ " " + index.getValue().getLastName() + " " + activeStatus);
				}
			}
			Collections.sort(accountList, Collections.reverseOrder());
			for (String index : accountList) {
				System.out.println(index);
			}
			System.out.println();
		}
	}

	/**
	 * Method to display the total balance of all accounts in the bank HashMap.
	 * 
	 * @param records - the HashMap to search
	 */
	public void displayAccountTotals(HashMap<String, BankCustomer> records) {
		if (records != null) {
			double bankSum = 0;
			for (Entry<String, BankCustomer> index : records.entrySet()) {
				System.out.print("$" + String.format("%.2f", bankSum) + " + $"
						+ String.format("%.2f", index.getValue().getAccount().getBalance()));
				bankSum += index.getValue().getAccount().getBalance();
				System.out.println(" = $" + String.format("%.2f", bankSum));
			}
			System.out.println("The total amount of money in the bank is: ");
			System.out.println("$" + String.format("%.2f", bankSum));
			System.out.println();
		}
	}

}
