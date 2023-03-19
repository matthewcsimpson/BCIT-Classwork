/**
 * COMP1451 - Lab 05b
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

public class Instructor extends Person {

	// instance variables for the hourlywage and minimum wage
	private double hourlyWage;
	private static final double MINIMUM_WAGE = 12.65;

	// constructors
	/**
	 * default constructor, calls the superclass.
	 */
	public Instructor() {
		super();
	}

	/**
	 * main constructor. calls superclass for first name, last name, email address
	 * and BCIT ID validation. Also sets the instructors hourly wage.
	 * 
	 * @param firstName    a string, the first name to set
	 * @param lastName     a string, the last name to set
	 * @param emailAddress a string, the email address to salt
	 * @param bcitID       a string the BCIT ID to set
	 * @param hourlyWage   a double, the hourlyWage to set
	 */
	public Instructor(String firstName, String lastName, String emailAddress, String bcitID, double hourlyWage) {
		super(firstName, lastName, emailAddress, bcitID);
		setHourlyWage(hourlyWage);
	}

	// getter

	/**
	 * method to return the instructor's hourly wage.
	 * 
	 * @return hourlyWage a double, the instructor's hourly wage.
	 */
	public double getHourlyWage() {
		return hourlyWage;
	}

	// setter

	/**
	 * method to set the instructors hourly wage. checks to make sure it is greater
	 * than minimum wage.
	 * 
	 * @param hourlyWage a double, the hourly wage to set.
	 */
	public void setHourlyWage(double hourlyWage) {
		if (hourlyWage > MINIMUM_WAGE) {
			this.hourlyWage = hourlyWage;
		}
	}

}
