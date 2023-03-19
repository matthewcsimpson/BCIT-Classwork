/**
 * COMP 1451 - Lab08b
 * @author Matthew Simpson
 * @Date Winter 2019
 */

package comp1451.lab08b.employeedata;

public class SalariedEmployee extends Employee {

	// salaried employee fields.
	private double yearlySalary;
	private int weeksPerYear;

	// constants, because magic numbers are frowned upon.
	public static final int WEEKS_PER_YEAR = 52;
	public static final int MONTHS_PER_YEAR = 12;

	/**
	 * Default constructor for the Salaried Employees.
	 */
	public SalariedEmployee() {

	}

	/**
	 * Main constructor for the Salaried Employees.
	 * 
	 * @param name         - a String - the name to be set, processed by the
	 *                     abstract superclass.
	 * @param yearlySalary - a double - the amount earned per year.
	 * @param weeksPerYear - an int - the number of weeks per year a salaried
	 *                     employee is expected to work
	 */
	public SalariedEmployee(String name, double yearlySalary, int weeksPerYear) {
		super(name);
		setYearlySalary(yearlySalary);
		setWeeksPerYear(weeksPerYear);
	}

	/**
	 * Access method for the yearly salary.
	 * 
	 * @return the yearlySalary as a double
	 */
	public double getYearlySalary() {
		return yearlySalary;
	}

	/**
	 * Access method for the number of weeks per year
	 * 
	 * @return the expectedNumWeeksWorked as an int
	 */
	public int getWeeksPerYear() {
		return weeksPerYear;
	}

	/**
	 * Mutator method for the yearlySalary
	 * 
	 * @param yearlySalary - a double - the yearlySalary to set
	 */
	public void setYearlySalary(double yearlySalary) {
		if (yearlySalary > 0) {
			this.yearlySalary = yearlySalary;
		}
	}

	/**
	 * Mutator method fo the number of weeks a salaried emmployee is expected to
	 * work per year. s
	 * 
	 * @param weeksPerYear - an int - the number of weeks to set
	 */
	public void setWeeksPerYear(int weeksPerYear) {
		if (weeksPerYear > 0) {
			this.weeksPerYear = weeksPerYear;
		}
	}

	@Override
	public double calculateMonthlyEarnings() {
		return (yearlySalary / weeksPerYear) * (WEEKS_PER_YEAR / MONTHS_PER_YEAR);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalariedEmployee [yearlySalary=" + yearlySalary + ", weeksPerYear=" + weeksPerYear + " toString="
				+ super.toString() + "]";
	}

}
