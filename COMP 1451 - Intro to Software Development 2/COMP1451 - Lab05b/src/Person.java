/**
 * COMP1451 - Lab 05b
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

public class Person {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String bcitID;

	/**
	 * default constructor
	 */
	public Person() {

	}

	/**
	 * Constructor for a person defining their first name, last name, email address,
	 * and BCIT ID.
	 * 
	 * @param firstName    a string, the first name to set
	 * @param lastName     a string, the last name to set
	 * @param emailAddress a string, the email address to set
	 * @param bcitID       a string, the BCIT ID to set
	 */
	public Person(String firstName, String lastName, String emailAddress, String bcitID) {

		setFirstName(firstName);
		setLastName(lastName);
		setEmailAddress(emailAddress);
		setBcitID(bcitID);
	}

	// getters

	/**
	 * method to return the person's first name
	 * 
	 * @return firstName a string, the persons first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * method to return the person's last name
	 * 
	 * @return lastName a string, the person's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * method to return the person's email address.
	 * 
	 * @return emailAddress a string, the person's email address.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * method to return the person's BCIT ID
	 * 
	 * @return bcitID a string, the person's BCIT ID
	 */
	public String getBcitID() {
		return bcitID;
	}

	// setters

	/**
	 * method to set the person's first name. checks the input is not null.
	 * 
	 * @param firstName a string, the first name to set
	 */
	public void setFirstName(String firstName) {
		if (firstName != null) {
			this.firstName = firstName;
		}
	}

	/**
	 * method to set the person's last name. checks the input is not null
	 * 
	 * @param lastName a string, the first name to set
	 */
	public void setLastName(String lastName) {
		if (lastName != null) {
			this.lastName = lastName;
		}
	}

	/**
	 * method to set the person's email address. checks the input is not null.
	 * 
	 * @param emailAddress a string, the first name to set
	 */
	public void setEmailAddress(String emailAddress) {
		if (emailAddress != null) {
			this.emailAddress = emailAddress;
		}
	}

	/**
	 * method to set the person's BCIT ID. checks the input is not null.
	 * 
	 * @param bcitID a string, the BCIT ID to set
	 */
	public void setBcitID(String bcitID) {
		if (bcitID != null) {
			this.bcitID = bcitID;
		}
	}

}
