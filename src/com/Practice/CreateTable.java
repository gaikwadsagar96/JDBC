package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) 
	{
		//String sql="create table demo6(id int(10),name varchar(20),address varchar(30))";
		String sql="create table filetable(id int, name clob)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.jdbc.Driver
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			Statement statement=connection.createStatement();
			statement.execute(sql);
			System.out.println("table created");
			connection.close();
			
		}
		catch(Exception e){
			System.out.println();
		}
/*		String sql="create table demo(id int(10),name varchar(20),address varchar(30))";
		//String sql="create table filetable(id int, name clob)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.jdbc.Driver
			Connection connection=DriverManager.getConnection("http://103.120.178.161:3306/campinga_res","campinga","2e9atesud");
			Statement statement=connection.createStatement();
			statement.execute(sql);
			System.out.println("table created");
			connection.close();
			
		}
		catch(Exception e){
			System.out.println();
		}
*/

	}

}
