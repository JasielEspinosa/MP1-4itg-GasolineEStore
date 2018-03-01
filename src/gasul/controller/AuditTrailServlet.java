package gasul.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gasul.dbconnect.Security;
import gasul.model.*;

/*@WebServlet("")*/
public class AuditTrailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Connection connection;

	private static ResultSet rs;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//"SELECT FirstName, LastName, Gasul, TotalAmount, OrderDate, OrderTime FROM CustomerPurchaseTable"; /*WHERE CustomerID = ?";*/
		//(Connection) getServletContext().getAttribute("dbconn");

		getServletContext().log("Running the Audit Trail");
		getServletContext().getRequestDispatcher("/auditTrail.jsp").forward(request, response);

	}
	
}
