/**
 * COMP 1451 - Lab08b
 * @author Matthew Simpson
 * @Date Winter 2019
 */

package comp1451.lab08b.companydata;

import java.util.ArrayList;

import comp1451.lab08b.employeedata.Employee;

public class Company {

	// the array list of company employees
	private ArrayList<Employee> myCompany;

	/**
	 * The main construtor for the company class. initializes the array list.
	 */
	public Company() {
		myCompany = new ArrayList<Employee>();
	}

	/**
	 * Accessor method for the company arraylist.
	 * 
	 * @return the myCompany, an ArrayList
	 */
	public ArrayList<Employee> getMyCompany() {
		return myCompany;
	}

	/**
	 * Method to add an employee to the company ArrayList.
	 * 
	 * @param newEmployee, an Employee object.
	 */
	public void addEmployee(Employee newEmployee) {
		if (newEmployee != null) {
			myCompany.add(newEmployee);
		}
	}

	/**
	 * Method to remove an employee from the company ArrayList.
	 * 
	 * @param newEmployee, an Employee obect.
	 */
	public void removeEmployee(Employee newEmployee) {
		if (newEmployee != null) {
			for (Employee index : myCompany) {
				if (index == newEmployee) {
					myCompany.remove(index);
					break;
				}
			}
		}
	}

	/**
	 * Method to display all the employees of the company. Calls the displayEmployee
	 * method from the Employee objects.
	 */
	public void displayEmpployees() {
		if (myCompany != null) {
			for (Employee index : myCompany) {
				System.out.println(index.displayEmployee());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Company [myCompany=" + myCompany + "]";
	}

}
