package com.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StoreImageInDbPreparedStatement 
{
	public static void main(String[] args) 
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root"); 
			  
			PreparedStatement stmt=con.prepareStatement("insert into demo values(?,?,?)");  
			stmt.setInt(1,99);//1 specifies the first parameter in the query  
			stmt.setString(2,"sagar");
			stmt.setString(3,"Pune");
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  		    
	}
}
