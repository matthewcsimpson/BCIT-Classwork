/**
 * COMP 1451 - Lab08b
 * @author Matthew Simpson
 * @Date Winter 2019
 */

package comp1451.lab08b.employeedata;

public class CommissionEmployee extends Employee {

	// commission empolyee fields
	private double comissionRate;
	private double monthlySalesTotal;

	/**
	 * default constructor for commission employees
	 */
	public CommissionEmployee() {
		super();
	}

	/**
	 * Main constructor for commission employees.
	 * 
	 * @param name              - a String - the name to set, processed in the abstract superclass. 
	 * @param comissionRate     - a double - the commission percentage rate to set.
	 * @param monthlySalesTotal - a double - the monthly total sales dollars to set.
	 */
	public CommissionEmployee(String name, double comissionRate, double monthlySalesTotal) {
		super(name);
		this.comissionRate = comissionRate;
		this.monthlySalesTotal = monthlySalesTotal;
	}

	/**
	 * Access method for the comission rate
	 * 
	 * @return the comissionRate as a double
	 */
	public double getComissionRate() {
		return comissionRate;
	}

	/**
	 * Access method for the monthly sales
	 * 
	 * @return the monthlySalesTotal as a double
	 */
	public double getMonthlySalesTotal() {
		return monthlySalesTotal;
	}

	/**
	 * Mutator method for the commission rate
	 * 
	 * @param comissionRate the comissionRate to set
	 */
	public void setComissionRate(double comissionRate) {
		if (comissionRate >= 0) {
			this.comissionRate = comissionRate;
		}
	}

	/**
	 * Mutator method for the monthly sales total.
	 * 
	 * @param monthlySalesTotal the monthlySalesTotal to set
	 */
	public void setMonthlySalesTotal(double monthlySalesTotal) {
		if (monthlySalesTotal >= 0) {
			this.monthlySalesTotal = monthlySalesTotal;
		}
	}

	/*
	 * non-Javadoc
	 * 
	 * see {@link Lab8a.Employee#calculateMonthlyEarnings()}
	 */
	@Override
	public double calculateMonthlyEarnings() {
		double monthlyEarnings = monthlySalesTotal * (comissionRate / 100);
		return monthlyEarnings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComissionEmployee [comissionRate=" + comissionRate + ", monthlySalesTotal=" + monthlySalesTotal
				+ ", toString()=" + super.toString() + "]";
	}

}
