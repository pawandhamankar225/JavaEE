package com.vita;

import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Connection conn=null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		conn=SingletonConn.getConnection();
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String login=request.getParameter("login");
			String pass=request.getParameter("password");
			
			PreparedStatement pst=conn.prepareStatement("insert into register values (?, ?, ? ,?, ?)");
			pst.setString(1, name);
			pst.setString(2, address);
			pst.setString(3, email);
			pst.setString(4, login);
			pst.setString(5, pass);
			
			int res=pst.executeUpdate();
			
			if (res > 0)
			{
				response.getWriter().println("Record is added: ");
			}
			else
			{
				response.getWriter().println("Record is added: ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
