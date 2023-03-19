package ca.bcit.comp3656.assign.domain;

public class User {

	private String empID;
	private String fName;
	private String lName;
	private String dateOfBirth;
	
	public User() {
		
	}
	
	public User(String empID, String fName, String lName, String dateOfBirth) {
		super();
		this.empID = empID;
		this.fName = fName;
		this.lName = lName;
		this.dateOfBirth = dateOfBirth;
	}



	public String getEmpID() {
		return empID;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	
	@Override
	public String toString() {
		return "<tr><td>" + empID + "</td><td>" + fName + "</td><td>" + lName + "</td><td>" + dateOfBirth + "</td></tr>";
	}

	
}
