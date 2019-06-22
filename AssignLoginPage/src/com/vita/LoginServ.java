package com.vita;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private static Connection conn=null;
	   public void init ()
	   {
		   conn=SingletonConn.getConnection();
	   }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	// This the doPost Method for Checking the Db values and Enter value And redirect
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("login");
		String pass=request.getParameter("password");
		
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet res=st.executeQuery("select login, password from register");
			
			while (res.next())
			{
			     if (login.equalsIgnoreCase(res.getString(1)) && (pass.equals(res.getString(2))))
			     {
			    	 //RequestDispatcher rs=request.getRequestDispatcher("sucess.html");
			    	 // rs.forward(request, response);
			    	 response.sendRedirect("sucess.html");
			     }
			}
			response.sendRedirect("fail.html");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
