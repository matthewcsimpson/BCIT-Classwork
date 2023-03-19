package a00820997.bookstore.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00820997.bookstore.data.Book;

public class BooksDAO implements DAO {

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

	public BooksDAO(Connection connection) {
		this.connection = connection;

	}

	@Override
	@Deprecated
	public void add() throws SQLException {
	}

	public void add(Book addBook) throws SQLException {
		if (connection != null) {
			List<String> ids = getIds();
			String addBookID = String.valueOf(addBook.getBookID());

			if (ids.contains(addBookID) == true) {
				LOG.info("Book ID " + addBookID + " already exists in database - skipping.");
			} else {
				String createString = String.format(
						"INSERT INTO %s values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
						DatabaseNames.booksTable, addBook.getBookID(), addBook.getIsbn(), addBook.getAuthors(),
						addBook.getOriginalPubYear(), addBook.getOriginalTitle(), addBook.getAvgRating(),
						addBook.getRatingsCount(), addBook.getImageURL());
				Statement statement = connection.createStatement();
				statement.executeUpdate(createString);
				LOG.info("BOOK ADDED TO DATABASE: " + createString);
			}
		}
	}

	@Override
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
			LOG.info("BOOKS CONNECTION CLOSED");
		}
	}

	@Override
	public void create() throws SQLException {
		if (connection != null) {
			String createString = String.format("CREATE TABLE " + DatabaseNames.booksTable
					+ " (bookID VARCHAR(3), isbn VARCHAR(15), authors VARCHAR(100), originalPub VARCHAR(5), originalTitle VARCHAR(150), avgRating VARCHAR(7), ratingsCount VARCHAR(10) , image_url VARCHAR(150), PRIMARY KEY (bookID))");
			Statement statement = connection.createStatement();
			statement.executeUpdate(createString);
			LOG.info("Table " + DatabaseNames.booksTable + " created");
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		if (connection != null) {
			String deleteString = "DELETE FROM " + DatabaseNames.booksTable + " WHERE bookID = '" + id + "'";
			Statement s = connection.createStatement();
			s.executeUpdate(deleteString);
		}
	}

	@Override
	public void drop() throws SQLException {
		Statement statement = connection.createStatement();
		String dropString = "DROP TABLE " + DatabaseNames.booksTable;
		statement.executeUpdate(dropString);
		LOG.info("TABLE " + DatabaseNames.booksTable + " Dropped!");
	}

	public Book get(int id) throws SQLException {
		Book tempBook = null;
		if (connection != null) {
			String query = "SELECT * FROM " + DatabaseNames.booksTable + " WHERE bookID = '" + id + "'";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				tempBook = new Book.Builder(rs.getInt("bookID"), rs.getString("originalTitle"))
						.isbn(rs.getString("isbn")).authors(rs.getString("authors"))
						.originalPubYear(Integer.parseInt(rs.getString("originalPub")))
						.avgRating(Float.parseFloat(rs.getString("avgRating")))
						.ratingsCount(Integer.parseInt(rs.getString("ratingsCount")))
						.imageURL(rs.getString("image_url")).build();
			}
		}
		return tempBook;
	}

	@Override
	public List<String> getIds() throws SQLException {
		List<String> ids = new ArrayList<String>();
		if (connection != null) {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT bookID FROM " + DatabaseNames.booksTable);

			while (rs.next()) {
				ids.add(rs.getString("bookID"));
			}

			// System.out.println(ids);
		}

		return ids;
	}

	public ArrayList<Book> readAll() throws SQLException {
		ArrayList<Book> bookList = new ArrayList<Book>();

		if (connection != null) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + DatabaseNames.booksTable);
			System.out.println();

			Book tempBook = null;
			while (rs.next()) {
				tempBook = new Book.Builder(rs.getInt("bookID"), rs.getString("originalTitle"))
						.isbn(rs.getString("isbn")).authors(rs.getString("authors"))
						.originalPubYear(Integer.parseInt(rs.getString("originalPub")))
						.avgRating(Float.parseFloat(rs.getString("avgRating")))
						.ratingsCount(Integer.parseInt(rs.getString("ratingsCount")))
						.imageURL(rs.getString("image_url")).build();
				bookList.add(tempBook);
			}
		}
		return bookList;
	}

	@Override
	public void update(int checkID, String column, String newValue) throws SQLException {
		// TODO Auto-generated method stub

	}
}
