package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultset {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/multitable","root","root");
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
		ResultSet rs=stmt.executeQuery("select * from employees");  
		  
		//getting the record of 3rd row  
		rs.absolute(4);  
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));  
		  
		con.close();

	}
	
	/*
	103 Alexander Hunold*/

}
