/**
 * COMP 1451 - Lab08b
 * @author Matthew Simpson
 * @Date Winter 2019
 */


package comp1451.lab08b.employeedata;

public class HourlyEmployee extends Employee {

	// hourly employee fields.
	private double hoursWorked;
	private final double hourlyWage = 55.0;

	/**
	 * Default constructor for the HourlyEmployee
	 */
	public HourlyEmployee() {
		super();
	}

	/**
	 * Main constructor for the HourlyEmployee.
	 * 
	 * @param name        - a String - the name to set, processed in the abstract superclass. 
	 * @param hoursWorked - a double - the number of hours worked to set.
	 */
	public HourlyEmployee(String name, double hoursWorked) {
		super(name);
		setHoursWorked(hoursWorked);
	}

	/**
	 * @return the hourlyWage as a double
	 */
	public double getHourlyWage() {
		return hourlyWage;
	}

	/**
	 * @return the hoursWorked as a double
	 */
	public double getHoursWorked() {
		return hoursWorked;
	}

	/**
	 * @param hoursWorked - a double - the hoursWorked to set
	 */
	public void setHoursWorked(double hoursWorked) {
		if (hoursWorked >= 0) {
			this.hoursWorked = hoursWorked;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * see {@link Lab8a.Employee#calculateMonthlyEarnings()}
	 */
	@Override
	public double calculateMonthlyEarnings() {
		double monthlyEarnings = hourlyWage * hoursWorked;
		return monthlyEarnings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HourlyEmployee [hoursWorked=" + hoursWorked + ", hourlyWage=" + hourlyWage + ", toString()="
				+ super.toString() + "]";
	}

}
