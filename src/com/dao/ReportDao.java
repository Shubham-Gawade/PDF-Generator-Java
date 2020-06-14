package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReportDao {
	Connection con=null;
	PreparedStatement ps=null;
	
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String password="123456789";
    private String username="system";
    
    public Connection getConnection()
    {
    	
    		try {
				Class.forName(driver);

				System.out.println("Connection Establihed....");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
    		try {
				con=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}			
    		return con;
    }
}
