package com.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecord {

	public static void main(String[] args) throws SQLException 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			PreparedStatement stmt=con.prepareStatement("delete from demo where id=?");
			stmt.setInt(1, 99);
			stmt.executeUpdate();
			int i=stmt.executeUpdate();
			System.out.println(i+" record affected");
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
