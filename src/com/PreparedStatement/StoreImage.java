package com.PreparedStatement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StoreImage 
{

	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");

			PreparedStatement ps=con.prepareStatement("insert into imgtable values(?,?)");  
			ps.setString(1,"sonoo");  

			FileInputStream fin=new FileInputStream("D:\\pin.png");  
			ps.setBinaryStream(2,fin,fin.available());  
//Syntax	public void setBinaryStream(int paramIndex,InputStream stream,long length); 
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  

			con.close();  
		}catch (Exception e) {e.printStackTrace();} 

	}

}
