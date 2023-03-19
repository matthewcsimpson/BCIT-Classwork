package ca.bcit.comp3656.assign.database;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ca.bcit.comp3656.assign.domain.User;

public class UserDAO implements DAO {

	private Connection dbC;

	public UserDAO(Connection dbCI) {
		this.dbC = dbCI;
	}

	@Override
	public void create() throws SQLException, FileNotFoundException {
		if (dbC != null) {
			java.sql.Statement create = dbC.createStatement();
			create.executeUpdate(DatabaseDetails.DB_CREATE);
			System.out.println("|-----------------------------------> Table Created");

		}

	}

	@Override
	public void drop() throws SQLException {
		Statement statement = dbC.createStatement();
		String dropString = "DROP TABLE " + DatabaseDetails.DB_TABLE_NAME;
		statement.executeUpdate(dropString);
		System.out.println("|-----------------------------------> Table Dropped");
	}

	@Override
	public void insert() throws SQLException {
		if (dbC != null) {
			Statement create = dbC.createStatement();
			create.executeUpdate(DatabaseDetails.DB_DATA);
			System.out.println("|-----------------------------------> Data Inserted");
		}
	}

	@Override
	public boolean add(User newUser) throws SQLException {
		boolean success = false;

		if (dbC != null && newUser != null) {
			int check = listAll().size();
			Statement addUser = dbC.createStatement();
			String newUserString = "INSERT INTO " + DatabaseDetails.DB_TABLE_NAME
					+ " (id, firstName, lastName, dob) VALUES ('" + newUser.getEmpID() + "', '" + newUser.getfName()
					+ "', '" + newUser.getlName() + "', '" + newUser.getDateOfBirth() + "');";
			addUser.executeUpdate(newUserString);
			int check2 = listAll().size();

			if (check2 > check) {
				success = true;
				return success;
			}
		}
		return success;

	}

	@Override
	public boolean delete(String deleteID) throws SQLException {
		boolean success = false;
		if (dbC != null) {
			int check = listAll().size();
			Statement deleteUser = dbC.createStatement();
			String deleteString = "DELETE FROM " + DatabaseDetails.DB_TABLE_NAME + " WHERE id = '" + deleteID + "'";
			deleteUser.executeUpdate(deleteString);
			int check2 = listAll().size();

			if (check > check2) {
				success = true;
			}
			System.out.println("|-------------------------> " + check + " " + check2 + " " + success);
		}

		return success;

	}

	@Override
	public ArrayList<User> listAll() throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		;
		Statement s = dbC.createStatement();
		String listAllString = "SELECT * FROM " + DatabaseDetails.DB_TABLE_NAME;
		ResultSet rs = s.executeQuery(listAllString);

		User tempUser = null;
		while (rs.next()) {
			tempUser = new User(rs.getString("id"), rs.getString("firstName"), rs.getString("lastName"),
					rs.getString("dob"));
			userList.add(tempUser);
		}

		return userList;

	}

	public User find(String empID) throws SQLException {
		User tempUser = null;
		ArrayList<User> tempList = null;

		tempList = listAll();

		for (int i = 0; i < tempList.size(); i++) {

			if (tempList.get(i).getEmpID().equals(empID)) {
				tempUser = tempList.get(i);
			}
		}
		return tempUser;
	}
}
