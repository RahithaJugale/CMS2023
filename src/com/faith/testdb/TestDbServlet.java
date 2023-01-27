package com.faith.testdb;

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
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String jdbcUrl="jdbc:sqlserver://localhost:1433;databaseName=CMS2023;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		String driver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		
		//Get Connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database:" + jdbcUrl + "\n");
			
			//Connection string
			Class.forName(driver);
			Connection myConnection = DriverManager.getConnection(jdbcUrl);
			out.println("SUCCESS!!!");
			myConnection.close();
			
		}catch (Exception exc){
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}