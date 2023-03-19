/**
 * COMP 1451 - Lab08b
 * @author Matthew Simpson
 * @Date Winter 2019
 */

package comp1451.lab08b.employeedata;

public abstract class Employee {

	// fields for all employees
	private String name;

	/**
	 * Default constructor.
	 */
	public Employee() {

	}

	/**
	 * Main constructor for shared employee data.
	 * 
	 * @param name - a string - the name to set
	 */
	public Employee(String name) {
		setName(name);
	}

	/**
	 * Access method for the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mutator method for the name.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	/**
	 * Method will calculate monthly earnings for each employee type.
	 * 
	 * @return a double.
	 */
	public abstract double calculateMonthlyEarnings();

	/**
	 * Method to display an employee name and monthly earnings.
	 * 
	 * @return the employee name and monthly earnings as a string, earnings
	 *         formatted to 2 decimal places.
	 */
	public String displayEmployee() {
		return getName() + " earned $" + String.format("%.2f", calculateMonthlyEarnings()) + " last month.";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", calculateMonthlyEarnings()=" + calculateMonthlyEarnings() + "]";
	}

}
