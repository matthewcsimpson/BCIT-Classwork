/**
 * COMP1451 - Lab 05b
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

import java.util.ArrayList;

public class Database {

	// the arraylist which will be the database of people
	private ArrayList<Person> database;

	/**
	 * default constructor, initializes the arraylist
	 */
	public Database() {

		database = new ArrayList<Person>();
	}

	/**
	 * method to add a person to the database, validating that the person isn't
	 * null.
	 * 
	 * @param person a person object to be added to the database
	 */
	public void addToDatabase(Person person) {
		if (person != null) {
			database.add(person);
		}
	}

	/**
	 * method to print out each person's first name, last name, and email address.
	 */
	public void displayPeople() {
		if (database != null) {
			for (Person index : database) {
				System.out.println(
						"Person: " + index.getFirstName() + " " + index.getLastName() + ", " + index.getEmailAddress());

			}
		}
	}
}
