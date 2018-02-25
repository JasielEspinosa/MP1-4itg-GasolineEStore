package gasul.dbconnect;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import javax.servlet.*;
import java.sql.*;

@WebListener
public class DatabaseServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Servlet content initialized executed");

		ServletContext context = sce.getServletContext();
		try {
			Class.forName(context.getInitParameter("jdbcDriver"));

/*			Connection connection = DriverManager.getConnection(context.getInitParameter("jdbcURL"), context.getInitParameter("dbUserName"),
					context.getInitParameter("dbPassword"));*/

			Connection connection = DriverManager.getConnection(Security.decrypt(context.getInitParameter("jdbcURL")),
					Security.decrypt(context.getInitParameter("dbUserName")), Security.decrypt(context.getInitParameter("dbPassword")));

			if (connection != null) {
				System.out.println("Connection object is initialized.");

				sce.getServletContext().setAttribute("dbconn", connection);
				System.out.println("Database Connected");
			} else {
				System.err.println("Could not connect to database");
			}

		} catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe.getMessage());
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Servlet content destroyed executed");
	}

}