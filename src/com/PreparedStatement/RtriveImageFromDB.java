package com.PreparedStatement;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RtriveImageFromDB 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");

			PreparedStatement ps=con.prepareStatement("select * from imgtable");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Blob b=rs.getBlob(2);//2 means 2nd column data  in which image is store
				byte barr[]=b.getBytes(1,(int)b.length());//1 means first image
				FileOutputStream fout=new FileOutputStream("G:\\sonoo.png");
				fout.write(barr);
				fout.close();
			}
		} catch (Exception e) {e.printStackTrace();}
	}
}


























































