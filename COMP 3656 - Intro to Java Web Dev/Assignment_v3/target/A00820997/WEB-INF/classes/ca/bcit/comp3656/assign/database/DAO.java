package ca.bcit.comp3656.assign.database;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import ca.bcit.comp3656.assign.domain.User;

public interface DAO {

	public abstract void create() throws SQLException, FileNotFoundException;

	public abstract void drop() throws SQLException;
	
	public abstract void insert() throws SQLException;

	public abstract boolean add(User newUser) throws SQLException;

	public abstract boolean delete(String id) throws SQLException;
	
	public abstract ArrayList<User> listAll() throws SQLException;
	
	public abstract User find(String userID) throws SQLException;
	
}


