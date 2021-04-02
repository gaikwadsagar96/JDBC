package com.Practice;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
public class RowSet {

	public static void main(String[] args) throws Exception 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			JdbcRowSet rowSet=RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/practice");
			rowSet.setUsername("root");
			rowSet.setPassword("root");
			rowSet.setCommand("select * from demo");
			while(rowSet.next())
			{
				System.out.println("Id: "+rowSet.getString(1));
				System.out.println("name: "+rowSet.getString(2));
				System.out.println("address: "+rowSet.getString(3));
			}
		
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
		
		

	}

}
