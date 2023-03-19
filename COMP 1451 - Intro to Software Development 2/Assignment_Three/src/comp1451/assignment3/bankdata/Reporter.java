/**
 * COMP 1451 - Assignment Three
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

package comp1451.assignment3.bankdata;

import java.util.HashMap;

public interface Reporter {
	
	/**
	 * Method to display all the accounts of a certain type by searching for their account prefix. 
	 * 
	 * @param records 	- the hashmap to search
	 * @param prefix	- the prefix (a string) to search for
	 */
	void displayByCode(HashMap<String, BankCustomer> records, String prefix);
	
	/**
	 * Method to display all the active accounts in the bank hashmap. 
	 * 
	 * @param records	- the hashmap to search
	 */
	void displayAllCodes(HashMap<String, BankCustomer> records);
	
	/**
	 * Method to display all the inactive accounts in the bank HashMap. 
	 * 
	 * @param records 	- the HashMap to search
	 */
	void displayInactiveCodes(HashMap<String, BankCustomer> records);

}
