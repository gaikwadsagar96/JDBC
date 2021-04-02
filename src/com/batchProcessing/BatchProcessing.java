package com.batchProcessing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//not working properly
public class BatchProcessing 
{

	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			PreparedStatement ps=con.prepareStatement("insert into demo values(?,?,?");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("Enter id");
				String s1=br.readLine();
				int id=Integer.parseInt(s1);
				System.out.println("Enter name");
				String name=br.readLine();
				System.out.println("Enter address");
				String s3=br.readLine();
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, s3);
				ps.addBatch();
				System.out.println("Do you want to add more records y/n");
				String ans=br.readLine();
				if(ans.equals("n")) {
					break;
				}
			}
			ps.executeBatch();
			System.out.println("Record successfully saved");
			con.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
