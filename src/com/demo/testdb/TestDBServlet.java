package com.demo.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //setup connections variable
		String user = "springstudent", password = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
	  
		//get connection to the database
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: "+ jdbcUrl);
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
			
			out.println("Connection to the database successful..!");
			
			connection.close();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException();
		}
		
	}
}
