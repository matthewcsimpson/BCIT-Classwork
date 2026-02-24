package ca.bcit.comp3656.assign;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp3656.assign.database.DatabaseDetails;
import ca.bcit.comp3656.assign.database.UserDAO;
import ca.bcit.comp3656.assign.domain.User;
import ca.bcit.comp3656.assign.domain.Validator;

public class GreetingServlet extends HttpServlet {

	/**
	 * generated serial version ID
	 */
	private static final long serialVersionUID = 8571051370072379363L;
	
	private Connection dbC;
	private UserDAO uDAO;

	@Override
	public void init() throws ServletException {
		System.out.println("|----------------------> " + this.getClass().getName() + " Instantiated!");
		
		try {
			Class.forName(DatabaseDetails.DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			establishDataseConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("|----------------------> " + this.getClass().getName() + " doPost!");	
		String userName = request.getParameter("userName");		
		ArrayList<User> userList = null;
		User checkUser = null;
		if(userName == null || userName.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");	
			try {
				userList = uDAO.listAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("|--------------------------------------------> " + userList);	
			
			request.setAttribute("userList", userList);
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
				try {
					checkUser = uDAO.find(userName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("|--------------------------------------------> " + userList);	
			request.setAttribute("searchResult", checkUser);
			view.forward(request, response);

		}
		String empIDadd = request.getParameter("empID-Add");
		if(empIDadd != null) {
			
			if(Validator.checkID(empIDadd)){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");	
				User temp = new User(request.getParameter("empID-Add"), request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("dateOfBirth"));
				ArrayList<User> userList2 = null;
				try {
					uDAO.add(temp);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					userList2 = uDAO.listAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
				request.setAttribute("userList", userList2);
				dispatcher.forward(request, response);
				
			}
			
		}
		
		String empDelete = request.getParameter("empID-delete");
		if(empDelete != null) {
			if(Validator.checkID(empDelete)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");	
				ArrayList<User> userList3 = null;
				try {
					uDAO.delete(empDelete);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					userList3 = uDAO.listAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
				request.setAttribute("userList", userList3);
				dispatcher.forward(request, response);
			}
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("|----------------------> " + this.getClass().getName() + " doGet!");
		doPost(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("|----------------------> " + this.getClass().getName() + " Destroyed!");
	}
	
	private void establishDataseConnection() throws SQLException, ClassNotFoundException {
		dbC = DriverManager.getConnection(DatabaseDetails.DBURL, DatabaseDetails.DBUSER, DatabaseDetails.DBPASS);
		System.out.println("|----------------------> " + this.getClass().getName() + " database connected!");
		uDAO = new UserDAO(dbC);
	}

}
