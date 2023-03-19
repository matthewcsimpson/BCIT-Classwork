package a00820997.bookstore.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00820997.bookstore.data.Purchase;

public class PurchaseDAO implements DAO {

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

	public PurchaseDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	@Deprecated
	public void add() throws SQLException {
	}

	public void add(Purchase addPurchase) throws SQLException {
		if (connection != null) {
			ArrayList<String> ids = getIds();
			String addPurchaseID = String.valueOf(addPurchase.getPurchaseID());

			if (ids.contains(addPurchaseID) == true) {
				LOG.info("PurchaseID " + addPurchaseID + " already exists in database - skipping.");
			} else {
				String createString = String.format("INSERT INTO %s values('%s', '%s', '%s', '%s')",
						DatabaseNames.purchasesTable, addPurchase.getPurchaseID(), addPurchase.getCustomerID(),
						addPurchase.getBookID(), addPurchase.getPrice());
				Statement statement = connection.createStatement();
				statement.executeUpdate(createString);
				LOG.info("PURCHASE ADDED TO DATABASE: " + createString);
			}
		}
	}

	@Override
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
			LOG.info("PURCHASES CONNECTION CLOSED");
		}
	}

	@Override
	public void create() throws SQLException {
		if (connection != null) {
			String createString = String.format("CREATE TABLE " + DatabaseNames.purchasesTable
					+ " (purchaseID VARCHAR(6), customerID VARCHAR(6), bookID VARCHAR(6), price VARCHAR(8))");
			System.out.println(createString);
			Statement statement = connection.createStatement();
			statement.executeUpdate(createString);
			LOG.info("Table " + DatabaseNames.purchasesTable + " created");
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		if (connection != null) {
			String deleteString = "DELETE FROM " + DatabaseNames.purchasesTable + " WHERE purchaseID = '" + id + "'";
			Statement s = connection.createStatement();
			s.executeUpdate(deleteString);
		}
	}

	@Override
	public void drop() throws SQLException {
		Statement statement = connection.createStatement();
		String dropString = "DROP TABLE " + DatabaseNames.purchasesTable;
		statement.executeUpdate(dropString);
		LOG.info("TABLE " + DatabaseNames.purchasesTable + " Dropped!");
	}

	public Purchase get(int id) throws SQLException {
		Purchase tempPurchase = null;
		if (connection != null) {
			String query = "SELECT * FROM " + DatabaseNames.purchasesTable + " WHERE purchaseID = '" + id + "'";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				tempPurchase = new Purchase.Builder(rs.getInt("purchaseID"), rs.getInt("customerID"),
						rs.getInt("bookID")).price(rs.getFloat("price")).build();
			}
		}
		return tempPurchase;
	}

	@Override
	public ArrayList<String> getIds() throws SQLException {
		ArrayList<String> ids = new ArrayList<String>();
		if (connection != null) {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT purchaseID FROM " + DatabaseNames.purchasesTable);

			while (rs.next()) {
				ids.add(rs.getString("purchaseID"));
			}

			// System.out.println(ids);
		}

		return ids;
	}

	public ArrayList<Purchase> readAll() throws SQLException {
		ArrayList<Purchase> pList = new ArrayList<Purchase>();

		if (connection != null) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + DatabaseNames.purchasesTable);
			System.out.println();

			Purchase tempPurchase = null;
			while (rs.next()) {
				tempPurchase = new Purchase.Builder(rs.getInt("purchaseID"), rs.getInt("customerID"),
						rs.getInt("bookID")).price(rs.getFloat("price")).build();

				pList.add(tempPurchase);
			}

		}
		return pList;
	}

	@Override
	public void update(int checkID, String column, String newValue) throws SQLException {
		if (connection != null) {
			Statement s = connection.createStatement();
			String update = "UPDATE " + DatabaseNames.purchasesTable + " SET " + column + " = '" + newValue
					+ "' WHERE id = '" + checkID + "'";
			s.executeUpdate(update);
		}
	}

}
