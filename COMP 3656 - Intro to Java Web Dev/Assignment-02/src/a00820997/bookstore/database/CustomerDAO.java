package a00820997.bookstore.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00820997.bookstore.data.Customer;;

public class CustomerDAO implements DAO {

	public static String LOG4J_CONFIG_FILENAME = "log4j2.xml";

	private static Logger LOG;
	static {
		configureLogging();
		LOG = LogManager.getLogger();

	}

	/**
	 * Logging
	 */
	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);
		} catch (IOException e) {
			System.out.println(
					String.format("Can't find the log4j logging configuration file %s.", LOG4J_CONFIG_FILENAME));
		}
	}

	Connection connection;

	public CustomerDAO(Connection connection) {
		this.connection = connection;

	}

	@Override
	@Deprecated
	public void add() throws SQLException {
		// TODO Auto-generated method stub

	}

	public void add(Customer addCustomer) throws SQLException {
		if (connection != null) {

			List<String> ids = getIds();

			String addCustomerID = String.valueOf(addCustomer.getId());

			if (ids.contains(addCustomerID) == true) {
				LOG.info("Customer ID " + addCustomerID + " already exists in database - skipping");
			} else {
				String createString = String.format(
						"INSERT INTO %s values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
						DatabaseNames.customerTable, addCustomer.getId(), addCustomer.getFirstName(),
						addCustomer.getLastName(), addCustomer.getStreetName(), addCustomer.getCity(),
						addCustomer.getPostalCode(), addCustomer.getPhoneNumber(), addCustomer.getEmailAddress(),
						addCustomer.getJoinDate());
				Statement statement = connection.createStatement();
				statement.executeUpdate(createString);
				LOG.info("CUSTOMER ADDED TO DATABASE: " + createString);
			}
		}
	}

	@Override
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
			LOG.info("CUSTOMER CONNECTION CLOSED");
		}
	}

	@Override
	public void create() throws SQLException {
		if (connection != null) {
			String createString = String.format("CREATE TABLE " + DatabaseNames.customerTable
					+ " (id VARCHAR(6), firstName VARCHAR(15), lastName VARCHAR(15), street VARCHAR(40), city VARCHAR(25), postalCode VARCHAR(12), phoneNumber VARCHAR(16) , email VARCHAR(40), joinDate DATE, PRIMARY KEY (id))");
			Statement statement = connection.createStatement();
			statement.executeUpdate(createString);
			LOG.info("Table " + DatabaseNames.customerTable + " created");
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		if (connection != null) {
			String deleteString = "DELETE FROM " + DatabaseNames.customerTable + " WHERE id = '" + id + "'";
			Statement s = connection.createStatement();
			s.executeUpdate(deleteString);
		}
	}

	@Override
	public void drop() throws SQLException {
		Statement statement = connection.createStatement();
		String dropString = "DROP TABLE " + DatabaseNames.customerTable;
		statement.executeUpdate(dropString);
		LOG.info("TABLE " + DatabaseNames.customerTable + " Dropped!");
	}

	public Customer get(int id) throws SQLException {
		Customer tempCustomer = null;
		if (connection != null) {
			String query = "SELECT * FROM " + DatabaseNames.customerTable + " WHERE id = '" + id + "'";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				tempCustomer = new Customer.Builder(rs.getInt("id"), rs.getString("phoneNumber"))
						.firstName(rs.getString("firstName")).lastName(rs.getString("lastName"))
						.streetName(rs.getString("street")).city(rs.getString("city"))
						.postalCode(rs.getString("postalCode")).emailAddress(rs.getString("email"))
						.joinDate(LocalDate.parse(rs.getString("joinDate"))).build();
			}
		}

		return tempCustomer;
	}

	@Override
	public List<String> getIds() throws SQLException {
		List<String> ids = new ArrayList<String>();
		if (connection != null) {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT id FROM " + DatabaseNames.customerTable);

			while (rs.next()) {
				ids.add(rs.getString("id"));
			}

			// System.out.println(ids);
		}

		return ids;
	}

	public ArrayList<Customer> readAll() throws SQLException {
		ArrayList<Customer> custList = new ArrayList<Customer>();
		if (connection != null) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + DatabaseNames.customerTable);
			System.out.println();

			Customer tempCustomer = null;
			while (rs.next()) {
				tempCustomer = new Customer.Builder(rs.getInt("id"), rs.getString("phoneNumber"))
						.firstName(rs.getString("firstName")).lastName(rs.getString("lastName"))
						.streetName(rs.getString("street")).city(rs.getString("city"))
						.postalCode(rs.getString("postalCode")).emailAddress(rs.getString("email"))
						.joinDate(LocalDate.parse(rs.getString("joinDate"))).build();

				custList.add(tempCustomer);
			}
		}
		return custList;

	}

	@Override
	public void update(int checkID, String column, String newValue) throws SQLException {
		if (connection != null) {
			Statement s = connection.createStatement();
			String update = "UPDATE " + DatabaseNames.customerTable + " SET " + column + " = '" + newValue
					+ "' WHERE id = '" + checkID + "'";
			s.executeUpdate(update);
		}
	}

}
