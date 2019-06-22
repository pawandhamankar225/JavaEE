package com.vita;

import java.sql.*;
import java.util.ResourceBundle;

public class SingletonConn {
	
      private static Connection conn;
      private static ResourceBundle rb=null;
      static 
      {
    	   rb= ResourceBundle.getBundle("com.vita.getDriver");
    	   try {
			Class.forName(rb.getString("Driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      
	 public static Connection getConnection()
	 {
		 String user=rb.getString("user");
		 String pass=rb.getString("password");
		 try {
			conn=DriverManager.getConnection(rb.getString("url"),user, pass);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn; 
	 }
}
