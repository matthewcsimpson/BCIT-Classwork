package a00820997.bookstore.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00820997.bookstore.database.BooksDAO;
import a00820997.bookstore.database.CustomerDAO;
import a00820997.bookstore.database.PurchaseDAO;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Drop extends JDialog {

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
	private CustomerDAO cDAO;

	private BooksDAO bDAO;

	private PurchaseDAO pDAO;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Drop(CustomerDAO cDAO, BooksDAO bDAO, PurchaseDAO pDAO) {
		this.cDAO = cDAO;
		this.bDAO = bDAO;
		this.pDAO = pDAO;

		setBounds(100, 100, 450, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][grow]"));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, "cell 0 0 2 2,grow");
			{
				JTextArea txtrDoYouWant = new JTextArea();
				txtrDoYouWant.setText("Do you want to drop all the database \n tables and exit the application?");
				panel.add(txtrDoYouWant);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dropTables();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * Method to drop all tables.
	 */
	private void dropTables() {
		LOG.info("DROPPING ALL TABLES");
		try {
			cDAO.drop();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		try {
			bDAO.drop();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		try {
			pDAO.drop();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		LOG.info("CLOSING CONNECTIONS");
		try {
			cDAO.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bDAO.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pDAO.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOG.info("EXITING APPLICATION");
		System.exit(0);

	}

}
