/**
 * COMP1451 - Lab 05b
 * 
 * @author Matthew Simpson / A00820997
 * @date Winter 2019
 */

public class Driver {

	public static void main(String[] args) {

		// let's make some people.

		Person johnny = new Person("Johnny", "five", "johnny@shortcircuit.com", "a0180001");
		Person robbie = new Person("Robbie", "Robot", "robbit@lostinspace.com", "a0180002");

		Student bumblebee = new Student("BumbleBee", "Autobot", "bumblebee@cybertron.ca", "a0180003");
		Student ironhide = new Student("ironhide", "autobot", "ironhide@cybertron.ca", "a0180004");
		Student vision = new Student("vision", "nolastname", "vision@avengers.ca", "a0090123");

		Instructor optimus = new Instructor("optimus", "prime", "optimus@cybertron.ca", "a0180005", 26.50);
		Instructor chappie = new Instructor("chappie", "badmovie", "chappie@blompkamp.com", "a0180006", 18.6);

		Database personDatabase = new Database();

		// let's set some grades.

		bumblebee.addCourse("COMP1409", 0.0);
		bumblebee.addCourse("COMP1451", 100);
		bumblebee.addCourse("COMP2613", 0.0);

		ironhide.addCourse("COMP1409", 95.0);
		ironhide.addCourse("COMP1451", 85.8);
		ironhide.addCourse("COMP2613", 75.0);

		// let's add them to the database
		personDatabase.addToDatabase(bumblebee);
		personDatabase.addToDatabase(ironhide);
		personDatabase.addToDatabase(johnny);
		personDatabase.addToDatabase(robbie);
		personDatabase.addToDatabase(optimus);
		personDatabase.addToDatabase(chappie);

		// let's check some data

		System.out.println("example details from each type of person:");
		System.out.println("Person: " + johnny.getFirstName() + " " + johnny.getLastName() + " "
				+ johnny.getEmailAddress() + " " + johnny.getBcitID());
		System.out.println("Student: " + ironhide.getFirstName() + " " + ironhide.getLastName() + " "
				+ ironhide.getEmailAddress() + " " + ironhide.getBcitID() + " " + ironhide.getAverageGrade());
		System.out.println("Instructor: " + optimus.getFirstName() + " " + optimus.getLastName() + " "
				+ optimus.getEmailAddress() + " " + optimus.getBcitID() + " " + optimus.getHourlyWage());
		System.out.println();
		
		System.out.println("Students average grades");
		System.out.println(bumblebee.getFirstName() + "'s average grade: " + bumblebee.getAverageGrade());
		System.out.println(ironhide.getFirstName() + "'s average grade: " + ironhide.getAverageGrade());
		System.out.println(vision.getFirstName() + "'s average grade: " + vision.getAverageGrade());
		System.out.println();

		System.out.println("Print everyone's basic details");
		personDatabase.displayPeople();

	}

}
