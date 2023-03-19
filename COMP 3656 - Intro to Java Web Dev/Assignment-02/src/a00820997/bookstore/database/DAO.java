package a00820997.bookstore.database;

import java.sql.SQLException;
import java.util.List;

public interface DAO {

	public abstract void add() throws SQLException;

	public abstract void close() throws SQLException;

	public abstract void create() throws SQLException;

	public abstract void delete(int id) throws SQLException;

	public abstract void drop() throws SQLException;

	public abstract List<String> getIds() throws SQLException;

	public abstract void update(int checkID, String column, String newValue) throws SQLException;


}
