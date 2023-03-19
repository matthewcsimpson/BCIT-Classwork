/**
 * COMP1451 - Lab 05b
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

import java.util.HashMap;

public class Student extends Person {

	// the HashMap that will hold the student's courses and grades
	private HashMap<String, Double> courses;

	// constructors

	/**
	 * default constructor, calls the superclass.
	 */
	public Student() {
		super();
	}

	/**
	 * main constructor. calls the superclass for first name, last name, email
	 * address, and BCIT ID,and initializes the courses hashmap.
	 * 
	 * @param firstName    a string, the first name to set
	 * @param lastName     a string, the last name to set
	 * @param emailAddress a string, the email address to set
	 * @param bcitID       a string, the BCIT ID to set
	 */
	public Student(String firstName, String lastName, String emailAddress, String bcitID) {
		super(firstName, lastName, emailAddress, bcitID);

		courses = new HashMap<String, Double>();
	}

	// methods

	/**
	 * method to calculate the student's average grade. if there are no grades
	 * present, returns 0.0;
	 * 
	 * @return averageMarks a double, the student's average grade
	 */
	public double getAverageGrade() {
		double totalMarks = 0;
		double averageMarks = 0;
		if (courses.size() > 0) {
			for (String index : courses.keySet()) {
				totalMarks += courses.get(index);
			}
			averageMarks = totalMarks / courses.size();
		}

		return averageMarks;

	}

	/**
	 * method to add a new course and grade to the hashmap
	 * 
	 * @param courseName  a string, the class name and entry key
	 * @param courseGrade a double, the grade and the entry value
	 */
	public void addCourse(String courseName, double courseGrade) {
		if (courseName != null && courseGrade >= 0) {
			courses.put(courseName, courseGrade);
		}

	}

}
