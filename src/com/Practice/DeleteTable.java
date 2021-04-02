package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DeleteTable {

	public static void main(String[] args) throws ClassNotFoundException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			Statement stmt=con.createStatement();
			int rs=stmt.executeUpdate("drop table demo2");
			System.out.println("table deleted");
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			
		}
		

	}

}
