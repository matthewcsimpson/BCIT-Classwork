package a00820997.bookstore.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00820997.bookstore.data.Book;
import a00820997.bookstore.data.Customer;
import a00820997.bookstore.data.Purchase;
import a00820997.bookstore.data.Purchase.PurchaseHistory;
import a00820997.bookstore.database.BooksDAO;
import a00820997.bookstore.database.CustomerDAO;
import a00820997.bookstore.database.PurchaseDAO;
import a00820997.bookstore.sort.Comparators;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

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
	private JPanel contentPane;

	private CustomerDAO cDAO;
	private BooksDAO bDAO;

	private PurchaseDAO pDAO;
	private Comparators c;
	boolean byAuthor = false;
	boolean descending = false;
	String custID;
	ArrayList<PurchaseHistory> history;

	ArrayList<PurchaseHistory> historyID;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public MainFrame(CustomerDAO cDAO, BooksDAO bDAO, PurchaseDAO pDAO) throws SQLException {
		this.cDAO = cDAO;
		this.bDAO = bDAO;
		this.pDAO = pDAO;
		c = new Comparators();
		history = listPurchases();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmDrop = new JMenuItem("Drop");
		mntmDrop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Drop dialog = new Drop(cDAO, bDAO, pDAO);
					dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					LOG.error(e1.getMessage());
				}
			}
		});
		mntmDrop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnFile.add(mntmDrop);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quit();
			}
		});
		mntmQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnFile.add(mntmQuit);

		JMenu mnBooks = new JMenu("Books");
		menuBar.add(mnBooks);

		JMenuItem mntmCount = new JMenuItem("Count");
		mntmCount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String count = "There are " + countBooks() + " books in the database.";
				JOptionPane.showMessageDialog(MainFrame.this, count, "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnBooks.add(mntmCount);

		JSeparator separator_1 = new JSeparator();
		mnBooks.add(separator_1);

		JCheckBoxMenuItem chckbxmntmByAuthor = new JCheckBoxMenuItem("By Author");
		mnBooks.add(chckbxmntmByAuthor);

		JCheckBoxMenuItem chckbxmntmDescending = new JCheckBoxMenuItem("Descending");
		mnBooks.add(chckbxmntmDescending);

		JSeparator separator_2 = new JSeparator();
		mnBooks.add(separator_2);

		JMenuItem mntmList = new JMenuItem("List");
		mntmList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Book> sortedBooks = null;
				try {
					sortedBooks = bDAO.readAll();
				} catch (SQLException e2) {
					LOG.error(e2.getMessage());
				}

				if (sortedBooks != null) {

					if (chckbxmntmByAuthor.isSelected() == true) {
						sortedBooks.sort(c.new CompareByAuthorName());
					}
					if (chckbxmntmDescending.isSelected() == true) {
						sortedBooks.sort(c.new CompareByAuthorNameDescending());
					}
				}

				try {
					BooksList dialog = new BooksList(sortedBooks);
					dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		mnBooks.add(mntmList);

		JMenu mnCustomers = new JMenu("Customers");
		menuBar.add(mnCustomers);

		JMenuItem mntmCount_1 = new JMenuItem("Count");
		mntmCount_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String count = "There are " + countCustomers() + " customers in the database.";
				JOptionPane.showMessageDialog(MainFrame.this, count, "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnCustomers.add(mntmCount_1);

		JSeparator separator_3 = new JSeparator();
		mnCustomers.add(separator_3);

		JCheckBoxMenuItem chckbxmntmByJoinDate = new JCheckBoxMenuItem("By Join Date");
		mnCustomers.add(chckbxmntmByJoinDate);

		JSeparator separator_4 = new JSeparator();
		mnCustomers.add(separator_4);

		JMenuItem mntmList_1 = new JMenuItem("List");
		mntmList_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Customer> sortedCust = null;
				try {
					sortedCust = cDAO.readAll();
				} catch (SQLException e1) {
					LOG.error(e1.getMessage());
				}

				if (chckbxmntmByJoinDate.isSelected() == true) {
					sortedCust.sort(c.new CompareByJoinDate());
				}

				try {
					CustomerList dialog = new CustomerList(sortedCust, cDAO);
					dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e3) {
					LOG.error(e3.getMessage());
				}

			}
		});
		mnCustomers.add(mntmList_1);

		JMenu mnPurchases = new JMenu("Purchases");
		menuBar.add(mnPurchases);

		JMenuItem mntmTotal = new JMenuItem("Total");
		mntmTotal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					historyID = listById();
				} catch (SQLException e2) {

				}

				if (custID != null) {
					history = historyID;
				}

				String totals = String.format("%.2f", purchaseTotals(history));
				JOptionPane.showMessageDialog(MainFrame.this, totals, "Totals", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		mnPurchases.add(mntmTotal);

		JSeparator separator_5 = new JSeparator();
		mnPurchases.add(separator_5);

		JCheckBoxMenuItem chckbxmntmByLastName = new JCheckBoxMenuItem("By Last Name");
		mnPurchases.add(chckbxmntmByLastName);

		JCheckBoxMenuItem chckbxmntmByTitle = new JCheckBoxMenuItem("By Title");
		mnPurchases.add(chckbxmntmByTitle);

		JSeparator separator_6 = new JSeparator();
		mnPurchases.add(separator_6);

		JCheckBoxMenuItem chckbxmntmDescending_1 = new JCheckBoxMenuItem("Descending");
		mnPurchases.add(chckbxmntmDescending_1);

		JMenuItem mntmFilterByCustomer = new JMenuItem("Filter by Customer ID");
		mntmFilterByCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				custID = JOptionPane.showInputDialog("Please Input Customer ID:");
			}
		});
		mnPurchases.add(mntmFilterByCustomer);

		JSeparator separator_7 = new JSeparator();
		mnPurchases.add(separator_7);

		JMenuItem mntmList_2 = new JMenuItem("List");
		mntmList_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					historyID = listById();
				} catch (SQLException e2) {

				}

				if (custID != null) {
					history = historyID;
				}

				if (chckbxmntmByLastName.isSelected() == true) {
					history.sort(c.new ComparePurchaseByLastName());
				} else if (chckbxmntmDescending_1.isSelected() == true) {
					history.sort(c.new ComparePurchaseByLastNameDescending());
				}
				if (chckbxmntmByTitle.isSelected() == true) {
					history.sort(c.new ComparePurchaseByTitle());
				} else if (chckbxmntmDescending_1.isSelected() == true) {
					history.sort(c.new ComparePurchaseByTitleDescending());
				}

				try {
					PurchaseList dialog = new PurchaseList(history);
					dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					LOG.error(e1.getMessage());
				}
			}
		});

		mnPurchases.add(mntmList_2);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this,
						"COMP 2613 - Assignment 02 \n by Matthew Simpson \n Student a00820997", "About",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[]"));
	}

	private int countBooks() {
		ArrayList<Book> tBooks = null;
		try {
			tBooks = bDAO.readAll();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		return tBooks.size();
	}

	private int countCustomers() {
		ArrayList<Customer> tCustomers = null;
		try {
			tCustomers = cDAO.readAll();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		return tCustomers.size();
	}

	public ArrayList<PurchaseHistory> listById() throws SQLException {
		Purchase p = new Purchase();
		ArrayList<Purchase> purchaseData = pDAO.readAll();
		ArrayList<PurchaseHistory> history = new ArrayList<PurchaseHistory>();
		if (custID != null) {
			for (Purchase pIndex : purchaseData) {
				if (pIndex.getCustomerID() == Integer.parseInt(custID)) {
					String firstName = cDAO.get(pIndex.getCustomerID()).getFirstName();
					String lastName = cDAO.get(pIndex.getCustomerID()).getLastName();
					String title = bDAO.get(pIndex.getBookID()).getOriginalTitle();
					float price = pIndex.getPrice();
					PurchaseHistory newEntry = p.new PurchaseHistory(firstName, lastName, title, price);
					history.add(newEntry);
				}
			}
		}
		return history;

	}

	private ArrayList<PurchaseHistory> listPurchases() throws SQLException {
		Purchase p = new Purchase();
		ArrayList<Purchase> purchaseData = null;
		ArrayList<PurchaseHistory> purchaseHistory = new ArrayList<PurchaseHistory>();
		try {
			purchaseData = pDAO.readAll();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		ArrayList<PurchaseHistory> temp2 = new ArrayList<PurchaseHistory>();
		for (Purchase pIndex : purchaseData) {
			System.out.println(pIndex.toString());
			String firstName = cDAO.get(pIndex.getCustomerID()).getFirstName();
			String lastName = cDAO.get(pIndex.getCustomerID()).getLastName();
			String title = bDAO.get(pIndex.getBookID()).getOriginalTitle();
			float price = pIndex.getPrice();
			PurchaseHistory newEntry = p.new PurchaseHistory(firstName, lastName, title, price);
			temp2.add(newEntry);
		}
		purchaseHistory = temp2;

		return purchaseHistory;
	}

	public float purchaseTotals(ArrayList<PurchaseHistory> history) {

		float total = 0;
		for (PurchaseHistory pIndex : history) {
			total += pIndex.getPrice();
		}

		return total;
	}

	/**
	 * Method to quit the application
	 */
	private void quit() {
		try {
			cDAO.close();
		} catch (SQLException e1) {

		}
		try {
			bDAO.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pDAO.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("See You Later!");
		System.exit(0);
	}
}
