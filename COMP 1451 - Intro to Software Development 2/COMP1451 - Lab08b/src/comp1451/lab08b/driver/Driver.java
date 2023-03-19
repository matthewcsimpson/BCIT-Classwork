/**
 * COMP 1451 - Lab08b
 * @author Matthew Simpson
 * @Date Winter 2019
 */

package comp1451.lab08b.driver;

import comp1451.lab08b.companydata.Company;
import comp1451.lab08b.employeedata.CommissionEmployee;
import comp1451.lab08b.employeedata.Employee;
import comp1451.lab08b.employeedata.HourlyEmployee;
import comp1451.lab08b.employeedata.SalariedEmployee;


public class Driver {

	public static void main(String[] args) {

		// new hourly employee who worked 39 hours last month
		Employee hourlyPerson = new HourlyEmployee("James", 39);
		// new commission based employee with a rate of 20% and who sold $126305 last
		// month
		Employee commissionPerson = new CommissionEmployee("Jimmy", 20.0, 96403.0);
		// new salaried employee who makes $98000 per year. 
		Employee salariedPerson = new SalariedEmployee("Steven", 98000.0, 48);
		// and here's a fourth person
		Employee extraPerson = new CommissionEmployee("Reginald D. Baker", 20.0, 300405.0);


		// make a new company
		Company newCompany = new Company();
		
		//add employees to the company
		newCompany.addEmployee(hourlyPerson);
		newCompany.addEmployee(commissionPerson);
		newCompany.addEmployee(salariedPerson);
		newCompany.addEmployee(extraPerson);

		
		
		// let's display them all!
		System.out.println("Here are the employees of the company:");
		newCompany.displayEmpployees();
		System.out.println();
		System.out.println("Now we remove Reginald");
		newCompany.removeEmployee(extraPerson);
		newCompany.displayEmpployees();

	}

}
