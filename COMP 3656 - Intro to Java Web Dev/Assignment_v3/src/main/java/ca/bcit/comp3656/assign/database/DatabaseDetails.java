package ca.bcit.comp3656.assign.database;

public class DatabaseDetails {

//	public static final String DBDRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
//	public static final String DBURL = "jdbc:derby:derby_jdbc_test;create=true";
//	public static final String DBUSER = "admin";
//	public static final String DBPASS = "admin";
//	public static final String DBNAME = "jspweb";
//	
	public static final String DBDRIVER 		= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DBURL 			= "jdbc:sqlserver://Beangrinder.bcit.ca";
	public static final String DBUSER 			= "javastudent";
	public static final String DBPASS 			= "compjava";
	public static final String DBNAME 			= "jspweb";

	public static final String DB_TABLE_NAME 	= "A00820997_Employees";

	public static final String DB_CREATE 		= "USE jspweb; CREATE TABLE A00820997_Employees (id VARCHAR(9), firstName VARCHAR(250) NOT NULL, lastName VARCHAR(250) NOT NULL, dob DATE, PRIMARY KEY(id))";

	public static final String DB_DATA			= "USE jspweb; INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234562', 'Lisa', 'Simpson', '2003-05-12'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234561', 'Bart', 'Simpson', '2000-02-12'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234563', 'Moe', 'Szyslak', '1968-12-12'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234564', 'Ned', 'Flanders', '1978-01-01'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234565', 'Milhouse', 'Van', '2002-08-23'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234566', 'Apu', 'Nahasapeemape', '1970-11-12'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234567', 'Barney', 'Gumple', '1983-10-02'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234568', 'Waylon', 'Smithers', '1988-05-12'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234569', 'Edna', 'Krabappel', '1979-12-31'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234570', 'Krusty', 'The Clown', '1960-03-09'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234571', 'Patty', 'Bouvier', '1979-02-12'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234572', 'Principal', 'Skinner', '1965-04-19'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234573', 'Martin', 'Prince', '2009-09-22'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234574', 'Kent', 'Brockman', '1960-12-12'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234575', 'Ralph', 'Wiggum', '2001-08-09'); INSERT INTO " + DatabaseDetails.DB_TABLE_NAME + " (id, firstName, lastName, dob) VALUES ('A01234576', 'Nelson', 'Muntz', '1998-11-12');";
			
}
