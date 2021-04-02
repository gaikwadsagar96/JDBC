package com.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateRecord {

	public static void main(String[] args)
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root"); 
			  
			PreparedStatement stmt=con.prepareStatement("update demo set name=? where id=?");  
			stmt.setString(1,"Chetan");//1 specifies the first parameter in the query  
			stmt.setInt(2,99);

			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  		   
	}

}
