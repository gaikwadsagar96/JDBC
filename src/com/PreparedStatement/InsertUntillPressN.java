package com.PreparedStatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUntillPressN {

	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			PreparedStatement ps=con.prepareStatement("insert into demo values(?,?,?)");  

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

			do{  
				System.out.println("enter id:");  
				int id=Integer.parseInt(br.readLine());  
				System.out.println("enter name:");  
				String name=br.readLine();  
				System.out.println("enter address:");  
				String address =br.readLine();  

				ps.setInt(1,id);  
				ps.setString(2,name);  
				ps.setString(3,address);  
				int i=ps.executeUpdate();  
				System.out.println(i+" records affected");  

				System.out.println("Do you want to continue: y/n");  
				String s=br.readLine();  
				if(s.startsWith("n")){  
					break;  
				}  
			}while(true);

		} catch (Exception e){System.out.println(e.getMessage());}
	}

}
